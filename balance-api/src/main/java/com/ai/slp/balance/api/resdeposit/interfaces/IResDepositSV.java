package com.ai.slp.balance.api.resdeposit.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.resdeposit.param.ResourceDeposit;

/**
 * 资源入账服务<br>
 *
 * Date: 2015年10月26日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
@Path("/resDeposit")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IResDepositSV {
    /**
     * 资源入账.<br>
     * 提供将资源量入账本的操作，支持月初套餐资源自动入账本、单笔资源入账。支持新入账的资源抵扣原来超出套餐部分的资源<br>
     * 
     * @param param
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0027
     * @RestRelativeURL resDeposit/depositResource
     */
	@POST
	@Path("/depositResource")
    public void depositResource(ResourceDeposit param) throws BusinessException,SystemException;
}
