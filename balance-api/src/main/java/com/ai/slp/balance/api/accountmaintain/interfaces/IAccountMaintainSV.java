package com.ai.slp.balance.api.accountmaintain.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.accountmaintain.param.AccountUpdateParam;
import com.ai.slp.balance.api.accountmaintain.param.RegAccReq;

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
    public long createAccount(RegAccReq regAccReq) throws BusinessException,SystemException;

    /**
     * 账户资料修改.<br>
     * 对账户资料进行修改<br>
     * 
     * @param param
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0015
     */
    public void updateAccount(AccountUpdateParam param) throws BusinessException,SystemException;

}
