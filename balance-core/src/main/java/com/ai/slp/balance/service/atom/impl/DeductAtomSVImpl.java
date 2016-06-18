package com.ai.slp.balance.service.atom.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.balance.constants.BalancesCostants;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.constants.SeqConstants;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfo;
import com.ai.slp.balance.dao.mapper.bo.FunAccountSet;
import com.ai.slp.balance.dao.mapper.bo.FunFundBook;
import com.ai.slp.balance.dao.mapper.bo.FunFundDetail;
import com.ai.slp.balance.dao.mapper.bo.FunFundSerial;
import com.ai.slp.balance.dao.mapper.bo.FunFundSerialByAcctIdIdx;
import com.ai.slp.balance.service.atom.interfaces.IDeductAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountInfoAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountSetAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunFundBookAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunFundDetailAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunFundSerialAtomSV;
import com.ai.slp.balance.util.FunSubjectUtil;
import com.ai.slp.balance.vo.DeductVo;
import com.ai.slp.balance.vo.DeductVo.TransSummaryVo;
import com.ai.slp.balance.vo.SubjectFundVo;

@Component
public class DeductAtomSVImpl implements IDeductAtomSV {

    private static final Logger log = LogManager.getLogger(DepositAtomSVImpl.class);

    @Autowired
    private IFunFundBookAtomSV funFundBookSV;

    @Autowired
    private IFunFundSerialAtomSV funFundSerialSV;

    @Autowired
    private IFunFundDetailAtomSV funFundDetailSV;

    @Autowired
    private IFunAccountInfoAtomSV funAccountInfoAtomSV;
    

    @Autowired
    private IFunAccountSetAtomSV funAccountSetAtomSV;

//    @Autowired
//    private IATSSenderAtomSV iATSSSenderAtomSV;

