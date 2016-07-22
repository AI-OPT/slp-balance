package com.ai.slp.balance.api.custcredit.param;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

public class CustCreditSettingRecordResponse extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PageInfo<CustCreditSettingRecordVo> custCreditSettingRecordVoPageInfo = new PageInfo<CustCreditSettingRecordVo>();

	public PageInfo<CustCreditSettingRecordVo> getCustCreditSettingRecordVoPageInfo() {
		return custCreditSettingRecordVoPageInfo;
	}

	public void setCustCreditSettingRecordVoPageInfo(
			PageInfo<CustCreditSettingRecordVo> custCreditSettingRecordVoPageInfo) {
		this.custCreditSettingRecordVoPageInfo = custCreditSettingRecordVoPageInfo;
	}

}
