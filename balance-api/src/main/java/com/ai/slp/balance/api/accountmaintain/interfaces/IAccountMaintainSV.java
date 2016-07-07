package com.ai.slp.balance.api.accountmaintain.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.accountmaintain.param.AccountUpdateParam;
import com.ai.slp.balance.api.accountmaintain.param.RegAccReq;

/**
 * 创建账户接口类 <br>
 *
 * Date: 2015年8月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
@Path("/accountMaintainService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IAccountMaintainSV {

    /**
     * 创建账户.<br>
     * 创建账户资料<br>
     * 
     * @param regAccReq
     * @return 账户ID
     * @author limy6
     * @ApiDocMethod
     * @ApiCode ABM_0011
     * @RestRelativeURL accountMaintainService/queryAccontById
     */
	@POST
	@Path("/queryAccontById")
    public long createAccount(RegAccReq regAccReq) throws BusinessException,SystemException;

    /**
     * 账户资料修改.<br>
     * 对账户资料进行修改<br>
     * 
     * @param param
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0015
     * @RestRelativeURL accountMaintainService/updateAccount
     */
	@POST
	@Path("/updateAccount")
    public void updateAccount(AccountUpdateParam param) throws BusinessException,SystemException;

}
