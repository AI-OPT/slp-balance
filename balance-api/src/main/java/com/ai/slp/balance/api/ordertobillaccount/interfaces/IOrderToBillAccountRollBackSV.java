package com.ai.slp.balance.api.ordertobillaccount.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.balance.api.ordertobillaccount.param.BillGenRollBackRequest;

@Path("/orderToBillAccountRollBackService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IOrderToBillAccountRollBackSV {
	/**
	 * 
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode orderToBillAccountRollBackService-1001
	 * @RestRelativeURL orderToBillAccountRollBackService/orderToBillAccountRollBack
     */
	@POST
	@Path("/orderToBillAccountRollBack")
	public BaseResponse orderToBillAccountRollBack(BillGenRollBackRequest request)throws BusinessException,SystemException;
}
