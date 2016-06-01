package com.ai.slp.balance.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.slp.balance.dao.mapper.bo.FunAccountSetLog;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountSetLogAtomSV;

/**
 * 账户设置历史记录基础服务类
 * Date: 2015年8月7日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author fanpw
 */
@Component
public class FunAccountSetLogAtomSVImpl implements IFunAccountSetLogAtomSV {

    @Override
    public void saveFunAccountSetLog(FunAccountSetLog log) {
        MapperFactory.getFunAccountSetLogMapper().insertSelective(log);
    }

}
