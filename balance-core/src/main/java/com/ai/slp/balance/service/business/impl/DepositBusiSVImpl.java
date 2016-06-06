package com.ai.slp.balance.service.business.impl;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.deposit.param.DepositParam;
import com.ai.slp.balance.api.deposit.param.ForegiftDeposit;
import com.ai.slp.balance.api.deposit.param.TransSummary;
import com.ai.slp.balance.constants.BalancesCostants;
import com.ai.slp.balance.service.atom.interfaces.IDepositAtomSV;
import com.ai.slp.balance.service.business.interfaces.IDepositBusiSV;
import com.ai.slp.balance.vo.DepositVo;
import com.ai.slp.balance.vo.DepositVo.TransSummaryVo;
import com.ai.slp.balance.vo.SubjectFundVo;

@Service
@Transactional
public class DepositBusiSVImpl implements IDepositBusiSV {
    
    private static final Logger log = LogManager.getLogger(DepositBusiSVImpl.class);

    @Autowired
    private IDepositAtomSV depositAtomSV;

    @Override
    public String depositFund(DepositParam param) throws BusinessException {
        /* 参数转化 */
        DepositVo depositVo = new DepositVo();
        BeanUtils.copyProperties(depositVo, param);
        for (TransSummary transSummary : param.getTransSummary()) {
            BeanUtils.copyProperties(depositVo.createTransSummary(), transSummary);
        }
        /* 1.数据校验 */
        /* 账户校验 */
        depositAtomSV.validAccountInfo(depositVo.getAccountId(), depositVo.getTenantId());
        /* 幂等性校验 */
        String paySerialCode = depositAtomSV.validIdempotent(depositVo);
        if (!StringUtil.isBlank(paySerialCode)) {
            return paySerialCode;
        }
        /* 校验科目 */
        // 现金存款，资金类型只能是现金或赠款
        depositVo.addFundType(BalancesCostants.FunSubject.FundType.CASH);
        depositVo.addFundType(BalancesCostants.FunSubject.FundType.GRANT);
        Map<Long, SubjectFundVo> subjectList = depositAtomSV.validSubject(depositVo);
        /* 2 确定账本，更新账本 */
        depositAtomSV.matchFundBook(depositVo, subjectList);
        /* 3.记录交易 */
        // 订单交易流水
        paySerialCode = depositAtomSV.recordFundSerial(depositVo);
        depositVo.setPaySerialCode(paySerialCode);
        // 资金异动流水
        depositAtomSV.recordFundDetail(depositVo);
        // 更新账户信息余额
        depositAtomSV.addAccountInfoBalance(depositVo);
        // 异步更新索引表FUN_FUND_SERIAL_BY_ACCT_ID_IDX
        depositAtomSV.sendAtsAddFunFundSerialByAcctIdIdx(depositVo);
        return paySerialCode;
    }

    @Override
    public String depositForegift(ForegiftDeposit params) throws BusinessException {
        log.debug("进入押金存入业务服务");
        /* 参数转化 */
        DepositVo depositVo = new DepositVo();
        BeanUtils.copyProperties(depositVo, params);
        TransSummaryVo transSummary = depositVo.createTransSummary();
        BeanUtils.copyProperties(transSummary, params);
        // 1.数据校验
        /* 账户校验 */
        depositAtomSV.validAccountInfo(depositVo.getAccountId(), depositVo.getTenantId());
        /* 幂等性校验 */
        String paySerialCode = depositAtomSV.validIdempotent(depositVo);
        if (!StringUtil.isBlank(paySerialCode)) {
            return paySerialCode;
        }
        /* 校验押金科目 */
        // 押金存入，资金类型只能是押金
        depositVo.addFundType(BalancesCostants.FunSubject.FundType.FOREGIFT);
        Map<Long, SubjectFundVo> subjectList = depositAtomSV.validSubject(depositVo);
        // 2.确定账本
        depositAtomSV.matchFundBook(depositVo, subjectList);
        // 3.记录交易订单
        paySerialCode = depositAtomSV.recordFundSerial(depositVo);
        depositVo.setPaySerialCode(paySerialCode);
        // 4.记录资金流水
        depositAtomSV.recordFundDetail(depositVo);
        // 5.更新账户信息余额
        depositAtomSV.addAccountInfoBalance(depositVo);
        // 6.异步更新索引表，索引建立在交易订单FUN_FUND_SERIAL表的ACCT_ID1字段上
        depositAtomSV.sendAtsAddFunFundSerialByAcctIdIdx(depositVo);
        return paySerialCode;
    }

}
