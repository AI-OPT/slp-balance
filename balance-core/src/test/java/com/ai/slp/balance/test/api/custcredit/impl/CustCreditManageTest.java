package com.ai.slp.balance.test.api.custcredit.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.balance.api.custcredit.interfaces.ICustCreditManageSV;
import com.ai.slp.balance.api.custcredit.param.CustCreditDetailRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditDetailResponse;
import com.ai.slp.balance.api.custcredit.param.CustCreditRequest;
import com.alibaba.fastjson.JSON;

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
		request.setCredit(15544l);
		//
		this.custCreditManageSV.updateCredit(request);
	}
	/**
	 * 授信额度设置
	 * 
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	@Test
	public void settingCredit(){
		CustCreditRequest request = new CustCreditRequest();
		request.setAccountId("11151");
		request.setCredit(15541l);
		request.setBillGenType("D");
		request.setCashDeposit(9001l);
		request.setCreditActiveTime(DateUtil.getSysDate());
		request.setCreditExpireTime(DateUtil.getSysDate());
		request.setCustId("12345678");
		request.setOperCode("000");
		request.setOperId("000");
		request.setPostpayType("D");
		request.setPostpayUnits(10);
		request.setTenantId("SLP");
		//
		this.custCreditManageSV.settingCredit(request);
	}
	/**
	 * 授信额度详情
	 * 
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	@Test
	public void findCustCreditDetail(){
		CustCreditDetailResponse response  = new CustCreditDetailResponse();
		CustCreditDetailRequest request = new CustCreditDetailRequest();
		//
		request.setAccountId(11151l);
		request.setTenantId("SLP");
		//
		response = this.custCreditManageSV.findCustCreditDetail(request);
		//
		log.info("findCustCreditDetail response:"+JSON.toJSONString(response));
	}

}
