package com.ai.slp.balance.test.api.funquery.impl;

import java.util.List;

import junit.framework.TestCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.balance.api.fundquery.interfaces.IFundQuerySV;
import com.ai.slp.balance.api.fundquery.param.AccountIdParam;
import com.ai.slp.balance.api.fundquery.param.ForegiftInfo;
import com.ai.slp.balance.api.fundquery.param.ForegiftQuery;
import com.ai.slp.balance.api.fundquery.param.FundInfo;
import com.ai.slp.balance.api.fundquery.param.SubjectId;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration({ "/dubbo-consumer.xml" })
@ContextConfiguration({ "/context/core-context.xml" })
public class FundBookQueryTest extends TestCase {

    private static final Logger log = LogManager.getLogger(FundBookQueryTest.class);

    @Autowired
    private IFundQuerySV fundQuerySV;

    @Test
    public void testQueryForegift() {
        ForegiftQuery param = new ForegiftQuery();
        param.setAccountId(604);
        param.setTenantId("BIS-ST");
        List<ForegiftInfo> foregiftInfoList = fundQuerySV.queryForegift(param);
        assertNotNull("返回结果为NULL", foregiftInfoList);
        assertTrue("返回结果集为空", foregiftInfoList.size() > 0);
        assertEquals("查询账户ID不是预期值", 604, foregiftInfoList.get(0).getAccountId());
        log.debug("查询结果:" + JSON.toJSON(foregiftInfoList));
    }

    @Test
    public void testQueryFund() {
        AccountIdParam param = new AccountIdParam();
        param.setAccountId(10098);
        param.setTenantId("BIS-ST");
        FundInfo fundInfo = fundQuerySV.queryFund(param);
        assertNotNull("返回结果为NULL", fundInfo);
        assertNotNull("返回账本结果为NULL", fundInfo.getFundBooks());
        assertTrue("返回结果集为空", fundInfo.getFundBooks().size() > 0);
        assertEquals("查询账户ID不是预期值", 10098, fundInfo.getAccountId());
        log.error("查询结果:" + JSON.toJSON(fundInfo));
    }

    @Test
    public void testQueryUsableFund() {
        AccountIdParam param = new AccountIdParam();
        param.setAccountId(604);
        param.setTenantId("BIS-ST");
        FundInfo fundInfo = fundQuerySV.queryUsableFund(param);
        assertNotNull("返回结果为NULL", fundInfo);
        assertNotNull("返回账本结果为NULL", fundInfo.getFundBooks());
        assertTrue("返回结果集为空", fundInfo.getFundBooks().size() > 0);
        assertEquals("查询账户ID不是预期值", 604, fundInfo.getAccountId());
        log.debug("查询结果:" + JSON.toJSON(fundInfo));
    }

    @Test
    public void testQueryFrozenFund() {
        AccountIdParam param = new AccountIdParam();
        param.setAccountId(604);
        param.setTenantId("BIS-ST");
        FundInfo fundInfo = fundQuerySV.queryFrozenFund(param);
        assertNotNull("返回结果为NULL", fundInfo);
        assertNotNull("返回账本结果为NULL", fundInfo.getFundBooks());
        assertTrue("返回结果集为空", fundInfo.getFundBooks().size() > 0);
        assertEquals("查询账户ID不是预期值", 604, fundInfo.getAccountId());
        log.debug("查询结果:" + JSON.toJSON(fundInfo));
    }

    @Test
    public void testQueryUsableTeleFund() {
        AccountIdParam param = new AccountIdParam();
        param.setAccountId(10707);
        param.setTenantId("CLC-BYD");
        FundInfo fundInfo = fundQuerySV.queryUsableTeleFund(param);
        assertNotNull("返回结果为NULL", fundInfo);
        assertNotNull("返回账本结果为NULL", fundInfo.getFundBooks());
        assertTrue("返回结果集为空", fundInfo.getFundBooks().size() > 0);
        assertEquals("查询账户ID不是预期值", 10707, fundInfo.getAccountId());
        log.debug("查询结果:" + JSON.toJSON(fundInfo));
    }

    @Test
    public void testQueryFundBySubjectId() {
        SubjectId param = new SubjectId();
        param.setAccountId(10021);
        param.setTenantId("BIS-ST");
        param.setSubjectId(2000301);
        FundInfo fundInfo = fundQuerySV.queryFundBySubjectId(param);
        assertNotNull("返回结果为NULL", fundInfo);
        assertNotNull("返回账本结果为NULL", fundInfo.getFundBooks());
        assertTrue("返回结果集为空", fundInfo.getFundBooks().size() > 0);
        log.error("查询结果:" + JSON.toJSON(fundInfo));
    }
}
