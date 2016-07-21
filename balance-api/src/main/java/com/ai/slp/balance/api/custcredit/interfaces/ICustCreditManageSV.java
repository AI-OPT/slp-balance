package com.ai.slp.balance.api.custcredit.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.slp.balance.api.custcredit.param.CustCreditDetailRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditDetailResponse;
import com.ai.slp.balance.api.custcredit.param.CustCreditRequest;

@Path("/custCreditManageService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface ICustCreditManageSV {
	/**
	 * 
	 * @param CustCreditRequest
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode custCreditManageService-1001
	 * @RestRelativeURL custCreditManageService/updateCredit
     */
	@POST
	@Path("/updateCredit")
	public BaseResponse updateCredit(CustCreditRequest request) throws BusinessException,SystemException;
	/**
	 * 信用度设置调整
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode custCreditManageService-1002
	 * @RestRelativeURL custCreditManageService/settingCredit
	 */
	@POST
	@Path("/settingCredit")
	public BaseResponse settingCredit(CustCreditRequest request) throws BusinessException,SystemException;
	
	/**
	 * 客户授信详情查询
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode custCreditManageService-1003
	 * @RestRelativeURL custCreditManageService/findCustCreditDetail
	 */
	@POST
	@Path("/findCustCreditDetail")
	public CustCreditDetailResponse findCustCreditDetail(CustCreditDetailRequest request) throws BusinessException,SystemException;
}
