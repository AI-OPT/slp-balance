package com.ai.slp.balance.test.api.resquery.impl;

import java.util.List;

import junit.framework.TestCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.slp.balance.api.resquery.interfaces.IResQuerySV;
import com.ai.slp.balance.api.resquery.param.ResAmount;
import com.ai.slp.balance.api.resquery.param.ResAmountQuery;
import com.ai.slp.balance.api.resquery.param.ResPkgInfo;
import com.ai.slp.balance.api.resquery.param.ResPkgQuery;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class ResBookQueryTest extends TestCase {
    
    private static final Logger log = LogManager.getLogger(ResBookQueryTest.class);

    @Autowired
    private IResQuerySV resQuerySV;

    @Test
    public void testQueryResPackage() {
        ResPkgQuery param = new ResPkgQuery();
        param.setOwnerType(0);
        param.setOwnerId(50673);
        param.setTenantId("VIV");
        List<ResPkgInfo> resPkgInfoList = resQuerySV.queryResPackage(param);
        assertNotNull("返回结果为NULL", resPkgInfoList);
        assertTrue("返回结果集为空", resPkgInfoList.size() > 0);
        //assertEquals("查询账户ID不是预期值", 10000, resPkgInfoList.get(0).getProdElementId());
        log.error("查询结果:"+JSON.toJSON(resPkgInfoList));
    }
    
    @Test
    public void testQueryUsableAmount(){
        
        ResAmountQuery param =new ResAmountQuery();
        param.setOwnerType(0);
        param.setOwnerId(50673);
        param.setTenantId("VIV");
        param.setResourceType(60);
        ResAmount amount = resQuerySV.queryUsableAmount(param);
        log.error("查询结果:"+JSON.toJSON(amount));
        
    }
}
