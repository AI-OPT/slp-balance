package com.ai.slp.balance.api.custcredit.param;

import java.io.Serializable;
import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseResponse;
/**
 * 授信详情返回报文
 *
 * Date: 2016年7月21日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * @author zhangzd
 */
public class CustCreditDetailResponse extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long cashDeposit; //保证金

	private Long credit; //信用额度

	private Timestamp creditActiveTime; //生效时间
	
	private Timestamp creditExpireTime; //失效时间
	
	private Integer postpayUnits; //还款时限周期数
	
	private String postpayType; //还款时限周期类型
	
	private String billGenType; //账单周期类型

	public Long getCashDeposit() {
		return cashDeposit;
	}

	public void setCashDeposit(Long cashDeposit) {
		this.cashDeposit = cashDeposit;
	}

	public Long getCredit() {
		return credit;
	}

	public void setCredit(Long credit) {
		this.credit = credit;
	}

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
