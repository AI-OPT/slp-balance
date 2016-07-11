package com.ai.slp.balance.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.ordertobillaccount.param.BillGenRequest;

public interface IBillAccountBusiSV {
	public void orderToBillAccount(BillGenRequest request) throws BusinessException,SystemException;
}
