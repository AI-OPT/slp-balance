package com.ai.slp.balance.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.ordertobillaccount.param.BillGenRequest;
import com.ai.slp.balance.api.ordertobillaccount.param.BillGenRollBackRequest;

public interface IBillAccountBusiSV {
	public void updateOrderToBillAccount(BillGenRequest request) throws BusinessException,SystemException;
	public void updateOrderToBillAccountRollBack(BillGenRollBackRequest request) throws BusinessException,SystemException;
}
