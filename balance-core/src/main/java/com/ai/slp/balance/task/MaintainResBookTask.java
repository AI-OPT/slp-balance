//package com.ai.slp.balance.task;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.concurrent.CountDownLatch;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import com.ai.opt.sdk.util.CollectionUtil;
//import com.ai.slp.balance.dao.mapper.bo.FunResBook;
//
///**
// * 账本生失效维护处理
// *
// * Date: 2015年11月23日 <br>
// * Copyright (c) 2015 asiainfo.com <br>
// * 
// * @author lilg
// */
//@DisallowConcurrentExecution
//@PersistJobDataAfterExecution
//public class MaintainResBookTask implements ITask {
//    private static final Logger LOG = LogManager.getLogger(MaintainResBookTask.class);
//
//    // 线程数
//    private static final int THREAD_COUNT = 10;
//
//    // 提取数量
//    private static final int DATA_COUNT = 1000;
//
//    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        // 查询即将过期或者即将生效的账本
//        List<FunResBook> bookList = ServiceUtil.getITaskMaintainResBookBusiSV().queryTimeoutResBook(0,
//                DATA_COUNT);
//        if (CollectionUtil.isEmpty(bookList)) {
//            LOG.error("账本维护，未查询到数据，等待下次扫描");
//            return;
//        }
//        int total = bookList.size();
//        LOG.error("账本维护，查询到数据{}条", total);
//        // 开始处理
//        LOG.error("开始数据分组");
//        // 根据ownerId分组
//        Map<Long, List<FunResBook>> bookMap = new HashMap<Long, List<FunResBook>>();
//        for (FunResBook book : bookList) {
//            // LOG.info("处理数据{}", JSON.toJSONString(opera));
//            Long ownerId = book.getOwnerId();
//            if (bookMap.containsKey(ownerId)) {
//                bookMap.get(ownerId).add(book);
//            } else {
//                List<FunResBook> tmpList = new ArrayList<FunResBook>();
//                tmpList.add(book);
//                bookMap.put(ownerId, tmpList);
//            }
//        }
//
//        LOG.error("开始数据处理");
//        // 开始处理
//        int count = total / bookMap.size();
//        CountDownLatch lanch = null;
//        // TODO 首次无条件处理，后续若数量小于进程数则不再处理，避免每次数量过少并且循环等待造成线程同步处理。这里有待继续分析。
//        for (int i = 0; i < count && (bookMap.size() >= THREAD_COUNT || i == 0); i++) {
//            //LOG.debug("第{}次处理", i+1);
//            int size = bookMap.size();
//            lanch = new CountDownLatch(size);
//            Iterator<Entry<Long, List<FunResBook>>> it = bookMap.entrySet().iterator();
//            while (it.hasNext()) {
//                Entry<Long, List<FunResBook>> entry = it.next();
//                // CountDownLatch latch = new CountDownLatch(1);
//                MaintainResBookThread thread = new MaintainResBookThread(entry.getValue().get(0),
//                        lanch);
//                ThreadPoolFactory.createOrGetThreadPool("DEDUCT-RESBOOK", THREAD_COUNT).addThread(
//                        thread);
//                entry.getValue().remove(0);
//                if (entry.getValue().size() < 1) {
//                    it.remove();
//                }
//
//            }
//            LOG.debug("第{}次处理{}条", i+1, size);
//        }
//        try {
//            lanch.await();
//        } catch (InterruptedException e) {
//            LOG.error("线程执行期间，系统异常，具体的原因是：{}", e);
//        }
//        LOG.error("数据处理完成");
//    }
//
//}
