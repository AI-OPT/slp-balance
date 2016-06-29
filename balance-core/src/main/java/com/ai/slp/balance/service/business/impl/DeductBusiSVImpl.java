package com.ai.slp.balance.service.business.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.components.mds.MDSClientFactory;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.paas.ipaas.mds.IMessageSender;
import com.ai.slp.balance.api.deduct.param.DeductAccount;
import com.ai.slp.balance.api.deduct.param.DeductParam;
import com.ai.slp.balance.api.deduct.param.ForegiftDeduct;
import com.ai.slp.balance.api.deduct.param.SettleParam;
import com.ai.slp.balance.api.deduct.param.SettleSummary;
import com.ai.slp.balance.api.deduct.param.TransSummary;
import com.ai.slp.balance.constants.BalancesCostants;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.dao.mapper.bo.FunFundBook;
import com.ai.slp.balance.service.atom.interfaces.IDeductAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunFundBookAtomSV;
import com.ai.slp.balance.service.business.interfaces.IDeductBusiSV;
import com.ai.slp.balance.util.FunSubjectUtil;
import com.ai.slp.balance.vo.DeductVo;
import com.ai.slp.balance.vo.DeductVo.TransSummaryVo;
import com.alibaba.fastjson.JSON;
import com.ai.slp.balance.vo.SubjectFundVo;

@Service
@Transactional
public class DeductBusiSVImpl implements IDeductBusiSV {

    private static final Logger log = LogManager.getLogger(DeductBusiSVImpl.class);

    @Autowired
    private IDeductAtomSV deductAtomSV;

    @Autowired
    private IFunFundBookAtomSV funFundBookSV;

    @Override
    public String deductFund(DeductParam param) throws BusinessException {
        log.debug("普通扣款开始");
        /* 参数转化 */
        DeductVo deductVo = new DeductVo();
        BeanUtils.copyProperties(deductVo, param);
        if (!CollectionUtil.isEmpty(param.getTransSummary())) {
            for (TransSummary summary : param.getTransSummary()) {
                BeanUtils.copyProperties(deductVo.createTransSummary(), summary);
            }
        }
        /* 1.数据校验 */
        /* 账户校验 */
        deductAtomSV.validAccountInfo(deductVo.getAccountId(), deductVo.getTenantId(),param.getCheckPwd(),param.getPassword());
        /* 幂等性校验 */
        String paySerialCode = deductAtomSV.validIdempotent(deductVo);
        if (!StringUtil.isBlank(paySerialCode)) {
            return paySerialCode;
        }
        /* 科目校验 */
        // 资金类型只能是现金流 //TODO 现金流的科目类型如何确认
        deductVo.addFundType(BalancesCostants.FunSubject.FundType.CASH);
        deductVo.addFundType(BalancesCostants.FunSubject.FundType.GRANT);
        final Map<Long, SubjectFundVo> subjectList = deductAtomSV.validSubject(deductVo);
        /* 2.账本扣款 */
        DeductVo destDeductVo = new DeductVo();// 存储确定账本后的数据
        BeanUtils.copyProperties(destDeductVo, deductVo);
        long alreadyDeduct = 0;
        if (!CollectionUtil.isEmpty(param.getTransSummary())) {
            for (TransSummaryVo summary : deductVo.getTransSummary()) {
                // 统计扣减的金额
                alreadyDeduct = alreadyDeduct + summary.getAmount();
                // 2.1 账本明确
                if (summary.getBookId() != 0) {
                    // 校验账本
                    deductAtomSV.validFundBook(deductVo.getAccountId(), deductVo.getTenantId(),
                            summary.getBookId());
                    // 单账本扣款
                    deductAtomSV.deductFundBook(deductVo.getAccountId(), summary.getBookId(),
                            summary.getAmount());
                    // copy结果到新对象
                    destDeductVo.addTransSummary(summary.getBookId(), summary.getSubjectId(),
                            summary.getAmount());
                }
                // 2.2 科目明确，账本不明确
                else if (summary.getSubjectId() != 0) {
                    long subjectId = summary.getSubjectId();
                    long amount = summary.getAmount();
                    // 按照科目扣减，扣减结果保存在destDeductVo中
                    this.subjectDecude(deductVo, destDeductVo, subjectId, amount);
                }
            }
        }
        // 2.3账本和科目均不明确的扣减
        if (deductVo.getTotalAmount() > alreadyDeduct) {
            // 需要按照系统规则扣减的金额
            long ruleAmount = deductVo.getTotalAmount() - alreadyDeduct;
            // 按照系统默认自然扣减，扣减结果保存在destDeductVo中
            this.naturalDecude(deductVo, destDeductVo, subjectList, ruleAmount);
        }
        // 3.记录交易订单
        paySerialCode = deductAtomSV.recordFundSerial(destDeductVo);
        destDeductVo.setPaySerialCode(paySerialCode);
        // 4.记录资金流水
        deductAtomSV.recordFundDetail(destDeductVo);
        // 5.更新账户信息余额
        deductAtomSV.addAccountInfoBalance(destDeductVo);
        // 6.异步更新索引表，索引建立在交易订单FUN_FUND_SERIAL表的ACCT_ID1字段上
//        deductAtomSV.sendAtsAddFunFundSerialByAcctIdIdx(destDeductVo);
        //扣款结束，发送MDS消息
        log.info("---发起mds");
        deductVo.setBusiType(BalancesCostants.BusiType.ORDER_CHARGE);
        this.chargeMds(deductVo);
        log.info("---结束mds");
        //
        return paySerialCode;
    }
    /**
     * 扣款业务,发送MDS消息
     * @param request
     * @author zhangzd
     * @ApiDocMethod
     * @ApiCode
     */
    private void chargeMds(DeductVo request) {
        IMessageSender msgSender = MDSClientFactory
                .getSenderClient(BalancesCostants.OrdOrder.SLP_CHARGE_TOPIC);

        msgSender.send(JSON.toJSONString(request), 0);// 第二个参数为分区键，如果不分区，传入0
        log.info("----mds sender success");
    }
    
