package com.ai.slp.balance.api.payfee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.payfee.interfaces.IPayFeeManageSV;
import com.ai.slp.balance.api.payfee.param.PayFeeRecordRequest;
import com.ai.slp.balance.api.payfee.param.PayFeeRecordResponse;
import com.ai.slp.balance.api.payfee.param.PayFeeRequest;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.service.business.interfaces.IBillPayLogBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class PayFeeManageSVImpl implements IPayFeeManageSV {

	@Autowired
	private IBillPayLogBusiSV billPayLogBusiSV;

	@Override
	public BaseResponse payFee(PayFeeRequest request) throws BusinessException, SystemException {
		BaseResponse response = new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		if(null == request){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"参数不能为空");
		}
		if(StringUtil.isBlank(request.getTenantId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"租户Id不能为空");
		}
		if(null == request.getAccountId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"账户id不能为空");
		}
		if(null == request.getPayFee() || 0 == request.getPayFee()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"还款金额不能为空或0");
		}
		if(null == request.getPayFeeTime()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"还款时间不能为空");
		}
		try {
			this.billPayLogBusiSV.payFee(request);
			//
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
			responseHeader.setResultMessage("还款成功");
			response.setResponseHeader(responseHeader);
		}catch(BusinessException e){
			responseHeader.setResultCode(e.getErrorCode());
			responseHeader.setResultMessage(e.getErrorMessage());
			//
			response.setResponseHeader(responseHeader);
			
		}catch (Exception e) {
			e.printStackTrace();
			//
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("还款失败");
			response.setResponseHeader(responseHeader);
		}
		return response;
	}
	/**
	 * 查询还款记录
	 */
	@Override
	public PayFeeRecordResponse payFeeRecord(PayFeeRecordRequest request) throws BusinessException, SystemException {
		if(null == request){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"请求参数不能为空");
		}
		if(StringUtil.isBlank(request.getTenantId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"租户id不能为空");
		}
		if(null == request.getAccountId()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"账户id不能为空");
		}
		//
		PayFeeRecordResponse response = new PayFeeRecordResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		//
		try{
			response = this.billPayLogBusiSV.payFeeRecord(request);
			//
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
			responseHeader.setResultMessage("查询失败");
			//
			response.setResponseHeader(responseHeader);
			
		}
		//
		return response;
	}

}
