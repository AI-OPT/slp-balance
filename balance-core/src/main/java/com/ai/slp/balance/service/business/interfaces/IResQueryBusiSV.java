package com.ai.slp.balance.service.business.interfaces;

import java.util.List;

import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.balance.api.resquery.param.ResAmount;
import com.ai.slp.balance.api.resquery.param.ResAmountQuery;
import com.ai.slp.balance.api.resquery.param.ResPkgInfo;
import com.ai.slp.balance.api.resquery.param.ResPkgQuery;

public interface IResQueryBusiSV {

    /**
     * 资源可用总量查询
     * 
     * @param param
     * @return 可用总量
     * @throws BusinessException
     * @author lilg
     */
    public ResAmount queryUsableAmount(ResAmountQuery param) throws BusinessException;

    /**
     * 资源查询－套餐余量查询
     * 
     * @param param
     * @return 套餐列表
     * @throws BusinessException
     * @author lilg
     */
    public List<ResPkgInfo> queryResPackage(ResPkgQuery param) throws BusinessException;

}
