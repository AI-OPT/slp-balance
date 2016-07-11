package com.ai.slp.balance.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.slp.balance.dao.mapper.bo.BillAccount;
import com.ai.slp.balance.dao.mapper.bo.BillAccountKey;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IBillAccountAtomSV;
@Component
public class BillAccountAtomSVImpl implements IBillAccountAtomSV {

	@Override
	public void insert(BillAccount billAccount) {

		MapperFactory.getBillAccountMapper().insert(billAccount);
	}

	@Override
	public BillAccount getBillAccount(BillAccountKey billAccountKey) {
		return MapperFactory.getBillAccountMapper().selectByPrimaryKey(billAccountKey);
		
	}

	@Override
	public void updateBillAccountByPrimaryKeySelective(BillAccount billAccount) {

		MapperFactory.getBillAccountMapper().updateByPrimaryKeySelective(billAccount);
	}

}
