package com.ai.slp.balance.service.business.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.balance.api.fundquery.param.AccountIdParam;
import com.ai.slp.balance.api.fundquery.param.ForegiftInfo;
import com.ai.slp.balance.api.fundquery.param.ForegiftQuery;
import com.ai.slp.balance.api.fundquery.param.FundBook;
import com.ai.slp.balance.api.fundquery.param.FundInfo;
import com.ai.slp.balance.api.fundquery.param.SubjectId;
import com.ai.slp.balance.constants.BalancesCostants;
import com.ai.slp.balance.dao.mapper.bo.FunFundBook;
import com.ai.slp.balance.service.atom.interfaces.IFunFundBookAtomSV;
import com.ai.slp.balance.service.business.interfaces.IFundQueryBusiSV;

@Service
@Transactional
public class FundQueryBusiSVImpl implements IFundQueryBusiSV {

    private static final Logger log = LogManager.getLogger(FundQueryBusiSVImpl.class);

    @Autowired
    private IFunFundBookAtomSV funFundBookSV;

    @Override
    public List<ForegiftInfo> queryForegift(ForegiftQuery param) throws BusinessException {
        log.debug("查询押金");
        List<ForegiftInfo> foregiftInfoList = new ArrayList<ForegiftInfo>();
        List<FunFundBook> funFundBookList;
        List<String> fundType = Arrays
                .asList(new String[] { BalancesCostants.FunSubject.FundType.FOREGIFT });
        if (param.getSubsId() == 0) {
            // 查询所有押金
            funFundBookList = funFundBookSV.getValidFundBooksByFundType(param.getTenantId(),
                    param.getAccountId(), fundType);
        } else {
            // 查询用户专享押金
            funFundBookList = funFundBookSV.getSubsValidFundBooksByFundType(param.getTenantId(),
                    param.getAccountId(), fundType, param.getSubsId());
        }
        if (CollectionUtil.isEmpty(funFundBookList)) {
            return foregiftInfoList;
        }
        // Map<Long, String> subjectNameMap = new HashMap<Long, String>();
        for (FunFundBook funFundBook : funFundBookList) {
            ForegiftInfo foregiftInfo = new ForegiftInfo();
            foregiftInfo.setAccountId(funFundBook.getAccountId());
            foregiftInfo.setAmount(funFundBook.getBalance());
            foregiftInfo.setFundbookId(funFundBook.getBookId());
            foregiftInfo.setSubjectId(funFundBook.getSubjectId());
            foregiftInfo.setTenantId(funFundBook.getTenantId());
            foregiftInfo.setSubsId(funFundBook.getSubsId() == null ? 0 : funFundBook.getSubsId());
            /*
             * if (!subjectNameMap.containsKey(funFundBook.getSubjectId())) { subjectNameMap.put(
             * funFundBook.getSubjectId(), FunSubjectUtil.getSubjectName(funFundBook.getTenantId(),
             * funFundBook.getSubjectId())); }
             * foregiftInfo.setSubjectName(subjectNameMap.get(funFundBook.getSubjectId()));
             */
            foregiftInfoList.add(foregiftInfo);
        }
        return foregiftInfoList;
    }

    @Override
    public FundInfo queryFund(AccountIdParam accountId) throws BusinessException {
        log.debug("按账户ID查询账户余额");
        // 账本状态：有效,冻结
        List<String> status = new ArrayList<String>();
        status.add(BalancesCostants.FunFundBook.BookStatus.VALID);
        status.add(BalancesCostants.FunFundBook.BookStatus.FREEZE);
        // 资金类型:现金,通信现金,通信赠款
        List<String> fundType = Arrays.asList(new String[] {
                BalancesCostants.FunFundBook.FundType.CASH,
                BalancesCostants.FunFundBook.FundType.TELE_CASH,
                BalancesCostants.FunFundBook.FundType.GRANT });
        List<FunFundBook> funFundBookList = funFundBookSV.getBeans(accountId.getTenantId(),
                accountId.getAccountId(), fundType, status);
        return this.assemFundBook(accountId.getTenantId(), accountId.getAccountId(),
                funFundBookList);

    }

