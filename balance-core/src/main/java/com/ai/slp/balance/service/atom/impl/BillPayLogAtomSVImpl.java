package com.ai.slp.balance.service.atom.impl;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.dao.mapper.bo.BillPayLog;
import com.ai.slp.balance.dao.mapper.bo.BillPayLogCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.dao.mapper.interfaces.BillPayLogMapper;
import com.ai.slp.balance.service.atom.interfaces.IBillPayLogAtomSV;
@Component
public class BillPayLogAtomSVImpl implements IBillPayLogAtomSV {

	@Override
	public void insert(BillPayLog billPayLog) {

		MapperFactory.getBillPayLogMapper().insert(billPayLog);
	}

	@Override
	public PageInfo<BillPayLog> queryBillPayLogPageInfo(String tenantId, Long accountId, String userId,
			Timestamp startTime, Timestamp endTime,Integer pageNo,Integer pageSize) {
		BillPayLogCriteria example = new BillPayLogCriteria();
		//
		BillPayLogCriteria.Criteria criteria = example.createCriteria();
		//
		criteria.andTenantIdEqualTo(tenantId);
		criteria.andAccountIdEqualTo(accountId);
		if(null != startTime){
			criteria.andPayDateGreaterThanOrEqualTo(startTime);
		}
		if(null != endTime){
			criteria.andPayDateLessThanOrEqualTo(endTime);
		}
		example.setOrderByClause(" pay_date desc");
		//
		if (null != pageNo && null != pageSize) {
            example.setLimitStart((pageNo - 1) * pageSize);
            example.setLimitEnd(pageSize);
        }
		//
		PageInfo<BillPayLog> pageInfo = new PageInfo<BillPayLog>();
		//
		BillPayLogMapper mapper = MapperFactory.getBillPayLogMapper();
		//
		pageInfo.setResult(mapper.selectByExample(example));
        pageInfo.setCount(mapper.countByExample(example));
        pageInfo.setPageNo(pageNo);
        pageInfo.setPageSize(pageSize);
        //
		return pageInfo;
	}

}
