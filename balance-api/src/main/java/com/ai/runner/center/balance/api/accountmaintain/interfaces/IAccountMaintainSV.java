package com.ai.runner.center.balance.api.accountmaintain.interfaces;

import com.ai.runner.base.exception.CallerException;
import com.ai.runner.center.balance.api.accountmaintain.param.AccountUpdateParam;
import com.ai.runner.center.balance.api.accountmaintain.param.RegAccReq;

/**
 * 创建账户接口类 <br>
 *
 * Date: 2015年8月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IAccountMaintainSV {

    /**
     * 创建账户.<br>
     * 创建账户资料<br>
     * 
     * @param regAccReq
     * @return 账户ID
     * @author limy6
     * @ApiDocMethod
     * @ApiCode ABM_0011
     */
    public long createAccount(RegAccReq regAccReq) throws CallerException;

    /**
     * 账户资料修改.<br>
     * 对账户资料进行修改<br>
     * 
     * @param param
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0015
     */
    public void updateAccount(AccountUpdateParam param) throws CallerException;

}