    /**
     * 按照科目扣减，规则：失效时间越早越️优先
     * 
     * @param deductVo
     *            请求对象
     * @param destDeductVo
     *            扣减结果对象
     * @param subjectId
     *            科目
     * @param amount
     *            该科目下扣减金额
     * @throws BusinessException
     * @author lilg
     */
    private void subjectDecude(DeductVo deductVo, DeductVo destDeductVo, long subjectId, long amount)
            throws BusinessException {
        // 查询可扣减的账本，subsId区分是否从专款上扣减
        List<FunFundBook> fundBookList = funFundBookSV.getSubsValidFundBooksBySubjectId(
                deductVo.getTenantId(), deductVo.getAccountId(), subjectId, deductVo.getSubsId());
        // TODO 是否需要预判科目金额是否充足
        if (CollectionUtil.isEmpty(fundBookList) && amount > 0) {
            throw new BusinessException(ExceptCodeConstants.FunBook.BOOK_NOT_FOUND,
                    "该科目下没有可供扣减的账本，科目ID[" + subjectId + "]");
        }
        // 按照失效时间排序
        Collections.sort(fundBookList, new Comparator<FunFundBook>() {
            public int compare(FunFundBook arg0, FunFundBook arg1) {
                return arg0.getExpireDate().compareTo(arg1.getExpireDate());
            }
        });
        // 多账本扣减
        Map<FunFundBook, Long> resultMap = deductAtomSV.deductFundBook(deductVo.getTenantId(),
                deductVo.getAccountId(), fundBookList, amount);
        long deductAmount = 0;
        for (Map.Entry<FunFundBook, Long> result : resultMap.entrySet()) {
            // copy结果到新对象
            destDeductVo.addTransSummary(result.getKey().getBookId(), subjectId, result.getValue());
            // 统计总扣减金额
            deductAmount = deductAmount + result.getValue();
        }
        if (deductAmount < amount) {
            throw new BusinessException(ExceptCodeConstants.FunBook.BALANCE_NOT_ENOUGH,
                    "该科目下账本余额不足，科目ID[" + subjectId + "]");
        }

    }

