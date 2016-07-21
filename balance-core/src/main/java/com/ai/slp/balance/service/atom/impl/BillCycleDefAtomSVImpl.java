package com.ai.slp.balance.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.balance.dao.mapper.bo.BillCycleDef;
import com.ai.slp.balance.dao.mapper.bo.BillCycleDefCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IBillCycleDefAtomSV;
@Component
public class BillCycleDefAtomSVImpl implements IBillCycleDefAtomSV {

	@Override
	public BillCycleDef getBillCycleDef(Integer billCycleDefId) {
		return (BillCycleDef)MapperFactory.getBillCycleDefMapper().selectByPrimaryKey(billCycleDefId);
	}

	@Override
	public void updateByPrimaryKeySelective(BillCycleDef billCycleDef) {
		MapperFactory.getBillCycleDefMapper().updateByPrimaryKeySelective(billCycleDef);
	}
	/**
	 * 通过账单周期类型、还款时限周期数，还款时限周期类型查询账期定义表
	 */
	public BillCycleDef getBillCycleDef(String billGenType,String postpayType,Integer postpayUnits){
		BillCycleDefCriteria example = new BillCycleDefCriteria();
		//
		BillCycleDefCriteria.Criteria criteria = example.createCriteria();
		criteria.andBillGenTypeEqualTo(billGenType);
		criteria.andPostpayTypeEqualTo(postpayType);
		criteria.andPostpayUnitsEqualTo(postpayUnits);
		//
		List<BillCycleDef> billCycleDefList = MapperFactory.getBillCycleDefMapper().selectByExample(example);
		BillCycleDef billCycleDef = null;
		if(!CollectionUtil.isEmpty(billCycleDefList)){
			billCycleDef = (BillCycleDef)billCycleDefList.get(0);
		}
		//
		return billCycleDef;
	}
	/**
	 * 插入信息
	 */
	public void insertBillCycleDef(BillCycleDef billCycleDef){
		MapperFactory.getBillCycleDefMapper().insert(billCycleDef);
	}
}
