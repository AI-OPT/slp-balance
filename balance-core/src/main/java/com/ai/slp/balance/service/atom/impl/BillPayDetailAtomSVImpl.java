package com.ai.slp.balance.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.slp.balance.dao.mapper.bo.BillPayDetail;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IBillPayDetailAtomSV;
@Component
public class BillPayDetailAtomSVImpl implements IBillPayDetailAtomSV {
	
	@Override
	public void insert(BillPayDetail billPayDetail) {
		MapperFactory.getBillPayDetailMapper().insert(billPayDetail);
		
	}

}
