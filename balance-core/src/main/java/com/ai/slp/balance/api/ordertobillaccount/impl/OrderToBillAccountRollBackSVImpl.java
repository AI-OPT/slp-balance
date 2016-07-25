package com.ai.slp.balance.api.ordertobillaccount.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.ordertobillaccount.interfaces.IOrderToBillAccountRollBackSV;
import com.ai.slp.balance.api.ordertobillaccount.param.BillGenRollBackRequest;
import com.ai.slp.balance.service.business.interfaces.IBillAccountBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class OrderToBillAccountRollBackSVImpl implements IOrderToBillAccountRollBackSV {
	@Autowired
	private IBillAccountBusiSV billAccountBusiSV;

	@Override
	public BaseResponse orderToBillAccountRollBack(BillGenRollBackRequest request)
			throws BusinessException, SystemException {
		BaseResponse response =  new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		
		if(StringUtil.isBlank(request.getAccountId())){
			throw new BusinessException("8888","账户id不能为空");
		}
		if(StringUtil.isBlank(request.getProductCatId())){
			throw new BusinessException("8888","商品类目id不能为空");
		}
		if(StringUtil.isBlank(request.getTenantId())){
			throw new BusinessException("8888","租户id不能为空");
		}
		if(StringUtil.isBlank(request.getUserId())){
			throw new BusinessException("8888","用户id不能为空");
		}
		if(null != request.getFee() && StringUtil.isBlank(String.valueOf(request.getFee()))){
			throw new BusinessException("8888","订单费用不能为空");
		}
		if(null != request.getOverdraftQuota() && StringUtil.isBlank(String.valueOf(request.getOverdraftQuota()))){
			throw new BusinessException("8888","透支额不能为空");
		}
		
		if(null != request.getOrderTime()){
			throw new BusinessException("8888","下单时间不能为空");
		}
		try{
			this.billAccountBusiSV.updateOrderToBillAccountRollBack(request);
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode("000000");
			responseHeader.setResultMessage("订单入账回退成功");
			response.setResponseHeader(responseHeader);
		}catch(BusinessException businessException){
			responseHeader.setResultCode(businessException.getErrorCode());
			responseHeader.setResultMessage(businessException.getErrorMessage());
			response.setResponseHeader(responseHeader);
		}catch(Exception e){
			responseHeader.setResultCode("999999");
			responseHeader.setResultMessage("订单入账回退失败");
			response.setResponseHeader(responseHeader);
		}
		//
		return response;
	}

}
