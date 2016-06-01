package com.ai.slp.balance.api.resdeposit.interfaces;

import com.ai.runner.base.exception.CallerException;
import com.ai.slp.balance.api.resdeposit.param.ResourceDeposit;

/**
 * 资源入账服务<br>
 *
 * Date: 2015年10月26日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IResDepositSV {
    /**
     * 资源入账.<br>
     * 提供将资源量入账本的操作，支持月初套餐资源自动入账本、单笔资源入账。支持新入账的资源抵扣原来超出套餐部分的资源<br>
     * 
     * @param param
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0027
     */
    public void depositResource(ResourceDeposit param) throws CallerException;
}
