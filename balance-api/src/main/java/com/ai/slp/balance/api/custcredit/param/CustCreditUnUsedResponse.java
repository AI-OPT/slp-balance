package com.ai.slp.balance.api.custcredit.param;

import java.io.Serializable;

import com.ai.opt.base.vo.BaseResponse;

public class CustCreditUnUsedResponse extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long unUsedCredit;// 未使用信用额度

	public Long getUnUsedCredit() {
		return unUsedCredit;
	}

	public void setUnUsedCredit(Long unUsedCredit) {
		this.unUsedCredit = unUsedCredit;
	}

}
