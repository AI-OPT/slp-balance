package com.ai.slp.balance.api.resdeduct.interfaces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.resdeduct.param.ResourceDeduct;

/**
 * 资源抵扣服务
 *
 * Date: 2015年10月31日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
@Path("/resDeductService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IResDeductSV {

    /**
     * 资源扣减. <br>
     * 1、支持即买即用产品、传统包月产品的资源抵扣；<br>
     * 2、支持即买即用的产品超出套餐时的资源管理，超出后为负，在新的资源入账后可抵扣原来超出套餐的资源记录。 <br>
     * 
     * @param param
     * @return 扣减结果
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0029
     * @RestRelativeURL resDeductService/deductResource
     */
	@POST
	@Path("/deductResource")
    public void deductResource(ResourceDeduct param) throws BusinessException,SystemException;

}
