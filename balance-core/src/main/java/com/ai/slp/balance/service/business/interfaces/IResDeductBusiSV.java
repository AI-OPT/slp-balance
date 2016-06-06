package com.ai.slp.balance.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.balance.api.resdeduct.param.ResourceDeduct;

/**
 * 资源抵扣业务层 <br>
 *
 * Date: 2015年10月28日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IResDeductBusiSV {

    /**
     * 资源抵扣服务
     * 
     * @param param
     * @throws BusinessException
     * @author lilg
     */
    public void deductResource(ResourceDeduct param) throws BusinessException;
}
