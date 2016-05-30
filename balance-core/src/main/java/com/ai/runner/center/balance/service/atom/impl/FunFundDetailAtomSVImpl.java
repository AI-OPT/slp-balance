package com.ai.runner.center.balance.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.runner.center.balance.dao.mapper.bo.FunFundDetail;
import com.ai.runner.center.balance.dao.mapper.factory.MapperFactory;
import com.ai.runner.center.balance.service.atom.interfaces.IFunFundDetailAtomSV;

@Component
public class FunFundDetailAtomSVImpl implements IFunFundDetailAtomSV {

    @Override
    public void insertFunFundDetail(FunFundDetail funFundDetail) {
        MapperFactory.getFunFundDetailMapper().insert(funFundDetail);
    }

}
