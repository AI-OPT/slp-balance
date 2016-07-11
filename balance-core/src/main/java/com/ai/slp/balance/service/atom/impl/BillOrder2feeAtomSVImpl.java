package com.ai.slp.balance.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.slp.balance.dao.mapper.bo.BillOrder2fee;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IBillOrder2feeAtomSV;
@Component
public class BillOrder2feeAtomSVImpl implements IBillOrder2feeAtomSV {

	@Override
	public void insert(BillOrder2fee billOrder2fee) {
		MapperFactory.getBillOrder2feeMapper().insert(billOrder2fee);
	}
	/**
	 * 商品类目id查询科目id
	 */
	@Override
	public BillOrder2fee getBillOrder2fee(String productCatId) {
		
		BillOrder2fee billOrder2fee = MapperFactory.getBillOrder2feeMapper().selectByPrimaryKey(productCatId);
		return billOrder2fee;
	}

}
