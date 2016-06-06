package com.ai.slp.balance.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.balance.api.deposit.param.DepositParam;
import com.ai.slp.balance.api.deposit.param.ForegiftDeposit;

/**
 * 存款服务
 * Date: 2015年7月30日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IDepositBusiSV {
    /**
     * 存款接口
     * @param balanceDepositVo
     * @return
     * @throws Exception
     * @author lilg
     * @ApiDocMethod
     */
    public String depositFund(DepositParam param) throws BusinessException;
    
    /**
     * 押金存入
     * @param param
     * @return
     * @throws BusinessException
     * @author lilg
     * @ApiDocMethod
     */
    public String depositForegift(ForegiftDeposit param) throws BusinessException;
}
