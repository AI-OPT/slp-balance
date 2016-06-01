package com.ai.slp.balance.service.atom.interfaces;


import com.ai.slp.balance.dao.mapper.bo.FunFundSerial;
import com.ai.slp.balance.dao.mapper.bo.FunFundSerialByAcctIdIdx;

/**
 * 交易订单原子服务，对应表FUN_FUND_SERIAL
 * Date: 2015年8月17日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IFunFundSerialAtomSV {
    /**
     * 根据业务订单流水号、租户ID、系统ID查询，常用于幕等性校验
     * @param peerSerialCode
     * @param tenantId
     * @param systemId
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public FunFundSerial getBeans(String peerSerialCode,String tenantId,String systemId);
    
    /**
     * 新增交易订单
     * @param funFundSerial
     * @author lilg
     * @ApiDocMethod
     */
    public void insertFunFundSerial(FunFundSerial funFundSerial);
    
    /**
     * 在字段ACCT_ID1上添加索引
     * @param idx
     * @author lilg
     * @ApiDocMethod
     */
    public void addIndexAcctId(FunFundSerialByAcctIdIdx idx);
    
}
