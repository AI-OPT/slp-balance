package com.ai.slp.balance.api.depositquery.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;

@Path("/depositQueryService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IDepositQuerySV {

    /**
     * 按账户查询缴费记录,未规划
     * @param param
     * @return
     * @throws BusinessException,SystemException
     * @author lilg
     * @RestRelativeURL depositQueryService/depositQuery
     */
	@POST
	@Path("/depositQuery")
    public String depositQuery(int param) throws BusinessException,SystemException;
}
