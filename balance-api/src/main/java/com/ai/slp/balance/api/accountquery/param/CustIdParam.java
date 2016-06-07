package com.ai.slp.balance.api.accountquery.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 账号查询请求参数 <br>
 * Date: 2015年8月4日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class CustIdParam extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 客户ID，必填
     */
    private String custId;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    

}
