package com.ai.slp.balance.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByCustIdIdx;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByExternalIdIdx;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountInfoAtomSV;
import com.ai.slp.balance.service.business.interfaces.IAccountIndexManageSV;

@Service
@Transactional
public class AccountIndexManageSVImpl implements IAccountIndexManageSV {

    @Autowired
    private IFunAccountInfoAtomSV iFunAccountInfoSV;

    @Override
    public void insertFunAccountInfoByExternalIdIdx(FunAccountInfoByExternalIdIdx vo)
            throws BusinessException {
        iFunAccountInfoSV.insertFunAccountInfoByExternalIdIdx(vo);
    }

    @Override
    public void insertFunAccountInfoByCustIdIdx(FunAccountInfoByCustIdIdx vo)
            throws BusinessException {
        iFunAccountInfoSV.insertFunAccountInfoByCustIdIdx(vo);
    }

}
