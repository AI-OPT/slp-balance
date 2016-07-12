package com.ai.slp.balance.api.custcredit.param;

import com.ai.opt.base.vo.BaseInfo;

public class CustCreditRequest extends BaseInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String accountId;

	private String custId;
	
	private Long credit;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Long getCredit() {
		return credit;
	}

	public void setCredit(Long credit) {
		this.credit = credit;
	}
}
