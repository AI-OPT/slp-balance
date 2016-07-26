package com.ai.slp.balance.api.ordertobillaccount.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.ordertobillaccount.interfaces.IOrderToBillAccountSV;
import com.ai.slp.balance.api.ordertobillaccount.param.BillGenRequest;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.service.business.interfaces.IBillAccountBusiSV;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.remoting.exchange.Request;
@Service
@Component
public class OrderToBillAccountSVImpl implements IOrderToBillAccountSV {
	
	@Autowired
	private IBillAccountBusiSV billAccountBusiSV; 
	
	@Override
	public BaseResponse orderToBillAccount(BillGenRequest billgenRequest) throws BusinessException, SystemException {
		BaseResponse response =  new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		
		if(StringUtil.isBlank(billgenRequest.getAccountId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"账户id不能为空");
		}
		if(StringUtil.isBlank(billgenRequest.getProductCatId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"商品类目id不能为空");
		}
		if(StringUtil.isBlank(billgenRequest.getTenantId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"租户id不能为空");
		}
		if(StringUtil.isBlank(billgenRequest.getUserId())){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"用户id不能为空");
		}
		if(null == billgenRequest.getFee() || 0 == billgenRequest.getFee()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"订单费用不能为空或0");
		}
		if(null == billgenRequest.getOverdraftQuota() || 0 == billgenRequest.getOverdraftQuota()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"透支额不能为空或0");
		}
		
		if(null == billgenRequest.getOrderTime()){
			throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"下单时间不能为空");
		}
		//
		try{
			this.billAccountBusiSV.updateOrderToBillAccount(billgenRequest);
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_SUCCESS);
			responseHeader.setResultMessage("订单入账成功");
			response.setResponseHeader(responseHeader);
			//
			return response;
		}catch(BusinessException businessException){
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(businessException.getErrorCode());
			responseHeader.setResultMessage(businessException.getErrorMessage());
			response.setResponseHeader(responseHeader);
			//
			return response;
		}catch(Exception e){
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode(ExceptCodeConstants.Special.SYSTEM_ERROR);
			responseHeader.setResultMessage("订单入账失败");
			response.setResponseHeader(responseHeader);
			//
			return response;
		}		
	}

}
