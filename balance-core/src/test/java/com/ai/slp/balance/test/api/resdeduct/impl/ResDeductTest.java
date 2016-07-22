package com.ai.slp.balance.test.api.resdeduct.impl;

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
import com.ai.slp.balance.api.resdeduct.interfaces.IResDeductSV;
import com.ai.slp.balance.api.resdeduct.param.ResourceDeduct;
import com.ai.slp.balance.constants.SeqConstants;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class ResDeductTest extends TestCase {
    private static final Logger log = LogManager.getLogger(ResDeductTest.class);

    @Autowired
    private IResDeductSV resDeductSV;

    @Test
    public void testResDeduct() {
        ResourceDeduct param = new ResourceDeduct();
        param.setTenantId("BIS-ST");
        param.setOwnerId(10);
        param.setOwnerType(0);
        param.setExternalId("1111111111");
        param.setSystemId("222222222222");
        param.setTotalAmount(10);
        param.setResourceType(60);
        log.error("请求参数:"+JSON.toJSON(param));
        resDeductSV.deductResource(param);
        //assertTrue("返回结果集为空", StringUtil.isBlank(result));
    }
    
    @Test
    public void testMultiRequests() {
        // 构造一个Runner
//        TestRunnable runner = new TestRunnable() {
//            @Override
//            public void runTest() throws Throwable {
//                // 测试内容
//                ResourceDeduct param = new ResourceDeduct();
//                param.setTenantId("BIS-ST");
//                param.setOwnerId(10);
//                param.setOwnerType(0);
//                Long seq = SeqUtil.getNewId(SeqConstants.FUN_FUND_SERIAL$PAY_SERIAL_CODE);
//                log.error("线程{}获取到的SEQ:{}",Thread.currentThread().getName(),seq);
//                param.setExternalId(seq.toString());
//                param.setSystemId("Runner-BIS");
//                param.setTotalAmount(1);
//                param.setResourceType(60);
//                log.info("请求参数:"+JSON.toJSON(param));
//                //resDeductSV.deductResource(param);
//            }
//        };
//        int runnerCount = 100;
//        // Runner数组，想当于并发多少个。
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
