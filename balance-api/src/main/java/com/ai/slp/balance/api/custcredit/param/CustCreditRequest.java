package com.ai.slp.balance.api.custcredit.param;

import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;

public class CustCreditRequest extends BaseInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String accountId;

	private String custId;

	private Long cashDeposit; // 保证金

	private Long credit; // 信用额度

	private String operId;

	private String operCode;

	private Timestamp creditActiveTime;

	private Timestamp creditExpireTime;

	private Integer postpayUnits; // 还款时限周期数

	private String postpayType; // 还款时限周期类型

	private String billGenType; // 账单周期类型

	public Timestamp getCreditActiveTime() {
		return creditActiveTime;
	}

	public void setCreditActiveTime(Timestamp creditActiveTime) {
		this.creditActiveTime = creditActiveTime;
	}

	public Timestamp getCreditExpireTime() {
		return creditExpireTime;
	}

	public void setCreditExpireTime(Timestamp creditExpireTime) {
		this.creditExpireTime = creditExpireTime;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getOperCode() {
		return operCode;
	}

	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}

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

	public Long getCashDeposit() {
		return cashDeposit;
	}

	public void setCashDeposit(Long cashDeposit) {
		this.cashDeposit = cashDeposit;
	}

	public Integer getPostpayUnits() {
		return postpayUnits;
	}

	public void setPostpayUnits(Integer postpayUnits) {
		this.postpayUnits = postpayUnits;
	}

	public String getPostpayType() {
		return postpayType;
	}

	public void setPostpayType(String postpayType) {
		this.postpayType = postpayType;
	}

	public String getBillGenType() {
		return billGenType;
	}

	public void setBillGenType(String billGenType) {
		this.billGenType = billGenType;
	}

}
