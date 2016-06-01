package com.ai.slp.balance.test.ats;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context/core-context.xml")
public class ATSListenerTest {
    
    @Autowired
    protected ApplicationContext ctx;
    
    public <T> T getBean(Class<T> type) {
        return ctx.getBean(type);
    }
    
    public Object getBean(String beanName) {
        return ctx.getBean(beanName);
    }
    
    /**
     * 启动 ATS 消息服务
     * @author limy6
     * @ApiDocMethod
     */
    @Test
    public void testATSListener() {
//        ATSListenerStart.main(null);
    }

}
