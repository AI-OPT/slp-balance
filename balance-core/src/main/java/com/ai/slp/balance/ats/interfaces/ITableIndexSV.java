package com.ai.slp.balance.ats.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunFundSerialByAcctIdIdx;

/**
 * ATS消费服务（索引管理）
 * Date: 2015年8月18日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface ITableIndexSV {
    
    /**
     * 订单交易表ACT_ID1索引
     * @param idx
     * @author lilg
     * @ApiDocMethod
     */
    public void addFunFundSerialByAcctIdIdx(FunFundSerialByAcctIdIdx idx);
}
