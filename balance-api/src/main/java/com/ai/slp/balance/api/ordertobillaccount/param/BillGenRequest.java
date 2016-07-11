package com.ai.slp.balance.api.ordertobillaccount.param;

import java.io.Serializable;
import java.sql.Timestamp;

import com.ai.opt.base.vo.BaseInfo;

public class BillGenRequest extends BaseInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BillGenRequest() {
		// TODO Auto-generated constructor stub
	}

	// 账户ID
	private String accountId;

	// 用户ID
	private String userId;

	// 消费金额
	private Long fee;
	// 订单透支金额
	private Long overdraftQuota;

	// 订单生成时间
	private Timestamp orderTime;
	// 商品类目
	private String productCatId;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getFee() {
		return fee;
	}

	public void setFee(Long fee) {
		this.fee = fee;
	}

	public Long getOverdraftQuota() {
		return overdraftQuota;
	}

	public void setOverdraftQuota(Long overdraftQuota) {
		this.overdraftQuota = overdraftQuota;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public String getProductCatId() {
		return productCatId;
	}

	public void setProductCatId(String productCatId) {
		this.productCatId = productCatId;
	}

}
