package com.ai.slp.balance.test.api.payfee.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.balance.api.payfee.interfaces.IPayFeeManageSV;
import com.ai.slp.balance.api.payfee.param.PayFeeRequest;
import com.ai.slp.balance.test.api.custcredit.impl.CustCreditManageTest;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class PayFeeManageTest extends TestCase {
	private static final Logger log = LogManager.getLogger(PayFeeManageTest.class);
	@Autowired
	private IPayFeeManageSV payFeeManageSV;
	@Test
	public void payfee(){
		PayFeeRequest request = new PayFeeRequest();
		request.setAccountId("1111");
		request.setCustId("aaa");
		request.setPayFee(1l);
		request.setPayFeeTime(DateUtil.getSysDate());
		request.setTenantId("SLP");
		
		this.payFeeManageSV.payFee(request);
	}
}
