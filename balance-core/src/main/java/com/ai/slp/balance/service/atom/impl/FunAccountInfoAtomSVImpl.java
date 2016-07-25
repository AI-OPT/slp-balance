package com.ai.slp.balance.service.atom.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfo;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByCustIdIdx;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByCustIdIdxCriteria;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByExternalIdIdx;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByExternalIdIdxCriteria;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountInfoAtomSV;

@Component
public class FunAccountInfoAtomSVImpl implements IFunAccountInfoAtomSV {

    @Override
    public FunAccountInfo getBeanByPrimaryKey(long accountId) {
        return MapperFactory.getFunAccountInfoMapper().selectByPrimaryKey(accountId);
    }

    @Override
    public List<FunAccountInfoByCustIdIdx> getAccountIdByCustId(String tenantId,String custId) {
        FunAccountInfoByCustIdIdxCriteria custIdExample = new FunAccountInfoByCustIdIdxCriteria();
        custIdExample.createCriteria().andTenantIdEqualTo(tenantId).andCustIdEqualTo(custId);
        List<FunAccountInfoByCustIdIdx> accountIdxList = MapperFactory
                .getFunAccountInfoByCustIdIdxMapper().selectByExample(custIdExample);
        return accountIdxList;
    }

    @Override
    public void updateFunAccountInfo(FunAccountInfo info) {
        if (info.getAccountId() == null) {
            throw new BusinessException("", "更新账户表，主键不能为空");
        }
        MapperFactory.getFunAccountInfoMapper().updateByPrimaryKeySelective(info);
    }

    @Override
    public void insertFunAccountInfo(FunAccountInfo info) {
        MapperFactory.getFunAccountInfoMapper().insert(info);
    }

    @Override
    public List<FunAccountInfoByExternalIdIdx> getBeanByExternalIdSystemId(String externalId,
            String systemId) {
        // 创建 查询条件[外部流水ID,系统ID]
        FunAccountInfoByExternalIdIdxCriteria criterial = new FunAccountInfoByExternalIdIdxCriteria();
        criterial.createCriteria().andExternalIdEqualTo(externalId).andSystemIdEqualTo(systemId);
        // 调用 DAO 查询
        List<FunAccountInfoByExternalIdIdx> list = MapperFactory
                .getFunAccountInfoByExternalIdIdxMapper().selectByExample(criterial);
        return list;
    }

    @Override
    public void insertFunAccountInfoByExternalIdIdx(FunAccountInfoByExternalIdIdx vo) {
        // 向 FunAccountInfoByExternalIdIdx 表插入 一条数据
        MapperFactory.getFunAccountInfoByExternalIdIdxMapper().insert(vo);
    }

    @Override
    public void insertFunAccountInfoByCustIdIdx(FunAccountInfoByCustIdIdx vo) {
        // 向 FunAccountInfoByCustIdIdx 表插入一条数据
        MapperFactory.getFunAccountInfoByCustIdIdxMapper().insert(vo);
    }

    @Override
    public int addBalance(long account, long amount) {
        return MapperFactory.getFunAccountInfoAttachMapper().addBalance(account, amount);
    }

    @Override
    public List<FunAccountInfo> getAccountInfoByCustId(String tenantId, String custId) {
        FunAccountInfoCriteria example = new FunAccountInfoCriteria();
        example.createCriteria().andCustIdEqualTo(custId).andTenantIdEqualTo(tenantId);
        return MapperFactory.getFunAccountInfoMapper().selectByExample(example);
    }
    @Override
    public void updateCredit(FunAccountInfo funAccountInfo){
    	FunAccountInfo funAccountInfoNew = new FunAccountInfo();
    	funAccountInfoNew.setAccountId(funAccountInfo.getAccountId());
    	funAccountInfoNew.setCredit(funAccountInfo.getCredit());
    	//
    	MapperFactory.getFunAccountInfoMapper().updateByPrimaryKeySelective(funAccountInfo);
    }
    @Override
    public FunAccountInfo findFunAccountInfoByCreditActiveTimeAndCreditExpireTime(long accountId,Timestamp nowTime){
    	FunAccountInfoCriteria example = new FunAccountInfoCriteria();
    	FunAccountInfoCriteria.Criteria criteria = example.createCriteria();
    	//
    	criteria.andAccountIdEqualTo(accountId);
    	criteria.andCreditActiveTimeLessThanOrEqualTo(nowTime);//生效日期小于等于当前时间
    	criteria.andCreditExpireTimeGreaterThan(nowTime);//失效日期大于当前时间
    	//
    	List<FunAccountInfo> funAccountInfoList = MapperFactory.getFunAccountInfoMapper().selectByExample(example);
    	FunAccountInfo funAccountInfo = null;
    	//
    	if(!CollectionUtil.isEmpty(funAccountInfoList)){
    		funAccountInfo = funAccountInfoList.get(0);
    	}
    	//
    	return funAccountInfo;
    }
}
