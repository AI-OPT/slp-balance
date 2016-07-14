package com.ai.slp.balance.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.balance.api.custcredit.param.CustCreditRequest;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfo;
import com.ai.slp.balance.dao.mapper.bo.FunAccountLog;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountInfoAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountLogAtomSV;
import com.ai.slp.balance.service.business.interfaces.IFunAccountInfoBusiSV;
@Service
public class FunAccountInfoBusiSVImpl implements IFunAccountInfoBusiSV {
	@Autowired
	private IFunAccountInfoAtomSV funAccountInfoAtomSV;
	@Autowired
	private IFunAccountLogAtomSV funAccountLogAtomSV;
	
	/**
	 * 客户信用额度修改
	 */
	@Transactional
	public void updateCredit(CustCreditRequest request) throws BusinessException,SystemException{
		FunAccountInfo funAccountInfo = new FunAccountInfo();
		funAccountInfo.setAccountId(Long.valueOf(request.getAccountId()));
		funAccountInfo.setCredit(request.getCredit());
		//
		this.funAccountInfoAtomSV.updateCredit(funAccountInfo);
		//
		FunAccountInfo funAccountInfoDb = this.funAccountInfoAtomSV.getBeanByPrimaryKey(Long.valueOf(request.getAccountId()));
		//
		FunAccountLog funAccountLog = new FunAccountLog();
		//
		BeanUtils.copyProperties(funAccountLog, funAccountInfoDb);
		funAccountLog.setUpdateTime(DateUtil.getSysDate());
		this.funAccountLogAtomSV.saveFunAccountLog(funAccountLog);
		
	}	
}
