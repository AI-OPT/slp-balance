package com.ai.slp.balance.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.slp.balance.dao.mapper.bo.FunFundDetail;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IFunFundDetailAtomSV;

@Component
public class FunFundDetailAtomSVImpl implements IFunFundDetailAtomSV {

    @Override
    public void insertFunFundDetail(FunFundDetail funFundDetail) {
        MapperFactory.getFunFundDetailMapper().insert(funFundDetail);
    }

}
