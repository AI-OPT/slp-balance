package com.ai.runner.center.balance.service.atom.impl;

import com.ai.runner.center.balance.dao.mapper.bo.FunFundBook;
import com.ai.runner.center.balance.dao.mapper.factory.MapperFactory;
import com.ai.runner.center.balance.service.atom.interfaces.IFunFundBookAtomSV;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.runner.center.balance.constants.BalancesCostants;
import com.ai.runner.center.balance.dao.mapper.bo.FunFundBookCriteria;
import com.ai.runner.utils.util.CollectionUtil;
import com.ai.runner.utils.util.DateUtil;

@Component
public class FunFundBookAtomSVImpl implements IFunFundBookAtomSV {
    @Override
    public FunFundBook getBean(String tenantId, long accountId, long bookId) {
        Timestamp sysdate = DateUtil.getSysDate();
        FunFundBookCriteria fundBookExample = new FunFundBookCriteria();
        fundBookExample.createCriteria().andTenantIdEqualTo(tenantId)
                .andAccountIdEqualTo(accountId).andBookIdEqualTo(bookId)
                .andEffectDateLessThanOrEqualTo(sysdate).andExpireDateGreaterThanOrEqualTo(sysdate);
        List<FunFundBook> funFundBookList = MapperFactory.getFunFundBookMapper().selectByExample(
                fundBookExample);
        if (CollectionUtil.isEmpty(funFundBookList)) {
            return null;
        } else {
            return funFundBookList.get(0);
        }

    }

    @Override
    public List<FunFundBook> getBeans(String tenantId, long accountId, List<String> status) {
        Timestamp sysdate = DateUtil.getSysDate();
        FunFundBookCriteria fundBookExample = new FunFundBookCriteria();
        fundBookExample.createCriteria().andTenantIdEqualTo(tenantId)
                .andAccountIdEqualTo(accountId).andBookStatusIn(status)
                .andEffectDateLessThanOrEqualTo(sysdate).andExpireDateGreaterThanOrEqualTo(sysdate);
        return MapperFactory.getFunFundBookMapper().selectByExample(fundBookExample);
    }

    @Override
    public List<FunFundBook> getBeans(String tenantId, long accountId, List<String> status,
            Long subjectId) {
        Timestamp sysdate = DateUtil.getSysDate();
        FunFundBookCriteria fundBookExample = new FunFundBookCriteria();
        fundBookExample.createCriteria().andTenantIdEqualTo(tenantId)
                .andAccountIdEqualTo(accountId).andBookStatusIn(status)
                .andSubjectIdEqualTo(subjectId).andEffectDateLessThanOrEqualTo(sysdate)
                .andExpireDateGreaterThanOrEqualTo(sysdate);
        return MapperFactory.getFunFundBookMapper().selectByExample(fundBookExample);
    }

    @Override
    public List<FunFundBook> getBeans(String tenantId, long accountId, List<String> fundType,
            List<String> status) {
        Timestamp sysdate = DateUtil.getSysDate();
        FunFundBookCriteria fundBookExample = new FunFundBookCriteria();
        fundBookExample.createCriteria().andTenantIdEqualTo(tenantId)
                .andAccountIdEqualTo(accountId).andBookStatusIn(status).andSubjectTypeIn(fundType)
                .andEffectDateLessThanOrEqualTo(sysdate).andExpireDateGreaterThanOrEqualTo(sysdate);
        return MapperFactory.getFunFundBookMapper().selectByExample(fundBookExample);
    }

    @Override
    public List<FunFundBook> getValidFundBooks(String tenantId, long accountId) {
        // TODO 没用到
        return this.getBeans(tenantId, accountId,
                Arrays.asList(new String[] { BalancesCostants.FunFundBook.BookStatus.VALID }));
    }

    @Override
    public List<FunFundBook> getFreezeFundBooks(String tenantId, long accountId) {
        // TODO 没用到
        return this.getBeans(tenantId, accountId,
                Arrays.asList(new String[] { BalancesCostants.FunFundBook.BookStatus.FREEZE }));
    }

    @Override
    public FunFundBook getValidFundBookByBookID(String tennatId, long accountId, long bookId) {
        FunFundBook book = this.getBean(tennatId, accountId, bookId);
        if (book != null
                && BalancesCostants.FunFundBook.BookStatus.VALID.equals(book.getBookStatus())) {
            return book;
        } else {
            return null;
        }

    }

    @Override
    public List<FunFundBook> getValidFundBooksByFundType(String tenantId, long accountId,
            List<String> fundType) {
        return this.getBeans(tenantId, accountId, fundType,
                Arrays.asList(new String[] { BalancesCostants.FunFundBook.BookStatus.VALID }));
    }

    @Override
    public List<FunFundBook> getSubsValidFundBooksByFundType(String tenantId, long accountId,
            List<String> fundType, long subsId) {
        Timestamp sysdate = DateUtil.getSysDate();
        FunFundBookCriteria fundBookExample = new FunFundBookCriteria();
        fundBookExample.createCriteria().andTenantIdEqualTo(tenantId)
                .andAccountIdEqualTo(accountId)
                .andBookStatusEqualTo(BalancesCostants.FunFundBook.BookStatus.VALID)
                .andSubjectTypeIn(fundType).andSubsIdEqualTo(subsId)
                .andEffectDateLessThanOrEqualTo(sysdate).andExpireDateGreaterThanOrEqualTo(sysdate);
        return MapperFactory.getFunFundBookMapper().selectByExample(fundBookExample);
    }

    @Override
    public List<FunFundBook> getValidFundBooksBySubjectId(String tenantId, long accountId,
            long subjectId) {
        // TODO 没人用
        return this.getBeans(tenantId, accountId,
                Arrays.asList(new String[] { BalancesCostants.FunFundBook.BookStatus.VALID }),
                subjectId);
    }

    @Override
    public List<FunFundBook> getSubsValidFundBooksBySubjectId(String tenantId, long accountId,
            long subjectId, long subsId) {
        Timestamp sysdate = DateUtil.getSysDate();
        FunFundBookCriteria fundBookExample = new FunFundBookCriteria();
        fundBookExample.createCriteria().andTenantIdEqualTo(tenantId)
                .andAccountIdEqualTo(accountId)
                .andBookStatusEqualTo(BalancesCostants.FunFundBook.BookStatus.VALID)
                .andSubjectIdEqualTo(subjectId).andSubsIdEqualTo(subsId)
                .andEffectDateLessThanOrEqualTo(sysdate).andExpireDateGreaterThanOrEqualTo(sysdate);
        return MapperFactory.getFunFundBookMapper().selectByExample(fundBookExample);
    }

    @Override
    public void insertFunFundBook(FunFundBook info) {
        MapperFactory.getFunFundBookMapper().insert(info);
    }

    @Override
    public void updateByPrimaryKeySelective(FunFundBook info) {
        MapperFactory.getFunFundBookMapper().updateByPrimaryKeySelective(info);
    }

    @Override
    public int depositBalance(long accountId, long bookId, long amount) {
        return MapperFactory.getFunFundBookAttachMapper().depositBalance(accountId, bookId, amount);
    }

    @Override
    public int deductBalance(long accountId, long bookId, long amount) {
        return MapperFactory.getFunFundBookAttachMapper().deductBalance(accountId, bookId, amount);
    }
}