    /**
     * 系统自然扣减，规则：科目优先级,失效时间越早越优先
     * 
     * @param deductVo
     *            请求对象
     * @param destDeductVo
     *            扣减结果对象
     * @param subjectList
     *            科目缓存列表
     * @param amount
     *            扣减金额
     * @throws BusinessException
     * @author lilg
     */
    private void naturalDecude(DeductVo deductVo, DeductVo destDeductVo,
            final Map<Long, SubjectFundVo> subjectList, long amount) throws BusinessException {
        // 查询可扣减的账本,subsId区分是否从专款上扣减
        List<FunFundBook> fundBookList = funFundBookSV.getSubsValidFundBooksByFundType(
                deductVo.getTenantId(), deductVo.getAccountId(), deductVo.getFundTypes(),
                deductVo.getSubsId());
        // TODO 是否需要预判科目金额是否充足
        if (CollectionUtil.isEmpty(fundBookList) && amount > 0) {
            throw new BusinessException(ExceptCodeConstants.FunBook.BOOK_NOT_FOUND,
                    "该账户下没有可供扣减的账本，账户ID[" + deductVo.getAccountId() + "]");
        }
        // 按照科目优先级,失效时间排序
        Collections.sort(fundBookList, new Comparator<FunFundBook>() {
            public int compare(FunFundBook arg0, FunFundBook arg1) {
                // 优先从内存List中读取，如果不存在，调用Common服务读取并放入List
                if (!subjectList.containsKey(arg0.getSubjectId())) {
                    subjectList.put(arg0.getSubjectId(),
                            FunSubjectUtil.getSubjectFund(arg0.getTenantId(), arg0.getSubjectId()));
                }
                if (!subjectList.containsKey(arg1.getSubjectId())) {
                    subjectList.put(arg1.getSubjectId(),
                            FunSubjectUtil.getSubjectFund(arg1.getTenantId(), arg1.getSubjectId()));
                }
                SubjectFundVo subject0 = subjectList.get(arg0.getSubjectId());
                SubjectFundVo subject1 = subjectList.get(arg1.getSubjectId());
                if (subject0 == null) {
                    throw new BusinessException(ExceptCodeConstants.Subject.SUBJECT_NOT_FOUND,
                            "资金科目未配置：科目ID=" + arg0.getSubjectId());
                }
                if (subject1 == null) {
                    throw new BusinessException(ExceptCodeConstants.Subject.SUBJECT_NOT_FOUND,
                            "资金科目未配置：科目ID=" + arg1.getSubjectId());
                }
                Long usePri0 = subject0.getUsePri();
                Long usePri1 = subject1.getUsePri();
                int result = usePri0.compareTo(usePri1);
                return result == 0 ? arg0.getExpireDate().compareTo(arg1.getExpireDate()) : result;
            }
        });
        // 多账本扣减
        Map<FunFundBook, Long> resultMap = deductAtomSV.deductFundBook(deductVo.getTenantId(),
                deductVo.getAccountId(), fundBookList, amount);
        long deductAmount = 0;
        for (Map.Entry<FunFundBook, Long> result : resultMap.entrySet()) {
            // copy结果到新对象
            destDeductVo.addTransSummary(result.getKey().getBookId(), result.getKey()
                    .getSubjectId(), result.getValue());
            // 统计总扣减金额
            deductAmount = deductAmount + result.getValue();
        }
        if (deductAmount < amount) {
            throw new BusinessException(ExceptCodeConstants.FunBook.BALANCE_NOT_ENOUGH,
                    "该账户下账本余额不足，账户ID[" + deductVo.getAccountId() + "]");
        }
    }

