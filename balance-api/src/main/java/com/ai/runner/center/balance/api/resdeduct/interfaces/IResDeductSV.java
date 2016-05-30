package com.ai.runner.center.balance.api.resdeduct.interfaces;

import com.ai.runner.base.exception.CallerException;
import com.ai.runner.center.balance.api.resdeduct.param.ResourceDeduct;

/**
 * 资源抵扣服务
 *
 * Date: 2015年10月31日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IResDeductSV {

    /**
     * 资源扣减. <br>
     * 1、支持即买即用产品、传统包月产品的资源抵扣；<br>
     * 2、支持即买即用的产品超出套餐时的资源管理，超出后为负，在新的资源入账后可抵扣原来超出套餐的资源记录。 <br>
     * 
     * @param param
     * @return 扣减结果
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0029
     */
    public void deductResource(ResourceDeduct param) throws CallerException;

}
