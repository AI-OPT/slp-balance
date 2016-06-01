//package com.ai.slp.balance.task;
//
//import java.util.concurrent.CountDownLatch;
//
//import com.ai.slp.balance.dao.mapper.bo.FunResOperaDetail;
//
//public class DeductResBookThread extends AbstractTaskThread<FunResOperaDetail> {
//
//    // private static final Logger LOG = LogManager.getLogger(DeductResBookThread.class);
//
//    public DeductResBookThread(FunResOperaDetail bo, CountDownLatch lanch) {
//        super(bo, lanch);
//    }
//
//    @Override
//    public void execute(FunResOperaDetail paramT) throws Exception {
//        ServiceUtil.getITaskDeductResBookBusiSV().deductResBook(paramT);
//    }
//
//}
