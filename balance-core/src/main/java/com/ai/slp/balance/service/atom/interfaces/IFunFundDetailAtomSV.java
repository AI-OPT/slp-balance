package com.ai.slp.balance.service.atom.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunFundDetail;

/**
 * 资金流水明细原子服务，对应表FUN_FUND_DETAIL
 * Date: 2015年8月17日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IFunFundDetailAtomSV {
    
    /**
     * 新增资金流水明细
     * @param bean
     * @author lilg
     * @ApiDocMethod
     */
    public void insertFunFundDetail(FunFundDetail funFundDetail);
}
