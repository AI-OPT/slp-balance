package com.ai.slp.balance.service.atom.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.balance.constants.BalancesCostants;
import com.ai.slp.balance.dao.mapper.bo.FunResOperaDetail;
import com.ai.slp.balance.dao.mapper.bo.FunResOperaDetailCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IFunResOperaDetailAtomSV;

@Component
public class FunResOperaDetailAtomSVImpl implements IFunResOperaDetailAtomSV {

    @Override
    public void insert(FunResOperaDetail funResOperaDetail) {
        MapperFactory.getFunResOperaDetailMapper().insert(funResOperaDetail);
    }

    @Override
    public FunResOperaDetail getBean(String tenantId, String systemId, String externalId,
            int optType) {
        FunResOperaDetailCriteria example = new FunResOperaDetailCriteria();
        example.createCriteria().andTenantIdEqualTo(tenantId).andSystemIdEqualTo(systemId)
                .andExternalIdEqualTo(externalId).andOptTypeEqualTo(optType);
        List<FunResOperaDetail> result = MapperFactory.getFunResOperaDetailMapper()
                .selectByExample(example);
        if (CollectionUtil.isEmpty(result)) {
            return null;
        } else {
            return result.get(0);
        }
    }

    @Override
    public int updateStatus(FunResOperaDetail operaDetail, String status) {
        FunResOperaDetailCriteria example = new FunResOperaDetailCriteria();
        example.createCriteria()
                .andTenantIdEqualTo(operaDetail.getTenantId())
                .andSystemIdEqualTo(operaDetail.getSystemId())
                .andExternalIdEqualTo(operaDetail.getExternalId())
                // 必须加上这个OptType，否则可能不唯一，原记录/被部分抵扣，区别于此
                .andOptTypeEqualTo(operaDetail.getOptType())
                .andOwnerIdEqualTo(operaDetail.getOwnerId())
                .andOwnerTypeEqualTo(operaDetail.getOwnerType())
                .andBookStatusEqualTo(operaDetail.getBookStatus());
        FunResOperaDetail newDetail = new FunResOperaDetail();
        newDetail.setBookStatus(status);
        return MapperFactory.getFunResOperaDetailMapper().updateByExampleSelective(newDetail,
                example);
    }

    @Override
    public List<FunResOperaDetail> getWaitDeduct(int start, int end) {
        List<Integer> optTypes = new ArrayList<Integer>();
        optTypes.add(BalancesCostants.FunResOperaDetail.OptType.DEDUCT);// 抵扣记录
        optTypes.add(BalancesCostants.FunResOperaDetail.OptType.PART_DEDUCT);// 后台程序未抵扣完成时记录的剩余量

        FunResOperaDetailCriteria criteria = new FunResOperaDetailCriteria();
        criteria.createCriteria().andOptTypeIn(optTypes)
                .andBookStatusEqualTo(BalancesCostants.FunResOperaDetail.Status.WAIT_DEDUCT);
        criteria.setOrderByClause("opt_type,opt_time");
        criteria.setLimitStart(start);
        criteria.setLimitEnd(end);
        return MapperFactory.getFunResOperaDetailMapper().selectByExample(criteria);
    }
}
