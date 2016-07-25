package com.ai.slp.balance.api.payfee.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class PayFeeRecordVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Timestamp payDate;

	private Long payFee;

	private Long overdraft;

	private String remark;

	public Timestamp getPayDate() {
		return payDate;
	}

	public void setPayDate(Timestamp payDate) {
		this.payDate = payDate;
	}

	public Long getPayFee() {
		return payFee;
	}

	public void setPayFee(Long payFee) {
		this.payFee = payFee;
	}

	public Long getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(Long overdraft) {
		this.overdraft = overdraft;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
