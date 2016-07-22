package com.ai.slp.balance.test.api.deduct.impl;

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
import com.ai.slp.balance.api.deduct.interfaces.IDeductSV;
import com.ai.slp.balance.api.deduct.param.DeductAccount;
import com.ai.slp.balance.api.deduct.param.DeductParam;
import com.ai.slp.balance.api.deduct.param.DeductResponse;
import com.ai.slp.balance.api.deduct.param.ForegiftDeduct;
import com.ai.slp.balance.api.deduct.param.SettleParam;
import com.ai.slp.balance.api.deduct.param.SettleSummary;
import com.ai.slp.balance.api.deduct.param.TransSummary;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class DeductTest extends TestCase {

    private static final Logger log = LogManager.getLogger(DeductTest.class);

    @Autowired
    private IDeductSV deductSV;
    
    @Test
    public void testSettleAccount() {
        SettleParam param = new SettleParam();
        SettleSummary summary = new SettleSummary();
        summary.setAmount(1);
        summary.setSubjectId(100000);
        summary.setBookId(452);
        summary.setFeeSubjectId(111);
        List<SettleSummary> transSummaryList = new ArrayList<SettleSummary>();
        transSummaryList.add(summary);
        param.setTransSummary(transSummaryList);
        param.setAccountId(902l);
        param.setExternalId(SeqUtil.getNewId("lilg_test_external_Id").toString());
        param.setSystemId("1");
        param.setTenantId("BIS-ST");
        param.setTenantPwd("111");
        String result = deductSV.settleAccount(param);
        assertNotNull("返回结果空，扣款失败", result);
        assertFalse("返回结果空，扣款失败", "".equals(result));
        log.debug("扣减成功，交易流水：" + result);
    }
    
    @Test
    public void testDeductFund(){
        DeductParam param = new DeductParam();
        TransSummary summary = new TransSummary();
        summary.setSubjectId(100000);
        List<TransSummary> transSummaryList = new ArrayList<TransSummary>();
        transSummaryList.add(summary);
        param.setTransSummary(transSummaryList);
        param.setAccountId(11211);
        param.setExternalId(SeqUtil.getNewId("lilg_test_external_Id").toString());
        param.setSystemId("1");
        param.setBusinessCode("1");
        param.setTenantId("SLP");
        param.setTenantPwd("111");
        param.setTotalAmount(1);
        param.setCheckPwd(1);
        
        DeductResponse result = deductSV.deductFund(param);
        log.info("result:"+JSON.toJSONString(result));
        assertNotNull("返回结果空，扣款失败", result);
        assertFalse("返回结果空，扣款失败", "".equals(result));
        log.debug("扣减成功，交易流水：" + result);
    }
    
    @Test
    public void testDeductForegift(){
        ForegiftDeduct param = new ForegiftDeduct();
        param.setTenantId("BIS-ST");
        param.setAccountId(604);
        param.setSystemId("1");
        param.setSubjectId(100001);
        param.setBookId(1704);
        param.setAmount(1);
        param.setExternalId(SeqUtil.getNewId("lilg_test_external_Id").toString());
        String result = deductSV.deductForegift(param);
        assertNotNull("返回结果空，扣款失败", result);
        assertFalse("返回结果空，扣款失败", "".equals(result));
        log.debug("扣减成功，交易流水：" + result);
        log.error(JSON.toJSONString(param));
        log.error(result);
    }
    
    @Test
    public void testDeductPartByAcount(){
        DeductAccount param = new DeductAccount();
        param.setAccountId(10080);
        param.setExternalId(SeqUtil.getNewId("lilg_test_external_Id").toString());
        param.setSystemId("1");
        param.setTenantId("BIS-ST");
        param.setTenantPwd("111");
        param.setTotalAmount(1);
        param.setBusinessCode("TEST_LILG");
        long result = deductSV.deductPartFundByAccount(param);
        assertTrue("返回结果错误", result>=0);
        log.error("请求参数:{}",JSON.toJSONString(param));
        log.error("返回结果:{}",result);
    }
}
