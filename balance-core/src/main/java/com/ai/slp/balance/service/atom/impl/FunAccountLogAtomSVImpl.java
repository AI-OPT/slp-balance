package com.ai.slp.balance.service.atom.impl;

import org.springframework.stereotype.Component;

import com.ai.slp.balance.dao.mapper.bo.FunAccountLog;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountLogAtomSV;

/**
 * 账户信息历史记录表基础服务类
 * Date: 2015年8月7日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author fanpw
 */
@Component
public class FunAccountLogAtomSVImpl implements IFunAccountLogAtomSV{

    @Override
    public void saveFunAccountLog(FunAccountLog log) {
        MapperFactory.getFunAccountLogMapper().insertSelective(log);
    }

}