    @Override
    public void validAccountInfo(long accountId, String tenantId,int checkPwd,String password) {
        FunAccountInfo accountInfo = funAccountInfoAtomSV.getBeanByPrimaryKey(accountId);
        FunAccountSet accountSet = funAccountSetAtomSV.getFunAccountSet(accountId);
        
        if (accountInfo == null
                || !accountInfo.getTenantId().equals(tenantId)
                || BalancesCostants.FunAccountInfo.AcctStatus.IN_VALID.equals(accountInfo
                        .getAcctStatus())) {
            log.debug("账户信息不存在,租户[{}],账户ID[{}]", tenantId, accountId);
            throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_NOT_FOUND,
                    "账户信息不存在,租户ID[" + tenantId + "],账户ID[" + accountId + "]");
        } else if (BalancesCostants.FunAccountInfo.AcctStatus.FREEZE.equals(accountInfo
                .getAcctStatus())) {
            log.debug("账户已被冻结,租户[{}],账户ID[{}]", tenantId, accountId);
            throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_NOT_FOUND,
                    "账户已被冻结,租户ID[" + tenantId + "],账户ID[" + accountId + "]");
        } 
        
        if(checkPwd==0){
            if(accountSet==null){
                log.debug("账户扩展信息不存在,租户[{}],账户ID[{}]", tenantId, accountId);
                throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_SET_INFO_CHECK_FAILED,
                        "账户扩展信息不存在,租户ID[" + tenantId + "],账户ID[" + accountId + "]"); 
            }else if(!password.equals(accountSet.getPayPassword())){
                throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_SET_INFO_CHECK_FAILED,
                        "账户支付密码错误,租户ID[" + tenantId + "],账户ID[" + accountId + "]"); 
            }
        }
    }

    @Override
    public String validIdempotent(DeductVo vo) {
        FunFundSerial funFundSerial = funFundSerialSV.getBeans(vo.getExternalId(),
                vo.getTenantId(), vo.getSystemId());
        if (funFundSerial != null) {// 幕等，直接成功
            log.info("幂等性校验，该订单已经扣款,直接返回成功。[账户ID=" + vo.getAccountId() + ",扣款流水号="
                    + funFundSerial.getPaySerialCode() + "]");
            return funFundSerial.getPaySerialCode();
        } else {
            return null;
        }
    }

    @Override
    public Map<Long, SubjectFundVo> validSubject(DeductVo vo) {
        Map<Long, SubjectFundVo> fundBookMap = new HashMap<Long, SubjectFundVo>();
        if (CollectionUtil.isEmpty(vo.getTransSummary())) {
            return fundBookMap;
        }
        for (TransSummaryVo summary : vo.getTransSummary()) {
            long subjectId = summary.getSubjectId();
            // 校验科目是否存在
            SubjectFundVo subjectJson = FunSubjectUtil.getSubjectFund(vo.getTenantId(), subjectId);
            if (subjectJson == null) {
                log.debug("科目不存在,科目ID[" + subjectId + "]");
                throw new BusinessException(ExceptCodeConstants.Subject.SUBJECT_NOT_FOUND,
                        "科目不存在,科目ID[" + subjectId + "]");
            }
            // 校验科目类型是否匹配
            if (!BalancesCostants.FunSubject.SubjectType.FUND.equals(subjectJson.getSubjectType())) {
                log.debug("科目类型不是资金科目,科目ID[" + subjectId + "]");
                throw new BusinessException(ExceptCodeConstants.Subject.SUBJECT_NOT_VALID,
                        "科目类型不是资金科目,科目ID[" + subjectId + "]");
            }
            // 校验资金类型是否匹配
            // FunSubjectFund subjectFund =
            // JSON.parseObject(subjectJson.toJSONString(),FunSubjectFund.class);
            if (!vo.getFundTypes().contains(subjectJson.getFundType())) {
                log.debug("科目的资金类型不符合条件,科目ID[" + subjectId + "]");
                throw new BusinessException(ExceptCodeConstants.Subject.SUBJECT_NOT_VALID,
                        "科目的资金类型不符合条件,科目ID[" + subjectId + "]");
            }
            fundBookMap.put(subjectId, subjectJson);
        }
        return fundBookMap;
    }

    @Override
    public void validFundBook(long account, String tenantId, long bookId) {
        // 1.账本校验
        FunFundBook fundBook = funFundBookSV.getValidFundBookByBookID(tenantId, account, bookId);
        if (fundBook == null) {
            log.debug("账本不存在,账本ID[" + bookId + "]");
            throw new BusinessException(ExceptCodeConstants.FunBook.BOOK_NOT_FOUND, "账本不存在,账本ID["
                    + bookId + "]");
        }
    }

    @Override
    public void deductFundBook(long account, long bookId, long amount) {
        // 3.账本金额扣减
        int result = funFundBookSV.deductBalance(account, bookId, amount);
        if (result != 1) {
            // 更新失败
            throw new BusinessException(ExceptCodeConstants.FunBook.BALANCE_NOT_ENOUGH,
                    "账本余额不足,账本ID[" + bookId + "]");
        }
    }

    @Override
    public Map<FunFundBook, Long> deductFundBook(String tenantId, long accountId,
            List<FunFundBook> bookList, long totalAmount) {
        Map<FunFundBook, Long> resultMap = new HashMap<FunFundBook, Long>();
        // 对账本进行扣减
        for (FunFundBook book : bookList) {
            long bookBalance = book.getBalance();
            while (bookBalance > 0 && totalAmount > 0) {// 循环尝试扣减
                long deductAmount = bookBalance < totalAmount ? bookBalance : totalAmount;
                int result = funFundBookSV.deductBalance(accountId, book.getBookId(), deductAmount);
                if (result == 1) {// 扣减成功
                    totalAmount = totalAmount - deductAmount;
                    resultMap.put(book, deductAmount);
                    break;
                } else {// 扣减失败，重新查询余额
                    bookBalance = funFundBookSV.getBean(tenantId, accountId, book.getBookId())
                            .getBalance();
                }
            }
        }
        return resultMap;

    }

    @Override
    public String recordFundSerial(DeductVo vo) {
        FunFundSerial funFundSerial = new FunFundSerial();
        funFundSerial.setPaySerialCode(SeqUtil.getNewId(
                SeqConstants.FUN_FUND_SERIAL$PAY_SERIAL_CODE).toString());
        funFundSerial.setTenantId(vo.getTenantId());
        funFundSerial.setSystemId(vo.getSystemId());
        funFundSerial.setPeerSerialCode(vo.getExternalId());
        funFundSerial.setTotalAmount(vo.getTotalAmount());
        funFundSerial.setAcctId1(vo.getAccountId());
        // funFundSerial.setAcctName1(vo.getAccountInfo().getAcctName());// TODO 是否要保存账户姓名
        funFundSerial.setRemark(vo.getBusiDesc());
        funFundSerial.setOptType(BalancesCostants.FunFundSerial.OptType.DEPOSIT);
        funFundSerial.setPayStatus(BalancesCostants.FunFundSerial.PayStatus.SUCCESS);// TODO 成功？
        funFundSerial.setCreateTime(DateUtil.getSysDate());// TODO 不需要交易时间，只保留创建时间
        funFundSerial.setPayTime(DateUtil.getSysDate()); // FIXME 应该修改表模型，删掉字段
        funFundSerial.setLastStatusDate(DateUtil.getSysDate());
        funFundSerial.setTransSummary("无");// FIXME
        log.debug("记录订单交易FUN_FUND_SERIAL:pay_serial_code=" + funFundSerial.getPaySerialCode());
        funFundSerialSV.insertFunFundSerial(funFundSerial);
        return funFundSerial.getPaySerialCode();
    }

    @Override
    public String recordFundDetail(DeductVo depositVo) {
        if (!CollectionUtil.isEmpty(depositVo.getTransSummary())) {
            for (TransSummaryVo summary : depositVo.getTransSummary()) {
                FunFundDetail funFundDetail = new FunFundDetail();
                funFundDetail.setSerialCode(SeqUtil.getNewId(
                        SeqConstants.FUN_FUND_DETAIL$SERIAL_CODE).toString());
                funFundDetail.setPaySerialCode(depositVo.getPaySerialCode());
                funFundDetail.setAccountId(depositVo.getAccountId());
                funFundDetail.setTotalAmount(summary.getAmount());
                funFundDetail.setBookId(summary.getBookId());
                funFundDetail.setCreateTime(DateUtil.getSysDate());
                funFundDetail.setValueDate(DateUtil.getSysDate());// FIXME 应该修改表模型，删掉字段
                funFundDetail.setBalancePre(0l);// FIXME 应该修改表模型，删掉字段
                funFundDetail.setOptType(BalancesCostants.FunFundSerial.OptType.DEDUCT);
                funFundDetail.setRemark(depositVo.getBusiDesc());
                funFundDetail.setSubjectId(summary.getSubjectId());
                log.debug("记录资金流水FUN_FUND_SERIAL:serial_code=" + funFundDetail.getSerialCode());
                funFundDetailSV.insertFunFundDetail(funFundDetail);
            }
        }
        return depositVo.getPaySerialCode();
    }

    @Override
    public void addAccountInfoBalance(DeductVo vo) {
        /*
         * // 主键和需要更新的字段赋值即可 FunAccountInfo accountInfo = new FunAccountInfo();
         * accountInfo.setAccountId(vo.getAccountId());
         * accountInfo.setTotalBalance(vo.getAccountInfo().getTotalBalance() + vo.getAmount());
         * accountInfo.setBalanceChgDate(DateUtil.getSysDate());
         */
        // TODO
        funAccountInfoAtomSV.addBalance(vo.getAccountId(), vo.getTotalAmount() * -1);
    }

    @Override
    public void sendAtsAddFunFundSerialByAcctIdIdx(DeductVo vo) {
        FunFundSerialByAcctIdIdx idx = new FunFundSerialByAcctIdIdx();
        idx.setAcctId1(vo.getAccountId());
        idx.setPeerSerialCode(vo.getTenantId());
        idx.setTenantId(vo.getTenantId());
        log.debug("异步创建索引FunFundSerialByAcctIdIdx：[AcctId1=" + idx.getAcctId1()
                + ",PeerSerialCode=" + idx.getPeerSerialCode() + ",TenantId=" + idx.getTenantId()
                + "]");
//        iATSSSenderAtomSV.sendAtsAddFunFundSerialByAcctIdIdx(idx);
    }

}
