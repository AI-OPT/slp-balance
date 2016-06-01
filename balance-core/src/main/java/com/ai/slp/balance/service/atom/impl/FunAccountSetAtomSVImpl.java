package com.ai.slp.balance.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.slp.balance.dao.mapper.bo.FunAccountSet;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountSetAtomSV;

/**
 * 账户设置基础服务类
 * Date: 2015年8月6日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author fanpw
 */
@Component
public class FunAccountSetAtomSVImpl implements IFunAccountSetAtomSV {

    @Override
    public void modifyFunAccountSet(FunAccountSet param) {
        MapperFactory.getFunAccountSetMapper().updateByPrimaryKeySelective(param);
    }

    @Override
    public FunAccountSet getFunAccountSet(long accountId) {
        return MapperFactory.getFunAccountSetMapper().selectByPrimaryKey(accountId);
    }
    
    @Override
    public void insertFunAccountSet(FunAccountSet info) {
        MapperFactory.getFunAccountSetMapper().insert(info);
    }

}
