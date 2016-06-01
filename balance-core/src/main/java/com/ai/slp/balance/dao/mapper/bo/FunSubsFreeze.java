package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;

public class FunSubsFreeze {
    private Long subsFreezeId;

    private Long payRuleId;

    private Long freezeId;

    private Long subsId;

    private Long acctId;

    private Long subjectId;

    private Long destSubjectId;

    private String runMode;

    private String calMode;

    private Long orginalAmount;

    private Integer allotMonth;

    private Long thawFee;

    private Integer thawScale;

    private Long alreadyAllotAmount;

    private Integer alreadyAllotMonth;

    private String startAllotMonth;

    private String lastAllotMonth;

    private String allotStatus;

    private Timestamp lastAllotDate;

    private Timestamp createTime;

    private Timestamp activeDate;

    private Timestamp inactiveDate;

    private String chnlId;

    private String createOperId;

    private Integer fundActiveMonths;

    public Long getSubsFreezeId() {
        return subsFreezeId;
    }

    public void setSubsFreezeId(Long subsFreezeId) {
        this.subsFreezeId = subsFreezeId;
    }

    public Long getPayRuleId() {
        return payRuleId;
    }

    public void setPayRuleId(Long payRuleId) {
        this.payRuleId = payRuleId;
    }

    public Long getFreezeId() {
        return freezeId;
    }

    public void setFreezeId(Long freezeId) {
        this.freezeId = freezeId;
    }

    public Long getSubsId() {
        return subsId;
    }

    public void setSubsId(Long subsId) {
        this.subsId = subsId;
    }

    public Long getAcctId() {
        return acctId;
    }

    public void setAcctId(Long acctId) {
        this.acctId = acctId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getDestSubjectId() {
        return destSubjectId;
    }

    public void setDestSubjectId(Long destSubjectId) {
        this.destSubjectId = destSubjectId;
    }

    public String getRunMode() {
        return runMode;
    }

    public void setRunMode(String runMode) {
        this.runMode = runMode == null ? null : runMode.trim();
    }

    public String getCalMode() {
        return calMode;
    }

    public void setCalMode(String calMode) {
        this.calMode = calMode == null ? null : calMode.trim();
    }

    public Long getOrginalAmount() {
        return orginalAmount;
    }

    public void setOrginalAmount(Long orginalAmount) {
        this.orginalAmount = orginalAmount;
    }

    public Integer getAllotMonth() {
        return allotMonth;
    }

    public void setAllotMonth(Integer allotMonth) {
        this.allotMonth = allotMonth;
    }

    public Long getThawFee() {
        return thawFee;
    }

    public void setThawFee(Long thawFee) {
        this.thawFee = thawFee;
    }

    public Integer getThawScale() {
        return thawScale;
    }

    public void setThawScale(Integer thawScale) {
        this.thawScale = thawScale;
    }

    public Long getAlreadyAllotAmount() {
        return alreadyAllotAmount;
    }

    public void setAlreadyAllotAmount(Long alreadyAllotAmount) {
        this.alreadyAllotAmount = alreadyAllotAmount;
    }

    public Integer getAlreadyAllotMonth() {
        return alreadyAllotMonth;
    }

    public void setAlreadyAllotMonth(Integer alreadyAllotMonth) {
        this.alreadyAllotMonth = alreadyAllotMonth;
    }

    public String getStartAllotMonth() {
        return startAllotMonth;
    }

    public void setStartAllotMonth(String startAllotMonth) {
        this.startAllotMonth = startAllotMonth == null ? null : startAllotMonth.trim();
    }

    public String getLastAllotMonth() {
        return lastAllotMonth;
    }

    public void setLastAllotMonth(String lastAllotMonth) {
        this.lastAllotMonth = lastAllotMonth == null ? null : lastAllotMonth.trim();
    }

    public String getAllotStatus() {
        return allotStatus;
    }

    public void setAllotStatus(String allotStatus) {
        this.allotStatus = allotStatus == null ? null : allotStatus.trim();
    }

    public Timestamp getLastAllotDate() {
        return lastAllotDate;
    }

    public void setLastAllotDate(Timestamp lastAllotDate) {
        this.lastAllotDate = lastAllotDate;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Timestamp activeDate) {
        this.activeDate = activeDate;
    }

    public Timestamp getInactiveDate() {
        return inactiveDate;
    }

    public void setInactiveDate(Timestamp inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public String getChnlId() {
        return chnlId;
    }

    public void setChnlId(String chnlId) {
        this.chnlId = chnlId == null ? null : chnlId.trim();
    }

    public String getCreateOperId() {
        return createOperId;
    }

    public void setCreateOperId(String createOperId) {
        this.createOperId = createOperId == null ? null : createOperId.trim();
    }

    public Integer getFundActiveMonths() {
        return fundActiveMonths;
    }

    public void setFundActiveMonths(Integer fundActiveMonths) {
        this.fundActiveMonths = fundActiveMonths;
    }
}