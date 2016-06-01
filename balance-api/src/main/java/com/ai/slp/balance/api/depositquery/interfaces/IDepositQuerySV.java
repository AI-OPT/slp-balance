package com.ai.slp.balance.api.depositquery.interfaces;

import com.ai.runner.base.exception.CallerException;

public interface IDepositQuerySV {

    /**
     * 按账户查询缴费记录,未规划
     * @param param
     * @return
     * @throws CallerException
     * @author lilg
     */
    public String depositQuery(int param) throws CallerException;
}
