package com.ai.slp.balance.api.accountquery.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.accountquery.param.AccountIdParam;
import com.ai.slp.balance.api.accountquery.param.AccountInfoVo;
import com.ai.slp.balance.api.accountquery.param.CustIdParam;
import com.ai.slp.balance.api.accountquery.param.ListAccountResponse;

/**
 * 账户查询接口类 <br>
 *
 * Date: 2015年8月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
@Path("/accountQueryService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IAccountQuerySV {

    /**
     * 按账户查询账户资料.<br>
     * 按照账户查询账户的基本资料<br>
     * 
     * @param accountId
     * @return 账户信息
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0012
     * @RestRelativeURL accountQueryService/queryAccontById
     */
	@POST
	@Path("/queryAccontById")
    public AccountInfoVo queryAccontById(AccountIdParam accountId) throws BusinessException,SystemException;

    /**
     * 按客户查询账户资料.<br>
     * 按照账户查询账户的基本资料<br>
     * 
     * @param custId
     * @return 账户信息列表
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0013
     * @RestRelativeURL accountQueryService/queryAccontByCustId
     */
	@POST
	@Path("/queryAccontByCustId")
    public List<AccountInfoVo> queryAccontByCustId(CustIdParam custId) throws BusinessException,SystemException;
	
	/**
     * 按客户查询账户资料.<br>
     * 按照账户查询账户的基本资料<br>
     * 
     * @param custId
     * @return 账户信息列表
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_00131
     * @RestRelativeURL accountQueryService/queryAccontByCustIdNew
     */
	@POST
	@Path("/queryAccontByCustIdNew")
    public ListAccountResponse queryAccontByCustIdNew(CustIdParam custId) throws BusinessException,SystemException;

}
