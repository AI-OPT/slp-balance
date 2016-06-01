//package com.ai.slp.balance.ats.impl;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.ai.slp.balance.ats.interfaces.ITableIndexSV;
//import com.ai.slp.balance.dao.mapper.bo.FunFundSerialByAcctIdIdx;
//import com.ai.slp.balance.service.business.interfaces.ITableIndexManageSV;
//
//@Component
//@ATSService
//public class TableIndexSVImpl implements ITableIndexSV {
//    
//    private static final Logger log = LogManager.getLogger(TableIndexSVImpl.class);
//    
//    String signatureId = PaaSServiceTool.getATSSignatureId();
//
//    @Autowired
//    private ITableIndexManageSV tableIndexManageSV;
//
//    @Override
//    @ServiceProviderSignature(idFromAttribute = "signatureId")
//    public void addFunFundSerialByAcctIdIdx(FunFundSerialByAcctIdIdx idx) {
//        log.debug("开始写入FunFundSerialByAcctIdIdx表");
//        tableIndexManageSV.addFunFundSerialByAcctId(idx);
//    }
//
//}
