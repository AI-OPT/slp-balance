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
//import com.ai.slp.balance.dao.mapper.bo.FunResOperaDetail;
//
///**
// * 离线抵扣账本
// *
// * Date: 2015年11月23日 <br>
// * Copyright (c) 2015 asiainfo.com <br>
// * 
// * @author lilg
// */
//@DisallowConcurrentExecution
//@PersistJobDataAfterExecution
//public class DeductResBookTask implements ITask {
//
//    private static final Logger LOG = LogManager.getLogger(DeductResBookTask.class);
//
//    // 线程数
//    private static final int THREAD_COUNT = 10;
//
//    // 提取数量
//    private static final int DATA_COUNT = 200;
//
//    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        // 查询等待抵扣的数据
//        List<FunResOperaDetail> operaList = ServiceUtil.getITaskDeductResBookBusiSV().queryWaitDeduct(0,
//                DATA_COUNT);
//        if (CollectionUtil.isEmpty(operaList)) {
//            LOG.error("离线抵扣，未查询到数据，等待下次扫描");
//            return;
//        }
//        LOG.error("离线抵扣，查询到数据{}条", operaList.size());
//        // 根据ownerId分组
//        Map<Long, List<FunResOperaDetail>> operaMap = new HashMap<Long, List<FunResOperaDetail>>();
//        for (FunResOperaDetail opera : operaList) {
//            // LOG.info("处理数据{}", JSON.toJSONString(opera));
//            Long ownerId = opera.getOwnerId();
//            if (operaMap.containsKey(ownerId)) {
//                operaMap.get(ownerId).add(opera);
//            } else {
//                List<FunResOperaDetail> tmpList = new ArrayList<FunResOperaDetail>();
//                tmpList.add(opera);
//                operaMap.put(ownerId, tmpList);
//            }
//        }
//        // 开始处理
//        int initSize = operaMap.size();
//        // TODO 首次无条件处理，后续若数量小于进程数则不再处理，避免每次数量过少并且循环等待造成线程同步处理。这里有待继续分析。
//        while (operaMap.size() >= THREAD_COUNT || initSize == operaMap.size()) {
//            CountDownLatch lanch = new CountDownLatch(operaMap.size());
//            Iterator<Entry<Long, List<FunResOperaDetail>>> it = operaMap.entrySet().iterator();
//            while (it.hasNext()) {
//                Entry<Long, List<FunResOperaDetail>> entry = it.next();
//                DeductResBookThread thread = new DeductResBookThread(entry.getValue().get(0), lanch);
//                ThreadPoolFactory.createOrGetThreadPool("DEDUCT-RESBOOK", THREAD_COUNT).addThread(
//                        thread);
//                entry.getValue().remove(0);
//                if (entry.getValue().size() < 1) {
//                    it.remove();
//                }
//            }
//            try {
//                lanch.await();
//            } catch (InterruptedException e) {
//                LOG.error("线程执行期间，系统异常，具体的原因是：{}", e);
//            }
//        }
//    }
//}
