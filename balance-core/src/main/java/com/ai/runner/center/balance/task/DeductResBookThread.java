package com.ai.runner.center.balance.task;

import java.util.concurrent.CountDownLatch;

import com.ai.runner.center.balance.dao.mapper.bo.FunResOperaDetail;
import com.ai.runner.utils.dts.thread.AbstractTaskThread;

public class DeductResBookThread extends AbstractTaskThread<FunResOperaDetail> {

    // private static final Logger LOG = LogManager.getLogger(DeductResBookThread.class);

    public DeductResBookThread(FunResOperaDetail bo, CountDownLatch lanch) {
        super(bo, lanch);
    }

    @Override
    public void execute(FunResOperaDetail paramT) throws Exception {
        ServiceUtil.getITaskDeductResBookBusiSV().deductResBook(paramT);
    }

}
