//package com.ai.slp.balance.task;
//
//import java.util.concurrent.CountDownLatch;
//
//import com.ai.slp.balance.dao.mapper.bo.FunResBook;
//
//public class MaintainResBookThread extends AbstractTaskThread<FunResBook> {
//
//    //private static final Logger LOG = LogManager.getLogger(MaintainResBookThread.class);
//
//    //private static Map<Long, CountDownLatch> latchMap = Collections.synchronizedMap(new HashMap<Long, CountDownLatch>());
//
//
//    //private CountDownLatch latch;
//
//    public MaintainResBookThread(FunResBook bo, CountDownLatch lanch) {
//        super(bo, lanch);
//    }
//
//    @Override
//    public void execute(FunResBook paramT) throws Exception {
//        /*
//        try {
//            if (latchMap.containsKey(paramT.getOwnerId())) {
//                latchMap.get(paramT.getOwnerId()).await();
//                latchMap.remove(paramT.getOwnerId());
//            }
//            latchMap.put(paramT.getOwnerId(), this.latch);
//            this.getITaskMaintainResBookBusiSV().maintainResBook(paramT);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            this.latch.countDown();
//        }*/
//        ServiceUtil.getITaskMaintainResBookBusiSV().maintainResBook(paramT);
//    }
//}
