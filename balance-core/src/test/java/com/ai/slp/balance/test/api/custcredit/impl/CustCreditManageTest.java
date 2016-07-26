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
import com.ai.slp.balance.api.custcredit.param.CustCreditSettingRecordRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditSettingRecordResponse;
import com.ai.slp.balance.api.custcredit.param.CustCreditUnUsedRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditUnUsedResponse;
import com.ai.slp.balance.api.custcredit.param.CustCreditUsedRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditUsedResponse;
import com.alibaba.fastjson.JSON;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class CustCreditManageTest  extends TestCase {
	private static final Logger log = LogManager.getLogger(CustCreditManageTest.class);
	@Autowired 
	private ICustCreditManageSV custCreditManageSV; 
	/*@Test
	public void updateCredit(){
		CustCreditRequest request = new CustCreditRequest();
		//
		request.setAccountId("10001");
		request.setCredit(15544l);
		//
		this.custCreditManageSV.updateCredit(request);
	}*/
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
	/**
	 * 客户授信记录查询
	 * 
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	@Test
	public void queryCustCreditSettingRecord(){
		CustCreditSettingRecordRequest request = new CustCreditSettingRecordRequest();
		//
		request.setAccountId(11151l);
		request.setTenantId("SLP");
		request.setPageNo(1);
		request.setPageSize(5);
		//
		log.info("request:"+JSON.toJSONString(request));
		CustCreditSettingRecordResponse response = this.custCreditManageSV.queryCustCreditSettingRecord(request);
		log.info("response:"+JSON.toJSONString(response));
	}
	/**
	 * 查询已使用额度
	 * 
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	@Test
	public void findCustCreditUsed(){
		CustCreditUsedRequest request = new CustCreditUsedRequest();
		//
		request.setAccountId(11151l);
		request.setTenantId("SLP");
		//
		log.info("request:"+JSON.toJSONString(request));
		CustCreditUsedResponse response = this.custCreditManageSV.findCustCreditUsed(request);
		log.info("response:"+JSON.toJSONString(response));
	}
	
	/**
	 * 查询未使用额度
	 * 
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	@Test
	public void findCustCreditUnUsed(){
		CustCreditUnUsedRequest request = new CustCreditUnUsedRequest();
		//
		request.setAccountId(11151l);
		request.setTenantId("SLP");
		//
		log.info("request:"+JSON.toJSONString(request));
		CustCreditUnUsedResponse response = this.custCreditManageSV.findCustCreditUnUsed(request);
		log.info("response:"+JSON.toJSONString(response));
	}

}
