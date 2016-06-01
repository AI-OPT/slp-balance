package com.ai.slp.balance.api.resquery.interfaces;

import java.util.List;

import com.ai.runner.base.exception.CallerException;
import com.ai.slp.balance.api.resquery.param.ResAmount;
import com.ai.slp.balance.api.resquery.param.ResAmountQuery;
import com.ai.slp.balance.api.resquery.param.ResDetailQuery;
import com.ai.slp.balance.api.resquery.param.ResPkgInfo;
import com.ai.slp.balance.api.resquery.param.ResPkgQuery;
import com.ai.slp.balance.api.resquery.param.ResUsableDetail;

/**
 * 账户资源查询接口
 * 
 * Date: 2015年8月24日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IResQuerySV {

    /**
     * 资源账本总表余量查询.<br>
     * 为计费提供实时的资源账本总表余量查询，用于信控。<br>
     * 
     * @param param
     * @return 可用总量
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0045
     */
    public ResAmount queryUsableAmount(ResAmountQuery param) throws CallerException;

    /**
     * 套餐余量查询.<br>
     * 支持套餐余量查询及账本明细查询<br>
     * 
     * @param param
     * @return 套餐列表
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0042
     */
    public List<ResPkgInfo> queryResPackage(ResPkgQuery param) throws CallerException;

    /**
     * 资源可用余量查询,未规划
     * 
     * @param param
     * @return 可用资源列表
     * @throws CallerException
     * @author lilg
     */
    public ResUsableDetail queryUsableDetail(ResDetailQuery param) throws CallerException;
}
