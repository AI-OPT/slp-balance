//package com.ai.slp.balance.ats.impl;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.ai.slp.balance.ats.interfaces.IAccountIndexTableSV;
//import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByCustIdIdx;
//import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByExternalIdIdx;
//import com.ai.slp.balance.service.business.interfaces.IAccountIndexManageSV;
//
//@Component
//@ATSService
//public class AccountIndexTableSVImpl implements IAccountIndexTableSV {
//
//    private static final Logger log = LogManager.getLogger(AccountIndexTableSVImpl.class);
//
//    String signatureId = PaaSServiceTool.getATSSignatureId();
//
//    @Autowired
//    private IAccountIndexManageSV accountIndexManageSV;
//
//    @Override
//    @ServiceProviderSignature(idFromAttribute = "signatureId")
//    public void insertFunAccountInfoByExternalIdIdx(FunAccountInfoByExternalIdIdx vo) {
//        log.debug("开始写入FunAccountInfoByExternalIdIdx表");
//        accountIndexManageSV.insertFunAccountInfoByExternalIdIdx(vo);
//    }
//
//    @Override
//    @ServiceProviderSignature(idFromAttribute = "signatureId")
//    public void insertFunAccountInfoByCustIdIdx(FunAccountInfoByCustIdIdx vo) {
//        log.debug("开始写入FunAccountInfoByCustIdIdx表");
//        accountIndexManageSV.insertFunAccountInfoByCustIdIdx(vo);
//    }
//
//}
