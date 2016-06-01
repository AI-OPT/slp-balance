package com.ai.slp.balance.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ai.slp.balance.service.business.interfaces.ITaskDeductResBookBusiSV;
import com.ai.slp.balance.service.business.interfaces.ITaskMaintainResBookBusiSV;

public final class ServiceUtil {
    private ServiceUtil(){
        
    }

    private static ApplicationContext ac;

    static {
        ac = new FileSystemXmlApplicationContext("classpath:context/core-context.xml");
    }

    public static ITaskMaintainResBookBusiSV getITaskMaintainResBookBusiSV() {
        return (ITaskMaintainResBookBusiSV) ac.getBean("taskMaintainResBookBusiSVImpl");
    }

    public static ITaskDeductResBookBusiSV getITaskDeductResBookBusiSV() {
        return (ITaskDeductResBookBusiSV) ac.getBean("taskDeductResBookBusiSVImpl");
    }
}
