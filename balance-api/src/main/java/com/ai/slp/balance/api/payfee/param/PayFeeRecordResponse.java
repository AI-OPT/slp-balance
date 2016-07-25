package com.ai.slp.balance.api.payfee.param;

import java.io.Serializable;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

public class PayFeeRecordResponse extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PageInfo<PayFeeRecordVo> PayFeeRecordVoPageInfo = new PageInfo<PayFeeRecordVo>();

	public PageInfo<PayFeeRecordVo> getPayFeeRecordVoPageInfo() {
		return PayFeeRecordVoPageInfo;
	}

	public void setPayFeeRecordVoPageInfo(PageInfo<PayFeeRecordVo> payFeeRecordVoPageInfo) {
		PayFeeRecordVoPageInfo = payFeeRecordVoPageInfo;
	}
	

}
