package com.ai.slp.balance.service.atom.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
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
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.slp.balance.constants.BalancesCostants;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.constants.SeqConstants;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfo;
import com.ai.slp.balance.dao.mapper.bo.FunFundBook;
import com.ai.slp.balance.dao.mapper.bo.FunFundDetail;
import com.ai.slp.balance.dao.mapper.bo.FunFundSerial;
import com.ai.slp.balance.dao.mapper.bo.FunFundSerialByAcctIdIdx;
import com.ai.slp.balance.service.atom.interfaces.IDepositAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountInfoAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunFundBookAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunFundDetailAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunFundSerialAtomSV;
import com.ai.slp.balance.util.FunSubjectUtil;
import com.ai.slp.balance.vo.DepositVo;
import com.ai.slp.balance.vo.DepositVo.TransSummaryVo;
import com.ai.slp.balance.vo.SubjectFundVo;

@Component
public class DepositAtomSVImpl implements IDepositAtomSV {

    private static final Logger log = LogManager.getLogger(DepositAtomSVImpl.class);

    @Autowired
    private IFunFundBookAtomSV funFundBookSV;

    @Autowired
    private IFunFundSerialAtomSV funFundSerialSV;

    @Autowired
    private IFunFundBookAtomSV funFundBookAtomSV;

    @Autowired
    private IFunFundDetailAtomSV funFundDetailSV;

    @Autowired
    private IFunAccountInfoAtomSV funAccountInfoAtomSV;

//    @Autowired
//    private IATSSenderAtomSV iATSSSenderAtomSV;

    @Override
    public void validAccountInfo(long accountId, String tenantId) {
        FunAccountInfo accountInfo = funAccountInfoAtomSV.getBeanByPrimaryKey(accountId);
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
    }

    @Override
    public List<FunFundBook> matchFundBook(DepositVo vo, Map<Long, SubjectFundVo> subjectMap) {
        List<FunFundBook> funFundBookList = new ArrayList<FunFundBook>();
        for (TransSummaryVo summary : vo.getTransSummary()) {
            SubjectFundVo subject = subjectMap.get(summary.getSubjectId());
            // 1.累加账本金额
            vo.setTotalAmount(vo.getTotalAmount() + summary.getAmount());
            // 2.确定账本
            FunFundBook fundBook = null;
            boolean newBook = false;
            if (subject == null) {
                throw new BusinessException(ExceptCodeConstants.Subject.SUBJECT_NOT_FOUND,
                        "资金科目不存在,科目ID[" + summary.getSubjectId() + "]");
            }
            // subsId {0-非专款,其他-用户专款],
            List<FunFundBook> existBookList = funFundBookSV.getSubsValidFundBooksBySubjectId(
                    vo.getTenantId(), vo.getAccountId(), summary.getSubjectId(), vo.getSubsId());
            // 账本ID，金额，生失效时间特殊处理
            if (CollectionUtil.isEmpty(existBookList)
                    || BalancesCostants.FunSubject.ValidType.ADD.equals(subject.getValidType())) {
                // 创建新账本
                newBook = true;
                fundBook = new FunFundBook();
                fundBook.setBookId(SeqUtil.getNewId(SeqConstants.FUN_FUND_BOOK$BOOK_ID));
                fundBook.setBalance(summary.getAmount());
                // 新创建时赋值
                fundBook.setAccountId(vo.getAccountId());
                fundBook.setTenantId(vo.getTenantId());
                fundBook.setSubjectId(subject.getSubjectId());
                fundBook.setSubjectType(subject.getFundType());
                fundBook.setCreateTime(DateUtil.getSysDate());
                fundBook.setBookStatus(BalancesCostants.FunFundBook.BookStatus.VALID);
                fundBook.setSubsId(vo.getSubsId());
            } else {
                // 在旧账本上叠加
                fundBook = existBookList.get(0);
                fundBook.setBalance(fundBook.getBalance() + summary.getAmount());
            }
            if (BalancesCostants.FunSubject.ValidType.MERGE.equals(subject.getValidType())) {
                if (fundBook.getEffectDate() == null) {
                    fundBook.setEffectDate((DateUtil.getSysDate()));
                }
                if (fundBook.getExpireDate() == null) {
                    fundBook.setExpireDate(BalancesCostants.FunFundBook.DefaultDate.expireDate);
                }
            }
            if (BalancesCostants.FunSubject.ValidType.DELAY.equals(subject.getValidType())) {
                if (fundBook.getEffectDate() == null) {
                    fundBook.setEffectDate(StringUtil.isBlank(summary.getFundeffDate()) ? DateUtil
                            .getSysDate() : DateUtil.getTimestamp(summary.getFundeffDate(),
                            DateUtil.DATETIME_FORMAT));
                }
                // 结束时间顺延
                Timestamp expireDate = fundBook.getExpireDate();
                if (!StringUtil.isBlank(summary.getFundexpDate())) {
                    Timestamp summaryDate = DateUtil.getTimestamp(summary.getFundexpDate(),
                            DateUtil.DATETIME_FORMAT);
                    if (expireDate == null) {
                        expireDate = summaryDate;
                    } else {
                        expireDate = expireDate.compareTo(summaryDate) > 0 ? expireDate
                                : summaryDate;
                    }
                } else {
                    if (expireDate == null) {
                        expireDate = BalancesCostants.FunFundBook.DefaultDate.expireDate;
                    }
                }
                fundBook.setExpireDate(expireDate);
            }
            if (BalancesCostants.FunSubject.ValidType.ADD.equals(subject.getValidType())) {
                fundBook.setEffectDate(StringUtil.isBlank(summary.getFundeffDate()) ? DateUtil
                        .getSysDate() : DateUtil.getTimestamp(summary.getFundeffDate(),
                        DateUtil.DATETIME_FORMAT));
                fundBook.setExpireDate(StringUtil.isBlank(summary.getFundexpDate()) ? BalancesCostants.FunFundBook.DefaultDate.expireDate
                        : DateUtil.getTimestamp(summary.getFundexpDate(), DateUtil.DATETIME_FORMAT));
            }
            // 3.更新账本
            if (newBook) {
                funFundBookAtomSV.insertFunFundBook(fundBook);
            } else {
                // TODO 需要考虑实效时间按规则延期的
                funFundBookAtomSV.depositBalance(fundBook.getAccountId(), fundBook.getBookId(),
                        summary.getAmount());
                // funFundBookAtomSV.updateByPrimaryKeySelective(fundBook);
            }
            // 4.账本ID暂存在业务参数里
            summary.setBookId(fundBook.getBookId());
            funFundBookList.add(fundBook);
        }
        return funFundBookList;
    }

