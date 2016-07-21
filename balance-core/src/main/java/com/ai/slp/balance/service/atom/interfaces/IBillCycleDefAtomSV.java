package com.ai.slp.balance.service.atom.interfaces;

import com.ai.slp.balance.dao.mapper.bo.BillCycleDef;

public interface IBillCycleDefAtomSV {
	public BillCycleDef getBillCycleDef(Integer billCycleDefId);
	public void updateByPrimaryKeySelective(BillCycleDef billCycleDef);
	
	public void insertBillCycleDef(BillCycleDef billCycleDef);
	
	public BillCycleDef getBillCycleDef(String billGenType,String postpayType,Integer postpayUnits);
}
