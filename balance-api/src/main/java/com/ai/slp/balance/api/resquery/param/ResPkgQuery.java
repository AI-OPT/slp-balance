package com.ai.slp.balance.api.resquery.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 套餐余量查询请求参数
 *
 * Date: 2015年10月21日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class ResPkgQuery extends BaseInfo {

    /**
     * 套餐属主ID,必填
     */
    private long ownerId;

    /**
     * 属主类型,必填 <br>
     * 0 － 用户 <br>
     * 1 － 账户 <br>
     */
    private int ownerType;

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public int getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(int ownerType) {
        this.ownerType = ownerType;
    }

}