    @Override
    public String settleAccount(SettleParam param) throws BusinessException {
        log.debug("销账扣款开始");
        /* 参数转化 */
        DeductVo deductVo = new DeductVo();
        BeanUtils.copyProperties(deductVo, param);
        for (SettleSummary summary : param.getTransSummary()) {
            BeanUtils.copyProperties(deductVo.createTransSummary(), summary);
        }
        /* 1.数据校验 */
        /* 账户校验 */
        deductAtomSV.validAccountInfo(deductVo.getAccountId(), deductVo.getTenantId(),param.getCheckPwd(),param.getPassword());
        /* 幂等性校验 */
        String paySerialCode = deductAtomSV.validIdempotent(deductVo);
        if (!StringUtil.isBlank(paySerialCode)) {
            return paySerialCode;
        }
        /* 科目校验 */
        // 资金类型只能是现金流 //TODO 现金流的科目类型如何确认
        deductVo.addFundType(BalancesCostants.FunSubject.FundType.CASH);
        deductVo.addFundType(BalancesCostants.FunSubject.FundType.GRANT);
        deductAtomSV.validSubject(deductVo);
        /* 2.账本扣款 */
        for (TransSummaryVo summary : deductVo.getTransSummary()) {
            // 校验账本
            deductAtomSV.validFundBook(deductVo.getAccountId(), deductVo.getTenantId(),
                    summary.getBookId());
            // 扣减金额
            deductAtomSV.deductFundBook(deductVo.getAccountId(), summary.getBookId(),
                    summary.getAmount());
            // 扣减成功，累加账本金额
            deductVo.setTotalAmount(deductVo.getTotalAmount() + summary.getAmount());
        }
        // 3.记录交易订单
        paySerialCode = deductAtomSV.recordFundSerial(deductVo);
        deductVo.setPaySerialCode(paySerialCode);
        // 4.记录资金流水
        deductAtomSV.recordFundDetail(deductVo);
        // 5.更新账户信息余额
        deductAtomSV.addAccountInfoBalance(deductVo);
        // 6.异步更新索引表，索引建立在交易订单FUN_FUND_SERIAL表的ACCT_ID1字段上
        deductAtomSV.sendAtsAddFunFundSerialByAcctIdIdx(deductVo);
        return paySerialCode;
    }

    @Override
    public String deductForegift(ForegiftDeduct param) throws BusinessException {
        log.debug("押金扣减开始");
        /* 参数转化 */
        DeductVo deductVo = new DeductVo();
        BeanUtils.copyProperties(deductVo, param);
        TransSummaryVo transSummary = deductVo.createTransSummary();
        BeanUtils.copyProperties(transSummary, param);
        /* 1.数据校验 */
        /* 账户校验 */
        deductAtomSV.validAccountInfo(deductVo.getAccountId(), deductVo.getTenantId(),param.getCheckPwd(),param.getPassword());
        /* 幂等性校验 */
        String paySerialCode = deductAtomSV.validIdempotent(deductVo);
        if (!StringUtil.isBlank(paySerialCode)) {
            return paySerialCode;
        }
        /* 科目校验 */
        // 资金类型只能是押金
        deductVo.addFundType(BalancesCostants.FunSubject.FundType.FOREGIFT);
        deductAtomSV.validSubject(deductVo);
        /* 2.账本扣款 */
        for (TransSummaryVo summary : deductVo.getTransSummary()) {
            // 校验账本
            deductAtomSV.validFundBook(deductVo.getAccountId(), deductVo.getTenantId(),
                    summary.getBookId());
            // 扣减金额
            deductAtomSV.deductFundBook(deductVo.getAccountId(), summary.getBookId(),
                    summary.getAmount());
            // 扣减成功，累加账本金额
            deductVo.setTotalAmount(deductVo.getTotalAmount() + summary.getAmount());
        }
        // 3.记录交易订单
        paySerialCode = deductAtomSV.recordFundSerial(deductVo);
        deductVo.setPaySerialCode(paySerialCode);
        // 4.记录资金流水
        deductAtomSV.recordFundDetail(deductVo);
        // 5.更新账户信息余额
        deductAtomSV.addAccountInfoBalance(deductVo);
        // 6.异步更新索引表，索引建立在交易订单FUN_FUND_SERIAL表的ACCT_ID1字段上
        deductAtomSV.sendAtsAddFunFundSerialByAcctIdIdx(deductVo);
        return paySerialCode;

    }

