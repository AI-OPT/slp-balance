package com.ai.slp.balance.api.custcredit.param;

import java.io.Serializable;
import java.sql.Timestamp;

public class CustCreditSettingRecordVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Timestamp updateTime;
	
	private Long settingAfterCredit;//调整后额度
	
	private Long settingBeforCredit;//调整前额度
	
	private Long settingCredit;//调整差额  调整后额度减去调整前额度
	
	private String operCode;//调整人编码
	
	private String remark;//备注

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Long getSettingAfterCredit() {
		return settingAfterCredit;
	}

	public void setSettingAfterCredit(Long settingAfterCredit) {
		this.settingAfterCredit = settingAfterCredit;
	}

	public Long getSettingBeforCredit() {
		return settingBeforCredit;
	}

	public void setSettingBeforCredit(Long settingBeforCredit) {
		this.settingBeforCredit = settingBeforCredit;
	}

	public Long getSettingCredit() {
		return settingCredit;
	}

	public void setSettingCredit(Long settingCredit) {
		this.settingCredit = settingCredit;
	}

	public String getOperCode() {
		return operCode;
	}

	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
