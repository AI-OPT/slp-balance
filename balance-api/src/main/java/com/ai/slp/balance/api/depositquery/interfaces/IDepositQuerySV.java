package com.ai.slp.balance.api.depositquery.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;


public interface IDepositQuerySV {

    /**
     * 按账户查询缴费记录,未规划
     * @param param
     * @return
     * @throws BusinessException,SystemException
     * @author lilg
     */
    public String depositQuery(int param) throws BusinessException,SystemException;
}