    @Override
    public long deductPartFundByAccount(DeductAccount param) throws BusinessException {
        log.debug("部分扣款开始");
        /* 参数转化 */
        DeductVo deductVo = new DeductVo();
        BeanUtils.copyProperties(deductVo, param);
        /* 1.数据校验 */
        /* 账户校验 */
        deductAtomSV.validAccountInfo(deductVo.getAccountId(), deductVo.getTenantId(),param.getCheckPwd(),param.getPassword());
        /* 幂等性校验 */
        String paySerialCode = deductAtomSV.validIdempotent(deductVo);
        if (!StringUtil.isBlank(paySerialCode)) {
            // 需要返回实际抵扣金额，幂等之后无法返回抵扣金额
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_NOT_VALID, "重复请求");
        }
        /* 科目校验 */
        // 资金类型只能是现金流 //TODO 现金流的科目类型如何确认
        deductVo.addFundType(BalancesCostants.FunSubject.FundType.CASH);
        deductVo.addFundType(BalancesCostants.FunSubject.FundType.GRANT);
        // 按照账户扣减，不需要校验科目
        /* 2.账本扣款 */
        DeductVo destDeductVo = new DeductVo();// 存储确定账本后的数据
        BeanUtils.copyProperties(destDeductVo, deductVo);
        final Map<Long, SubjectFundVo> subjectList = new HashMap<Long, SubjectFundVo>();
        // 查询可扣减的账本,subsId区分是否从专款上扣减
        List<FunFundBook> fundBookList = funFundBookSV.getSubsValidFundBooksByFundType(
                deductVo.getTenantId(), deductVo.getAccountId(), deductVo.getFundTypes(),
                deductVo.getSubsId());
        // TODO 是否需要预判科目金额是否充足
        if (CollectionUtil.isEmpty(fundBookList)) {
            return deductVo.getTotalAmount();
        }
        // 按照科目优先级,失效时间排序
        Collections.sort(fundBookList, new Comparator<FunFundBook>() {
            public int compare(FunFundBook arg0, FunFundBook arg1) {
                // 优先从内存List中读取，如果不存在，调用Common服务读取并放入List
                if (!subjectList.containsKey(arg0.getSubjectId())) {
                    subjectList.put(arg0.getSubjectId(),
                            FunSubjectUtil.getSubjectFund(arg0.getTenantId(), arg0.getSubjectId()));
                }
                if (!subjectList.containsKey(arg1.getSubjectId())) {
                    subjectList.put(arg1.getSubjectId(),
                            FunSubjectUtil.getSubjectFund(arg1.getTenantId(), arg1.getSubjectId()));
                }
                SubjectFundVo subject0 = subjectList.get(arg0.getSubjectId());
                SubjectFundVo subject1 = subjectList.get(arg1.getSubjectId());
                if (subject0 == null) {
                    throw new BusinessException(ExceptCodeConstants.Subject.SUBJECT_NOT_FOUND,
                            "资金科目未配置：科目ID=" + arg0.getSubjectId());
                }
                if (subject1 == null) {
                    throw new BusinessException(ExceptCodeConstants.Subject.SUBJECT_NOT_FOUND,
                            "资金科目未配置：科目ID=" + arg1.getSubjectId());
                }
                Long usePri0 = subject0.getUsePri();
                Long usePri1 = subject1.getUsePri();
                int result = usePri0.compareTo(usePri1);
                return result == 0 ? arg0.getExpireDate().compareTo(arg1.getExpireDate()) : result;
            }
        });
        // 多账本扣减
        Map<FunFundBook, Long> resultMap = deductAtomSV.deductFundBook(deductVo.getTenantId(),
                deductVo.getAccountId(), fundBookList, deductVo.getTotalAmount());
        long deductAmount = 0;
        for (Map.Entry<FunFundBook, Long> result : resultMap.entrySet()) {
            // copy结果到新对象
            destDeductVo.addTransSummary(result.getKey().getBookId(), result.getKey()
                    .getSubjectId(), result.getValue());
            // 统计总扣减金额
            deductAmount = deductAmount + result.getValue();
        }
        // 实际抵扣金额
        destDeductVo.setTotalAmount(deductAmount);
        // 3.记录交易订单
        paySerialCode = deductAtomSV.recordFundSerial(destDeductVo);
        destDeductVo.setPaySerialCode(paySerialCode);
        // 4.记录资金流水
        deductAtomSV.recordFundDetail(destDeductVo);
        // 5.更新账户信息余额
        deductAtomSV.addAccountInfoBalance(destDeductVo);
        // 6.异步更新索引表，索引建立在交易订单FUN_FUND_SERIAL表的ACCT_ID1字段上
        deductAtomSV.sendAtsAddFunFundSerialByAcctIdIdx(destDeductVo);
        return deductVo.getTotalAmount() - deductAmount;
    }
}
