package com.ai.runner.center.balance.ats.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.paas.ipaas.ats.consumer.ServiceProviderSignature;
import com.ai.runner.center.balance.ats.interfaces.ITableIndexSV;
import com.ai.runner.center.balance.dao.mapper.bo.FunFundSerialByAcctIdIdx;
import com.ai.runner.center.balance.service.business.interfaces.ITableIndexManageSV;
import com.ai.runner.sdk.ats.annotation.ATSService;
import com.ai.runner.sdk.tools.PaaSServiceTool;

@Component
@ATSService
public class TableIndexSVImpl implements ITableIndexSV {
    
    private static final Logger log = LogManager.getLogger(TableIndexSVImpl.class);
    
    String signatureId = PaaSServiceTool.getATSSignatureId();

    @Autowired
    private ITableIndexManageSV tableIndexManageSV;

    @Override
    @ServiceProviderSignature(idFromAttribute = "signatureId")
    public void addFunFundSerialByAcctIdIdx(FunFundSerialByAcctIdIdx idx) {
        log.debug("开始写入FunFundSerialByAcctIdIdx表");
        tableIndexManageSV.addFunFundSerialByAcctId(idx);
    }

}
