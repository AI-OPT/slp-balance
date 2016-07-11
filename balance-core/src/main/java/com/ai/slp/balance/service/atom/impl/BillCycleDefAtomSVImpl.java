package com.ai.slp.balance.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.slp.balance.dao.mapper.bo.BillCycleDef;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IBillCycleDefAtomSV;
@Component
public class BillCycleDefAtomSVImpl implements IBillCycleDefAtomSV {

	@Override
	public BillCycleDef getBillCycleDef(Integer billCycleDefId) {
		return (BillCycleDef)MapperFactory.getBillCycleDefMapper().selectByPrimaryKey(billCycleDefId);
	}

}
