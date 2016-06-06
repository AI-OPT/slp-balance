package com.ai.slp.balance.api.fundquery.param;

import com.ai.opt.base.vo.BaseInfo;

public class ForegiftQuery extends BaseInfo{

    
    /**
     * 账户ID，必填
     */
    private long accountId;
    
    /**
     * 专款用户ID，默认0查询账户下所有押金，可选
     */
    private long subsId;

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getSubsId() {
        return subsId;
    }

    public void setSubsId(long subsId) {
        this.subsId = subsId;
    }
}
