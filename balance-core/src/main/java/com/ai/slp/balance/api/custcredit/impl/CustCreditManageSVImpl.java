package com.ai.slp.balance.api.custcredit.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.slp.balance.api.custcredit.interfaces.ICustCreditManageSV;
import com.ai.slp.balance.api.custcredit.param.CustCreditDetailRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditDetailResponse;
import com.ai.slp.balance.api.custcredit.param.CustCreditRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditSettingRecordRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditSettingRecordResponse;
import com.ai.slp.balance.api.custcredit.param.CustCreditUnUsedRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditUnUsedResponse;
import com.ai.slp.balance.api.custcredit.param.CustCreditUsedRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditUsedResponse;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfo;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountInfoAtomSV;
import com.ai.slp.balance.service.business.interfaces.IFunAccountInfoBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class CustCreditManageSVImpl implements ICustCreditManageSV {
	@Autowired
	private IFunAccountInfoBusiSV funAccountInfoBusiSV;

	/*@Override
	public BaseResponse updateCredit(CustCreditRequest request) throws BusinessException, SystemException {
		BaseResponse response = new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			this.funAccountInfoBusiSV.updateCredit(request);
			//
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
			responseHeader.setResultMessage("信用度额度设置成功");
			response.setResponseHeader(responseHeader);
		} catch (Exception e) {
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("信用度额度设置失败");
			response.setResponseHeader(responseHeader);
		}
		return response;
	}*/
	/**
	 * 客户授信设置
	 */
	@Override
	public BaseResponse settingCredit(CustCreditRequest request) throws BusinessException, SystemException {
		BaseResponse response = new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		if(null == request){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"参数不能为空");
		}
		if(StringUtil.isBlank(request.getAccountId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"账户id不能为空");
		}
		if(StringUtil.isBlank(request.getBillGenType())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"账单周期类型不能为空");
		}
		if(StringUtil.isBlank(request.getCustId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"客户id不能为空");
		}
		if(StringUtil.isBlank(request.getOperCode())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"操作者编码不能为空");
		}
		if(StringUtil.isBlank(request.getOperId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"操作者id不能为空");
		}
		if(StringUtil.isBlank(request.getTenantId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"租户id不能为空");
		}
		if(null == request.getCashDeposit() || 0 == request.getCashDeposit()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"押金不能为为空或0");
		}
		if(null == request.getCredit() || 0 == request.getCredit()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"信用额度不能为空或0");
		}
		if(null == request.getCreditActiveTime()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"信用额度生效时间不能为空");
		}
		if(null == request.getCreditExpireTime()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"信用额度失效时间不能为空");
		}
		if(StringUtil.isBlank(request.getPostpayType())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"还款时限周期类型不能为空");
		}
		if(null == request.getPostpayUnits() || 0 == request.getPostpayUnits()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"还款时限周期数不能为空或0");
		}
		try{
			this.funAccountInfoBusiSV.updateSettingCredit(request);
			//
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
			responseHeader.setResultMessage("信用额度设置成功");
			response.setResponseHeader(responseHeader);
		}catch(BusinessException|SystemException e){
			//
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			response.setResponseHeader(responseHeader);
		}catch(Exception e){
			//
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("信用额度设置失败");
			response.setResponseHeader(responseHeader);
		}
		return response;
	}
	/**
	 * 客户授信详情查询
	 */
	@Override
	public CustCreditDetailResponse findCustCreditDetail(CustCreditDetailRequest request)
			throws BusinessException, SystemException {
		if(null == request){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"参数不能为空");
		}
		if(null == request.getAccountId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"账户id不能为空");
		}
		if(StringUtil.isBlank(request.getTenantId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"租户id不能为空");
		}
		CustCreditDetailResponse response = new CustCreditDetailResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		
		try{
			response = this.funAccountInfoBusiSV.findCustCreditDetail(request);
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
			responseHeader.setResultMessage("成功");
			//
			response.setResponseHeader(responseHeader);
		}catch(BusinessException e){
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			//
			response.setResponseHeader(responseHeader);
		}catch(Exception e){
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("失败");
			//
			response.setResponseHeader(responseHeader);
		}
		//
		return response;
	}
	/**
	 * 客户信用额度调整记录查询
	 */
	@Override
	public CustCreditSettingRecordResponse queryCustCreditSettingRecord(CustCreditSettingRecordRequest request)
			throws BusinessException, SystemException {
		CustCreditSettingRecordResponse response = new CustCreditSettingRecordResponse();
		//
		ResponseHeader responseHeader = new ResponseHeader();
		//
		if(null == request){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"请求参数不能为空");
		}
		if(null == request.getAccountId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"账户id不能为空");
		}
		if(StringUtil.isBlank(request.getTenantId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"租户id不能为空");
		}
		
		//
		try{
			response = this.funAccountInfoBusiSV.queryCustCreditSettingRecord(request);
			//
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
			responseHeader.setResultMessage("成功");
			response.setResponseHeader(responseHeader);
		}catch(BusinessException e){
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			//
			response.setResponseHeader(responseHeader);
		}catch(Exception e){
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("失败");
			//
			response.setResponseHeader(responseHeader);
		}
		//
		return response;
	}
	/**
	 * 客户已使用额度查询
	 */
	@Override
	public CustCreditUsedResponse findCustCreditUsed(CustCreditUsedRequest request)
			throws BusinessException, SystemException {
		CustCreditUsedResponse response = new CustCreditUsedResponse();
		//
		ResponseHeader responseHeader = new ResponseHeader();
		//
		if(null == request){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"参数不能为空");
		}
		if(null == request.getAccountId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"账户id不能为空");
		}
		if(StringUtil.isBlank(request.getTenantId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"租户id不能为空");
		}
		//
		try{
			response = this.funAccountInfoBusiSV.findCustCreditUsed(request);
			//
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
			responseHeader.setResultMessage("成功");
			response.setResponseHeader(responseHeader);
		}catch(BusinessException e){
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			//
			response.setResponseHeader(responseHeader);
		}catch(Exception e){
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("失败");
			//
			response.setResponseHeader(responseHeader);
		}
		
		return response;
	}
	/**
	 * 客户未使用额度查询
	 */
	@Override
	public CustCreditUnUsedResponse findCustCreditUnUsed(CustCreditUnUsedRequest request)
			throws BusinessException, SystemException {
		CustCreditUnUsedResponse response = new CustCreditUnUsedResponse();
		//
		ResponseHeader responseHeader = new ResponseHeader();
		//
		if(null == request){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"参数不能为空");
		}
		if(null == request.getAccountId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"账户id不能为空");
		}
		if(StringUtil.isBlank(request.getTenantId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"租户id不能为空");
		}
		//
		try{
			response = this.funAccountInfoBusiSV.findCustCreditUnUsed(request);
			//
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
			responseHeader.setResultMessage("成功");
			response.setResponseHeader(responseHeader);
		}catch(BusinessException e){
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			//
			response.setResponseHeader(responseHeader);
		}catch(Exception e){
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("失败");
			//
			response.setResponseHeader(responseHeader);
		}
		
		//
		return response;
	}

}
