package com.ai.slp.balance.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.custcredit.param.CustCreditRequest;

public interface IFunAccountInfoBusiSV {
	public void updateCredit(CustCreditRequest request) throws BusinessException,SystemException;
	/**
	 * 客户授信额度设置
	 * @param request
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void updateSettingCredit(CustCreditRequest request) throws BusinessException,SystemException;
}
