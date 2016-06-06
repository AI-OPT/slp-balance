package com.ai.slp.balance.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByCustIdIdx;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByExternalIdIdx;

/**
 * 索引表服务接口 Date: 2015年8月7日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author limy6
 */
public interface IAccountIndexManageSV {
    /**
     * 写入 账户-外部流水号索引表
     * 
     * @param vo
     * @author limy6
     * @ApiDocMethod
     */
    public void insertFunAccountInfoByExternalIdIdx(FunAccountInfoByExternalIdIdx vo)
            throws BusinessException;

    /**
     * 写入 账户-客户号码索引表
     * 
     * @param vo
     * @author limy6
     * @ApiDocMethod
     */
    public void insertFunAccountInfoByCustIdIdx(FunAccountInfoByCustIdIdx vo)
            throws BusinessException;

}
