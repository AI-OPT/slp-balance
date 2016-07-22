package com.ai.slp.balance.test.api.deposit.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
//import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
//import net.sourceforge.groboutils.junit.v1.TestRunnable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.slp.balance.api.deposit.interfaces.IDepositSV;
import com.ai.slp.balance.api.deposit.param.DepositParam;
import com.ai.slp.balance.api.deposit.param.ForegiftDeposit;
import com.ai.slp.balance.api.deposit.param.TransSummary;
import com.ai.slp.balance.service.business.interfaces.IDepositBusiSV;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class DepositTest extends TestCase {

    private static final Logger log = LogManager.getLogger(DepositTest.class);

    @Autowired
    private IDepositSV depositSV;

    @Autowired
    private IDepositBusiSV depositBusiSV;

    @Test
    public void testDepositForegift() {
        ForegiftDeposit param = new ForegiftDeposit();
        param.setAccountId(902);
        param.setAmount(1);
        param.setBusiDesc("李林刚测试");
        param.setBusiSerialNo(SeqUtil.getNewId("lilg_test_external_Id").toString());
        param.setTenantId("BIS-ST");
        param.setSystemId("1");
        param.setFundexpDate("2015-12-31 23:59:59");
        param.setSubjectId(100001);
        String result = depositSV.depositForegift(param);
        assertNotNull("返回结果空，存入失败", result);
        assertFalse("返回结果空，存入失败", "".equals(result));
        log.debug("押金存入成功，交易流水：" + result);
    }
    
    @Test
    public void testDepositCash() {
        DepositParam param = new DepositParam();
        TransSummary summary = new TransSummary();
        summary.setAmount(10);
        summary.setSubjectId(100000);
        List<TransSummary> transSummaryList = new ArrayList<TransSummary>();
        transSummaryList.add(summary);
        param.setTransSummary(transSummaryList);
        param.setAccountId(902l);
        param.setBusiDesc("李林刚测试");
        param.setBusiSerialNo(SeqUtil.getNewId("lilg_test_external_Id").toString());
        param.setSystemId("1");
        param.setTenantId("BIS-ST");
        param.setTenantPwd("111");
        String result = depositSV.depositFund(param);
        assertNotNull("返回结果空，存入失败", result);
        assertFalse("返回结果空，存入失败", "".equals(result));
        log.debug("押金存入成功，交易流水：" + result);
    }

    @Test
    public void MultiRequestsTest() {
        // 构造一个Runner
//        TestRunnable runner = new TestRunnable() {
//            @Override
//            public void runTest() throws Throwable {
//                // 测试内容
//                //depositBusiSV.test(902l, 1);
//            }
//        };
//        int runnerCount = 100;
//        // Rnner数组，想当于并发多少个。
//        TestRunnable[] trs = new TestRunnable[runnerCount];
//        for (int i = 0; i < runnerCount; i++) {
//            trs[i] = runner;
//        }
//        // 用于执行多线程测试用例的Runner，将前面定义的单个Runner组成的数组传入
//        MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(trs);
//        try {
//            // 开发并发执行数组里定义的内容
//            mttr.runTestRunnables();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
    }
}
