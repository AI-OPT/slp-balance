package com.ai.slp.balance.test.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DubboServerStart {
    
    private static final Logger LOG = LogManager.getLogger(DubboServerStart.class);

    private static final String DUBBO_CONTEXT = "classpath:dubbo-provider.xml";

    public static void main(String[] args) {
        LOG.info("开始启动 Dubbo 服务---------------------------");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { DUBBO_CONTEXT });
        context.registerShutdownHook();
        context.start();
        LOG.error(" Dubbo 服务启动完毕---------------------------");
        while (true) {
            try {
                Thread.currentThread();
                Thread.sleep(3000L);
            } catch (Exception e) {
                LOG.error("Dubbo 系统错误，具体信息为："+e.getMessage(),e);
            }
        }
    }
}
