package com.ai.slp.balance.test.api.resdeposit.impl;

import junit.framework.TestCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.balance.api.resdeposit.interfaces.IResDepositSV;
import com.ai.slp.balance.api.resdeposit.param.ResourceDeposit;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class ResDepositTest extends TestCase {
    private static final Logger log = LogManager.getLogger(ResDepositTest.class);

    @Autowired
    private IResDepositSV resDepositSV;

    @Test
    public void testResDeposit() {
        ResourceDeposit param = new ResourceDeposit();
        param.setTenantId("BIS-ST");
        param.setOwnerId(10);
        param.setOwnerType(0);
        param.setAllowClear(0);
        param.setAllowConvert(0);
        param.setAllowPresent(0);
        param.setExternalId("111111111");
        param.setSourceId(10000);
        param.setSourceType(0);
        param.setSystemId("22222222222");
        param.setTotalAmount(100);
        param.setResourceType(60);
        param.setExpireDate(DateUtil.getDateString(DateUtil.getOffsetYearsTime(DateUtil.getSysDate(), 1), DateUtil.DATETIME_FORMAT));
        log.error("请求参数:"+JSON.toJSON(param));
    }
}
