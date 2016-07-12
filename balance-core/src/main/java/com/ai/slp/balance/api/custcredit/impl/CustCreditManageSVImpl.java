package com.ai.slp.balance.api.custcredit.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.slp.balance.api.custcredit.interfaces.ICustCreditManageSV;
import com.ai.slp.balance.api.custcredit.param.CustCreditRequest;
import com.ai.slp.balance.service.business.interfaces.IFunAccountInfoBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class CustCreditManageSVImpl implements ICustCreditManageSV {
	@Autowired
	private IFunAccountInfoBusiSV funAccountInfoBusiSV;

	@Override
	public BaseResponse updateCredit(CustCreditRequest request) throws BusinessException, SystemException {
		BaseResponse response = new BaseResponse();
		ResponseHeader responseHeader = new ResponseHeader();
		try {
			this.funAccountInfoBusiSV.updateCredit(request);
			//
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode("000000");
			responseHeader.setResultMessage("信用度额度设置成功");
			response.setResponseHeader(responseHeader);
		} catch (Exception e) {
			responseHeader.setIsSuccess(true);
			responseHeader.setResultCode("000000");
			responseHeader.setResultMessage("信用度额度设置成功");
			response.setResponseHeader(responseHeader);
		}
		return response;
	}

}
