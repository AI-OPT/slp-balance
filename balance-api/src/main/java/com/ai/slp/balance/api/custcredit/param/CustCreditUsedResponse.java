package com.ai.slp.balance.api.custcredit.param;

import java.io.Serializable;

import com.ai.opt.base.vo.BaseResponse;

public class CustCreditUsedResponse extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long usedCredit;// 已使用信用额度

	public Long getUsedCredit() {
		return usedCredit;
	}

	public void setUsedCredit(Long usedCredit) {
		this.usedCredit = usedCredit;
	}

}
