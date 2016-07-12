package com.ai.slp.balance.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.custcredit.param.CustCreditRequest;

public interface IFunAccountInfoBusiSV {
	public void updateCredit(CustCreditRequest request) throws BusinessException,SystemException;
}
