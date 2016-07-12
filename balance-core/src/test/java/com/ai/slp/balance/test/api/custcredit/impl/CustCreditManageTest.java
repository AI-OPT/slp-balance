package com.ai.slp.balance.test.api.custcredit.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.balance.api.custcredit.interfaces.ICustCreditManageSV;
import com.ai.slp.balance.api.custcredit.param.CustCreditRequest;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class CustCreditManageTest  extends TestCase {
	private static final Logger log = LogManager.getLogger(CustCreditManageTest.class);
	@Autowired 
	private ICustCreditManageSV custCreditManageSV; 
	@Test
	public void updateCredit(){
		CustCreditRequest request = new CustCreditRequest();
		//
		request.setAccountId("10001");
		request.setCredit(15555l);
		//
		this.custCreditManageSV.updateCredit(request);
	}

}
