package com.ai.slp.balance.api.accountquery.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 账号查询请求参数 <br>
 * Date: 2015年8月4日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class AccountIdParam extends BaseInfo{

    private static final long serialVersionUID = 1L;
    
    /**
     * 账户ID，必填
     */
    private long accountId;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

}
