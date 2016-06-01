package com.ai.slp.balance.service.atom.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.balance.dao.mapper.bo.FunResBookRestAmount;
import com.ai.slp.balance.dao.mapper.bo.FunResBookRestAmountCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IFunResBookRestAmountAtomSV;

@Component
public class FunResBookRestAmountAtomSVImpl implements IFunResBookRestAmountAtomSV {

    @Override
    public void insert(FunResBookRestAmount funResBookRestAmount) {
        MapperFactory.getFunResBookRestAmountMapper().insert(funResBookRestAmount);
    }

    @Override
    public FunResBookRestAmount getBean(String tenantId, long ownerId, int ownerType,
            int resourceType) {
        FunResBookRestAmountCriteria restAmountExample = new FunResBookRestAmountCriteria();
        restAmountExample.createCriteria().andTenantIdEqualTo(tenantId).andOwnerIdEqualTo(ownerId)
                .andOwnerTypeEqualTo(ownerType).andResourceTypeEqualTo(resourceType);
        List<FunResBookRestAmount> restAmountList = MapperFactory.getFunResBookRestAmountMapper()
                .selectByExample(restAmountExample);
        if (CollectionUtil.isEmpty(restAmountList)) {
            return null;
        } else {
            return restAmountList.get(0);
        }
    }

    @Override
    public BigDecimal getAmount(String tenantId, long ownerId, int ownerType, int resourceType) {

        FunResBookRestAmountCriteria restAmountExample = new FunResBookRestAmountCriteria();
        restAmountExample.createCriteria().andTenantIdEqualTo(tenantId).andOwnerIdEqualTo(ownerId)
                .andOwnerTypeEqualTo(ownerType).andResourceTypeEqualTo(resourceType);
        List<FunResBookRestAmount> restAmountList = MapperFactory.getFunResBookRestAmountMapper()
                .selectByExample(restAmountExample);
        if (CollectionUtil.isEmpty(restAmountList)) {
            return BigDecimal.ZERO;
        } else {
            return restAmountList.get(0).getRestAmount();
        }
    }

    @Override
    public int offsetAmount(String tenantId, long ownerId, int ownerType, int resourceType,
            BigDecimal offset) {
        return MapperFactory.getFunResBookRestAmountAttachMapper().offsetAmount(tenantId, ownerId,
                ownerType, resourceType, offset);
    }

}