    @Override
    public Map<Long, SubjectFundVo> validSubject(DepositVo vo) {
        Map<Long, SubjectFundVo> subjectList = new HashMap<Long, SubjectFundVo>();
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
            if (!vo.getFundTypes().contains(subjectJson.getFundType())) {
                log.debug("科目的资金类型不符合条件,科目ID[" + subjectId + "]");
                throw new BusinessException(ExceptCodeConstants.Subject.SUBJECT_NOT_VALID,
                        "科目的资金类型不符合条件,科目ID[" + subjectId + "] fundType："+subjectJson.getFundType());
            }
            subjectList.put(summary.getSubjectId(), subjectJson);
        }
        return subjectList;
    }

    @Override
    public String validIdempotent(DepositVo vo) {
        FunFundSerial funFundSerial = funFundSerialSV.getBeans(vo.getBusiSerialNo(),
                vo.getTenantId(), vo.getSystemId());
        if (funFundSerial != null) {// 幕等，直接成功
            log.info("幂等性校验，账户信息已创建,直接返回成功，账户ID[" + vo.getAccountId() + "]");
            return funFundSerial.getPaySerialCode();
        } else {
            return null;
        }
    }

    @Override
    public String recordFundSerial(DepositVo vo) {
        FunFundSerial funFundSerial = new FunFundSerial();
        funFundSerial.setPaySerialCode(SeqUtil.getNewId(
                SeqConstants.FUN_FUND_SERIAL$PAY_SERIAL_CODE).toString());
        funFundSerial.setTenantId(vo.getTenantId());
        funFundSerial.setSystemId(vo.getSystemId());
        funFundSerial.setPeerSerialCode(vo.getBusiSerialNo());
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
    public String recordFundDetail(DepositVo depositVo) {
        for (TransSummaryVo summary : depositVo.getTransSummary()) {
            FunFundDetail funFundDetail = new FunFundDetail();
            funFundDetail.setSerialCode(SeqUtil.getNewId(SeqConstants.FUN_FUND_DETAIL$SERIAL_CODE)
                    .toString());
            funFundDetail.setPaySerialCode(depositVo.getPaySerialCode());
            funFundDetail.setAccountId(depositVo.getAccountId());
            funFundDetail.setTotalAmount(summary.getAmount());
            funFundDetail.setBookId(summary.getBookId());
            funFundDetail.setCreateTime(DateUtil.getSysDate());
            funFundDetail.setValueDate(DateUtil.getSysDate());// FIXME 应该修改表模型，删掉字段
            funFundDetail.setBalancePre(0l);// FIXME 应该修改表模型，删掉字段
            funFundDetail.setOptType(BalancesCostants.FunFundSerial.OptType.DEPOSIT);
            funFundDetail.setRemark(depositVo.getBusiDesc());
            funFundDetail.setSubjectId(summary.getSubjectId());
            log.debug("记录资金流水FUN_FUND_SERIAL:serial_code=" + funFundDetail.getSerialCode());
            funFundDetailSV.insertFunFundDetail(funFundDetail);
        }
        return depositVo.getPaySerialCode();
    }

    @Override
    public void addAccountInfoBalance(DepositVo vo) {
        /*
         * // 主键和需要更新的字段赋值即可 FunAccountInfo accountInfo = new FunAccountInfo();
         * accountInfo.setAccountId(vo.getAccountId());
         * accountInfo.setTotalBalance(vo.getAccountInfo().getTotalBalance() + vo.getAmount());
         * accountInfo.setBalanceChgDate(DateUtil.getSysDate());
         */
        // TODO
        funAccountInfoAtomSV.addBalance(vo.getAccountId(), vo.getTotalAmount());
    }

    @Override
    public void sendAtsAddFunFundSerialByAcctIdIdx(DepositVo vo) {
        FunFundSerialByAcctIdIdx idx = new FunFundSerialByAcctIdIdx();
        idx.setAcctId1(vo.getAccountId());
        idx.setPeerSerialCode(vo.getBusiSerialNo());
        idx.setTenantId(vo.getTenantId());
        log.debug("异步创建索引FunFundSerialByAcctIdIdx：[AcctId1=" + idx.getAcctId1()
                + ",PeerSerialCode=" + idx.getPeerSerialCode() + ",TenantId=" + idx.getTenantId()
                + "]");
//        iATSSSenderAtomSV.sendAtsAddFunFundSerialByAcctIdIdx(idx);
    }
}
