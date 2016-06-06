package com.ai.slp.balance.service.business.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.balance.dao.mapper.bo.FunFundSerialByAcctIdIdx;
import com.ai.slp.balance.service.atom.interfaces.IFunFundSerialAtomSV;
import com.ai.slp.balance.service.business.interfaces.ITableIndexManageSV;

@Service
@Transactional
public class TableIndexManageSVImpl implements ITableIndexManageSV {
    
    private static final Logger log = LogManager.getLogger(TableIndexManageSVImpl.class);

    @Autowired
    private IFunFundSerialAtomSV funFundSerialSV;

    @Override
    public void addFunFundSerialByAcctId(FunFundSerialByAcctIdIdx idx) throws BusinessException {
        log.debug("开始进入创建FunFundSerialByAcctIdIdx业务逻辑服务");
        funFundSerialSV.addIndexAcctId(idx);
    }

}
