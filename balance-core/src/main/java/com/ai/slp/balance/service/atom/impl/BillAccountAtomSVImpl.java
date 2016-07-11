package com.ai.slp.balance.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.slp.balance.dao.mapper.bo.BillAccount;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IBillAccountAtomSV;
@Component
public class BillAccountAtomSVImpl implements IBillAccountAtomSV {

	@Override
	public void insert(BillAccount billAccount) {

		MapperFactory.getBillAccountMapper().insert(billAccount);
	}

}
