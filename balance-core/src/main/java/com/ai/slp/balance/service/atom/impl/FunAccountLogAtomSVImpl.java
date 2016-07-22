package com.ai.slp.balance.service.atom.impl;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.dao.mapper.bo.FunAccountLog;
import com.ai.slp.balance.dao.mapper.bo.FunAccountLogCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.FunAccountLogMapper;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountLogAtomSV;

/**
 * 账户信息历史记录表基础服务类
 * Date: 2015年8月7日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author fanpw
 */
@Component
public class FunAccountLogAtomSVImpl implements IFunAccountLogAtomSV{

    @Override
    public void saveFunAccountLog(FunAccountLog log) {
        MapperFactory.getFunAccountLogMapper().insertSelective(log);
    }

	@Override
	public PageInfo<FunAccountLog> queryCreditSettingRecordPageInfo(String tenantId, Long accountId, Integer pageNo,
			Integer pageSize, Timestamp startTime, Timestamp endTime) {
		FunAccountLogCriteria example = new FunAccountLogCriteria();
		//
		FunAccountLogCriteria.Criteria criteria = example.createCriteria();
		if(!StringUtil.isBlank(tenantId)){
			criteria.andTenantIdEqualTo(tenantId);
		}
		if(null != accountId){
			criteria.andAccountIdEqualTo(accountId);
		}
		if(null != startTime){
			criteria.andUpdateTimeGreaterThanOrEqualTo(startTime);
		}
		if(null != endTime){
			criteria.andUpdateTimeLessThanOrEqualTo(endTime);
		}
		//
		example.setOrderByClause(" update_time desc");
		if (pageNo != null && pageSize != null) {
            example.setLimitStart((pageNo - 1) * pageSize);
            example.setLimitEnd(pageSize);
        }
		//
		PageInfo<FunAccountLog> pageInfo = new PageInfo<FunAccountLog>();
		FunAccountLogMapper mapper = MapperFactory.getFunAccountLogMapper();
		//
		pageInfo.setResult(mapper.selectByExample(example));
        pageInfo.setCount(mapper.countByExample(example));
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);
        //
		return pageInfo;
	}

}
