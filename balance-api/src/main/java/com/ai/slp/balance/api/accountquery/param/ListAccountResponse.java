package com.ai.slp.balance.api.accountquery.param;

import java.util.List;

import com.ai.opt.base.vo.BaseResponse;

public class ListAccountResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<AccountInfoVo> accountInfoVoList = null;

	public List<AccountInfoVo> getAccountInfoVoList() {
		return accountInfoVoList;
	}

	public void setAccountInfoVoList(List<AccountInfoVo> accountInfoVoList) {
		this.accountInfoVoList = accountInfoVoList;
	}
	

}
