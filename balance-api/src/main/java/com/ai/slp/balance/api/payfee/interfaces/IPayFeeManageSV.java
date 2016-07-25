package com.ai.slp.balance.api.payfee.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.balance.api.payfee.param.PayFeeRecordRequest;
import com.ai.slp.balance.api.payfee.param.PayFeeRecordResponse;
import com.ai.slp.balance.api.payfee.param.PayFeeRequest;

@Path("/payFeeManageService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IPayFeeManageSV {
	/**
	 * @param PayFeeRequest
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode payFeeManageService-1001
	 * @RestRelativeURL payFeeManageService/payFee
     */
	@POST
	@Path("/payFee")
	public BaseResponse payFee(PayFeeRequest request) throws BusinessException,SystemException;
	/**
	 * 
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode payFeeManageService-1002
	 * @RestRelativeURL payFeeManageService/payFeeRecord
     */
	@POST
	@Path("/payFeeRecord")
	public PayFeeRecordResponse payFeeRecord(PayFeeRecordRequest request) throws BusinessException,SystemException;
}
