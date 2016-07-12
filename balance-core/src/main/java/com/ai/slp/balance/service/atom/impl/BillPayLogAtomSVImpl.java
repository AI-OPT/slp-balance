package com.ai.slp.balance.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.slp.balance.dao.mapper.bo.BillPayLog;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IBillPayLogAtomSV;
@Component
public class BillPayLogAtomSVImpl implements IBillPayLogAtomSV {

	@Override
	public void insert(BillPayLog billPayLog) {

		MapperFactory.getBillPayLogMapper().insert(billPayLog);
	}

}
