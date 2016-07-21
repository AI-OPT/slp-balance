package com.ai.slp.balance.api.custcredit.param;

import java.io.Serializable;

import com.ai.opt.base.vo.BaseInfo;

public class CustCreditDetailRequest extends BaseInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long accountId;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

}