    @Override
    public FundInfo queryUsableFund(AccountIdParam accountId) throws BusinessException {
        log.debug("按账户ID查询账户可用余额");
        // 账本状态：有效
        List<String> status = new ArrayList<String>();
        status.add(BalancesCostants.FunFundBook.BookStatus.VALID);
        // 资金类型:现金,通信现金,通信赠款
        List<String> fundType = Arrays.asList(new String[] {
                BalancesCostants.FunFundBook.FundType.CASH,
                BalancesCostants.FunFundBook.FundType.TELE_CASH,
                BalancesCostants.FunFundBook.FundType.GRANT });
        List<FunFundBook> funFundBookList = funFundBookSV.getBeans(accountId.getTenantId(),
                accountId.getAccountId(), fundType, status);
        return this.assemFundBook(accountId.getTenantId(), accountId.getAccountId(),
                funFundBookList);
    }

    @Override
    public FundInfo queryFrozenFund(AccountIdParam accountId) throws BusinessException {
        log.debug("按账户ID查询账户冻结资金");
        // 账本状态：有效
        List<String> status = new ArrayList<String>();
        status.add(BalancesCostants.FunFundBook.BookStatus.FREEZE);
        // 资金类型:现金,通信现金,通信赠款
        List<String> fundType = Arrays.asList(new String[] {
                BalancesCostants.FunFundBook.FundType.CASH,
                BalancesCostants.FunFundBook.FundType.TELE_CASH,
                BalancesCostants.FunFundBook.FundType.GRANT });
        List<FunFundBook> funFundBookList = funFundBookSV.getBeans(accountId.getTenantId(),
                accountId.getAccountId(), fundType, status);
        return this.assemFundBook(accountId.getTenantId(), accountId.getAccountId(),
                funFundBookList);
    }

    @Override
    public FundInfo queryUsableTeleFund(AccountIdParam accountId) throws BusinessException {
        log.debug("按账户ID查询销账可用资金");
        // 账本状态：有效
        List<String> status = new ArrayList<String>();
        status.add(BalancesCostants.FunFundBook.BookStatus.VALID);
        // 资金类型:通信现金,通信赠款
        List<String> fundType = Arrays.asList(new String[] {
                BalancesCostants.FunFundBook.FundType.TELE_CASH,
                BalancesCostants.FunFundBook.FundType.GRANT });
        List<FunFundBook> funFundBookList = funFundBookSV.getBeans(accountId.getTenantId(),
                accountId.getAccountId(), fundType, status);
        FundInfo result = this.assemFundBook(accountId.getTenantId(), accountId.getAccountId(),
                funFundBookList);
        log.debug("对返回结果排序");
        Collections.sort(result.getFundBooks(), new Comparator<FundBook>() {
            @Override
            public int compare(FundBook o1, FundBook o2) {
                return o1.getExpireDate().compareTo(o2.getExpireDate());
            }
        });
        return result;
    }

    @Override
    public FundInfo queryFund(SubjectId subjectId) throws BusinessException {
        log.debug("按账户ID查询账户余额");
        // 账本状态：有效,冻结
        List<String> status = new ArrayList<String>();
        status.add(BalancesCostants.FunFundBook.BookStatus.VALID);// FIXME 确定要查询的状态
        List<FunFundBook> funFundBookList = funFundBookSV.getBeans(subjectId.getTenantId(),
                subjectId.getAccountId(), status, subjectId.getSubjectId());
        return this.assemFundBook(subjectId.getTenantId(), subjectId.getAccountId(),
                funFundBookList);
    }

    /**
     * 组装返回参数
     * 
     * @param tenantId
     * @param accountId
     * @param status
     * @param fundType
     * @return
     * @author lilg
     */
    private FundInfo assemFundBook(String tenantId, long accountId, List<FunFundBook> bookList) {
        // 1.初始化返回参数
        long balance = 0;
        FundInfo fundInfo = new FundInfo();
        fundInfo.setAccountId(accountId);
        fundInfo.setTenantId(tenantId);
        fundInfo.setBalance(balance);
        List<FundBook> fundBooks = new ArrayList<FundBook>();
        fundInfo.setFundBooks(fundBooks);
        // 3.处理查询结果
        if (CollectionUtil.isEmpty(bookList)) {
            return fundInfo;
        }
        for (FunFundBook funFundBook : bookList) {
            balance = balance + funFundBook.getBalance();
            FundBook fundBook = new FundBook();
            fundBook.setBookId(funFundBook.getBookId());
            fundBook.setBalance(funFundBook.getBalance());
            fundBook.setSubjectId(funFundBook.getSubjectId());
            fundBook.setSubsId(funFundBook.getSubsId() == null ? 0 : funFundBook.getSubsId());
            fundBook.setEffectDate(funFundBook.getEffectDate());
            fundBook.setExpireDate(funFundBook.getExpireDate());
            fundBooks.add(fundBook);
        }
        fundInfo.setBalance(balance);
        return fundInfo;
    }

}
