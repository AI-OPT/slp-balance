package com.ai.slp.balance.service.atom.interfaces;

import java.sql.Timestamp;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.dao.mapper.bo.BillPayLog;

public interface IBillPayLogAtomSV {
	public void insert(BillPayLog billPayLog);
	
	public PageInfo<BillPayLog> queryBillPayLogPageInfo(String tenantId,Long accountId,String userId,Timestamp startTime,Timestamp endTime,Integer pageNo,Integer pageSize);
}
