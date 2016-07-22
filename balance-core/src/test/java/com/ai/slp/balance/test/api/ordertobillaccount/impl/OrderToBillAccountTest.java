package com.ai.slp.balance.test.api.ordertobillaccount.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.balance.api.deduct.interfaces.IDeductSV;
import com.ai.slp.balance.api.deduct.param.DeductAccount;
import com.ai.slp.balance.api.deduct.param.DeductParam;
import com.ai.slp.balance.api.deduct.param.DeductResponse;
import com.ai.slp.balance.api.deduct.param.ForegiftDeduct;
import com.ai.slp.balance.api.deduct.param.SettleParam;
import com.ai.slp.balance.api.deduct.param.SettleSummary;
import com.ai.slp.balance.api.deduct.param.TransSummary;
import com.ai.slp.balance.api.ordertobillaccount.interfaces.IOrderToBillAccountSV;
import com.ai.slp.balance.api.ordertobillaccount.param.BillGenRequest;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class OrderToBillAccountTest extends TestCase {

    private static final Logger log = LogManager.getLogger(OrderToBillAccountTest.class);

    @Autowired
    private IOrderToBillAccountSV orderToBillAccountSV;
    /**
     * 订单入账接口
     * 
     * @author zhangzd
     * @ApiDocMethod
     * @ApiCode
     */
    @Test
    public void orderToBillAccount(){
    	BillGenRequest billgenRequest = new BillGenRequest();
    	billgenRequest.setAccountId("10001");
    	billgenRequest.setFee(1l);
    	billgenRequest.setOrderTime(DateUtil.getSysDate());
    	billgenRequest.setOverdraftQuota(11l);
    	billgenRequest.setProductCatId("111");
    	billgenRequest.setTenantId("SLP");
    	billgenRequest.setUserId("USER001");
    	System.out.println("入参："+JSON.toJSONString(billgenRequest));
    	this.orderToBillAccountSV.orderToBillAccount(billgenRequest);
    }
}
