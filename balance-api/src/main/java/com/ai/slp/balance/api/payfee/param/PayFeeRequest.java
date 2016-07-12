package com.ai.slp.balance.api.payfee.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;

public class PayFeeRequest extends BaseInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String accountId;
	private String custId;
	private Timestamp payFeeTime;
	private Long payFee;
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
	public Timestamp getPayFeeTime() {
		return payFeeTime;
	}
	public void setPayFeeTime(Timestamp payFeeTime) {
		this.payFeeTime = payFeeTime;
	}
	public Long getPayFee() {
		return payFee;
	}
	public void setPayFee(Long payFee) {
		this.payFee = payFee;
	}
}
