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
import com.ai.slp.balance.api.custcredit.param.CustCreditSettingRecordRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditSettingRecordResponse;
import com.ai.slp.balance.api.custcredit.param.CustCreditUnUsedRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditUnUsedResponse;
import com.ai.slp.balance.api.custcredit.param.CustCreditUsedRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditUsedResponse;

@Path("/custCreditManageService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface ICustCreditManageSV {
	
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
	/**
	 * 信用额度设置记录分页查询
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode custCreditManageService-1004
	 * @RestRelativeURL custCreditManageService/queryCustCreditSettingRecord
	 */
	@POST
	@Path("/queryCustCreditSettingRecord")
	public CustCreditSettingRecordResponse queryCustCreditSettingRecord( CustCreditSettingRecordRequest request)throws BusinessException,SystemException;
	/**
	 * 客户已使用额度查询
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode custCreditManageService-1005
	 * @RestRelativeURL custCreditManageService/findCustCreditUsed
	 */
	@POST
	@Path("/findCustCreditUsed")
	public CustCreditUsedResponse findCustCreditUsed(CustCreditUsedRequest request)throws BusinessException,SystemException;

	/**
	 * 客户未使用额度查询
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode custCreditManageService-1006
	 * @RestRelativeURL custCreditManageService/findCustCreditUnUsed
	 */
	@POST
	@Path("/findCustCreditUnUsed")
	public CustCreditUnUsedResponse findCustCreditUnUsed(CustCreditUnUsedRequest request)throws BusinessException,SystemException;

}
