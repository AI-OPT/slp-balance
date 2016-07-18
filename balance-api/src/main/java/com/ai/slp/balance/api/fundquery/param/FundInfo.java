package com.ai.slp.balance.api.fundquery.param;

import java.io.Serializable;
import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

/**
 * 余额查询结果对象
 *
 * Date: 2015年10月12日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class FundInfo extends BaseResponse implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 租户ID
     */
    private String tenantId;

    /**
     * 账户ID
     */
    private long accountId;

    /**
     * 账户余额
     */
    private long balance;

    /**
     * 账本列表
     */
    private List<FundBook> fundBooks;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public List<FundBook> getFundBooks() {
        return fundBooks;
    }

    public void setFundBooks(List<FundBook> fundBooks) {
        this.fundBooks = fundBooks;
    }

}
