package com.ai.slp.balance.service.atom.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.slp.balance.constants.BalancesCostants;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.dao.mapper.bo.FunResBook;
import com.ai.slp.balance.dao.mapper.bo.FunResBookCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IFunResBookAtomSV;

@Component
public class FunResBookAtomSVImpl implements IFunResBookAtomSV {

    @Override
    public void insert(FunResBook funResBook) {
        MapperFactory.getFunResBookMapper().insert(funResBook);
    }

    @Override
    public List<FunResBook> getResPgkBook(String tenantId, long ownerId, int ownerType) {
        Timestamp systime = DateUtil.getSysDate();
        FunResBookCriteria resBookExample = new FunResBookCriteria();
        resBookExample.createCriteria().andOwnerIdEqualTo(ownerId).andOwnerTypeEqualTo(ownerType)
                .andTenantIdEqualTo(tenantId).andEffectTimeLessThanOrEqualTo(systime)
                .andExpireTimeGreaterThanOrEqualTo(systime)
                .andBookStatusEqualTo(BalancesCostants.FunResBook.BookStatus.VALID)
                .andSourceTypeEqualTo(BalancesCostants.FunResBook.SourceType.PRODUCT_ORDER);
        return MapperFactory.getFunResBookMapper().selectByExample(resBookExample);
    }

    @Override
    public List<FunResBook> getValidResBookByResourceType(String tenantId, long ownerId,
            int ownerType, int resourceType) {
        Timestamp systime = DateUtil.getSysDate();
        FunResBookCriteria resBookExample = new FunResBookCriteria();
        resBookExample.createCriteria().andOwnerIdEqualTo(ownerId).andOwnerTypeEqualTo(ownerType)
                .andTenantIdEqualTo(tenantId).andEffectTimeLessThanOrEqualTo(systime)
                .andExpireTimeGreaterThanOrEqualTo(systime)
                .andBookStatusEqualTo(BalancesCostants.FunResBook.BookStatus.VALID)
                .andResourceTypeEqualTo(resourceType);
        return MapperFactory.getFunResBookMapper().selectByExample(resBookExample);
    }

    @Override
    public FunResBook getValidResBookByBookId(long bookId) {
        return MapperFactory.getFunResBookMapper().selectByPrimaryKey(bookId);
    }

    @Override
    public int deductResBook(long bookId, BigDecimal deduct, String status, long useVersion) {
        FunResBookCriteria resBookExample = new FunResBookCriteria();
        resBookExample.createCriteria().andBookIdEqualTo(bookId).andUseVersionEqualTo(useVersion);
        FunResBook newBook = new FunResBook();
        if (StringUtil.isBlank(status)) {
            newBook.setBookStatus(status);
        }
        newBook.setDeductAmount(deduct);
        newBook.setUseVersion(useVersion + 1);
        return MapperFactory.getFunResBookMapper()
                .updateByExampleSelective(newBook, resBookExample);
    }

    @Override
    public List<FunResBook> getTimeoutResBook(int start, int end) {
        Timestamp systime = DateUtil.getSysDate();
        FunResBookCriteria example = new FunResBookCriteria();
        // 即将失效的有效账本
        example.createCriteria().andBookStatusEqualTo(BalancesCostants.FunResBook.BookStatus.VALID)
                .andExpireTimeLessThanOrEqualTo(systime);
        // 即将生效的待激活账本
        example.or(example.createCriteria()
                .andBookStatusEqualTo(BalancesCostants.FunResBook.BookStatus.UN_ACTIVATED)
                .andEffectTimeGreaterThanOrEqualTo(systime));
        example.setLimitStart(start);
        example.setLimitEnd(end);
        return MapperFactory.getFunResBookMapper().selectByExample(example);
    }

    @Override
    public int updateResBookStatus(long bookId, String status, long useVersion) {
        return MapperFactory.getFunResBookAttachMapper().updateStatus(status, bookId, useVersion);
    }

    @Override
    public BigDecimal activateNoclearBook(FunResBook template) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        FunResBookCriteria example = new FunResBookCriteria();
        // 查询冻结账本
        example.createCriteria().andTenantIdEqualTo(template.getTenantId())
                .andOwnerIdEqualTo(template.getOwnerId())
                .andOwnerTypeEqualTo(template.getOwnerType())
                .andResourceTypeEqualTo(template.getResourceType())
                .andAllowClearEqualTo(BalancesCostants.FunResBook.AllowClear.NO)
                .andBookStatusEqualTo(BalancesCostants.FunResBook.BookStatus.FREEZE);
        List<FunResBook> freezeList = MapperFactory.getFunResBookMapper().selectByExample(example);
        // 激活冻结账本
        for (FunResBook freeze : freezeList) {
            totalAmount = totalAmount.add(freeze.getTotalAmount()
                    .subtract(freeze.getDeductAmount()).subtract(freeze.getExchangeAmount())
                    .subtract(freeze.getPresentAmount()));
            int result = MapperFactory.getFunResBookAttachMapper().updateTime(
                    template.getEffectTime(),
                    template.getEffectTime().compareTo(freeze.getExpireTime()) > 0 ? template
                            .getEffectTime() : freeze.getExpireTime(),
                    BalancesCostants.FunResBook.BookStatus.VALID, freeze.getBookId(),
                    freeze.getUseVersion());
            if (result != 1) {
                throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR,
                        "激活不清零账本失败，版本号过期");
            }
        }
        return totalAmount;
    }

}
