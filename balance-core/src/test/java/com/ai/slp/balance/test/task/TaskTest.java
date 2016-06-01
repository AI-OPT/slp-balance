//package com.ai.slp.balance.test.task;
//
//import junit.framework.TestCase;
//
//import org.junit.Test;
//
//public class TaskTest extends TestCase {
//
//    @Test
//    public void testTask() {
//        //启动余额中心定时任务
//        System.setProperty("runner.system.name", "runner-balance");
////        DTSMain.main(new String[] {});
//    }
//    
//    @Test
//    public void testAddTask(){
//        //添加定时任务:DeductBookTask
//        System.setProperty("runner.system.name", "runner-balance");
//        TaskData job = new TaskData();
//        job.setJobStatus("1");
//        job.setSchedulerName("runner-balance");
//        job.setImplClassName(DeductResBookTask.class.getName());
//        job.setDesc("离线抵扣账本");
//        job.setCronExpression("*/30 * * * * ?");
//        job.setJobGroup("DeductResBookGroup");
//        job.setJobName("DeductResBookName");
//        //job.getEnvVars().put("var1", "1");
//        //DTSSchedulerFactory.addOrUpdateTask(job);
//        job = new TaskData();
//        job.setJobStatus("1");
//        job.setSchedulerName("runner-balance");
//        job.setImplClassName(MaintainResBookTask.class.getName());
//        job.setDesc("账本生失效维护");
//        job.setCronExpression("*/3 * * * * ?");
//        job.setJobGroup("MaintainResBookGroup");
//        job.setJobName("MaintainResBookName");
//        //job.getEnvVars().put("var1", "1");
//        //DTSSchedulerFactory.addOrUpdateTask(job);
//    }
//}