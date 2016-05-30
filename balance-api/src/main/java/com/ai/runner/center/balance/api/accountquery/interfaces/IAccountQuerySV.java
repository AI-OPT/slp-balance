package com.ai.runner.center.balance.api.accountquery.interfaces;

import java.util.List;

import com.ai.runner.base.exception.CallerException;
import com.ai.runner.center.balance.api.accountquery.param.AccountIdParam;
import com.ai.runner.center.balance.api.accountquery.param.AccountInfoVo;
import com.ai.runner.center.balance.api.accountquery.param.CustIdParam;

/**
 * 账户查询接口类 <br>
 *
 * Date: 2015年8月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IAccountQuerySV {

    /**
     * 按账户查询账户资料.<br>
     * 按照账户查询账户的基本资料<br>
     * 
     * @param accountId
     * @return 账户信息
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0012
     */
    public AccountInfoVo queryAccontById(AccountIdParam accountId) throws CallerException;

    /**
     * 按客户查询账户资料.<br>
     * 按照账户查询账户的基本资料<br>
     * 
     * @param custId
     * @return 账户信息列表
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0013
     */
    public List<AccountInfoVo> queryAccontByCustId(CustIdParam custId) throws CallerException;

}
