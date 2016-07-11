package com.ai.slp.balance.api.ordertobillaccount.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.ordertobillaccount.interfaces.IOrderToBillAccountSV;
import com.ai.slp.balance.api.ordertobillaccount.param.BillGenRequest;
import com.ai.slp.balance.service.business.interfaces.IBillAccountBusiSV;
import com.alibaba.dubbo.config.annotation.Service;
@Service
@Component
public class OrderToBillAccountSVImpl implements IOrderToBillAccountSV {
	
	@Autowired
	private IBillAccountBusiSV billAccountBusiSV; 
	public OrderToBillAccountSVImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void orderToBillAccount(BillGenRequest billgenRequest) throws BusinessException, SystemException {
		
		this.billAccountBusiSV.orderToBillAccount(billgenRequest);
	}

}
