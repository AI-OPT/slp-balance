package com.ai.slp.balance.api.payfee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.slp.balance.api.payfee.interfaces.IPayFeeManageSV;
import com.ai.slp.balance.api.payfee.param.PayFeeRequest;
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
		try {
			this.billPayLogBusiSV.payFee(request);
			//
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode("000000");
			responseHeader.setResultMessage("还款成功");
			response.setResponseHeader(responseHeader);
		} catch (Exception e) {
			e.printStackTrace();
			//
			responseHeader.setIsSuccess(false);
			responseHeader.setResultCode("999999");
			responseHeader.setResultMessage("还款失败");
			response.setResponseHeader(responseHeader);
		}
		return response;
	}

}
