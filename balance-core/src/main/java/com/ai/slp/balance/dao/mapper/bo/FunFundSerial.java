package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;

public class FunFundSerial {
    private String paySerialCode;

    private String tenantId;

    private String systemId;

    private String peerSerialCode;

    private String cancelSerialCode;

    private String optType;

    private Long totalAmount;

    private String transSummary;

    private Long payRuleId;

    private String payStatus;

    private Long acctId1;

    private String acctName1;

    private Long acctId2;

    private String acctName2;

    private Timestamp createTime;

    private Timestamp payTime;

    private Timestamp lastStatusDate;

    private String remark;

    public String getPaySerialCode() {
        return paySerialCode;
    }

    public void setPaySerialCode(String paySerialCode) {
        this.paySerialCode = paySerialCode == null ? null : paySerialCode.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId == null ? null : systemId.trim();
    }

    public String getPeerSerialCode() {
        return peerSerialCode;
    }

    public void setPeerSerialCode(String peerSerialCode) {
        this.peerSerialCode = peerSerialCode == null ? null : peerSerialCode.trim();
    }

    public String getCancelSerialCode() {
        return cancelSerialCode;
    }

    public void setCancelSerialCode(String cancelSerialCode) {
        this.cancelSerialCode = cancelSerialCode == null ? null : cancelSerialCode.trim();
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType == null ? null : optType.trim();
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTransSummary() {
        return transSummary;
    }

    public void setTransSummary(String transSummary) {
        this.transSummary = transSummary == null ? null : transSummary.trim();
    }

    public Long getPayRuleId() {
        return payRuleId;
    }

    public void setPayRuleId(Long payRuleId) {
        this.payRuleId = payRuleId;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
    }

    public Long getAcctId1() {
        return acctId1;
    }

    public void setAcctId1(Long acctId1) {
        this.acctId1 = acctId1;
    }

    public String getAcctName1() {
        return acctName1;
    }

    public void setAcctName1(String acctName1) {
        this.acctName1 = acctName1 == null ? null : acctName1.trim();
    }

    public Long getAcctId2() {
        return acctId2;
    }

    public void setAcctId2(Long acctId2) {
        this.acctId2 = acctId2;
    }

    public String getAcctName2() {
        return acctName2;
    }

    public void setAcctName2(String acctName2) {
        this.acctName2 = acctName2 == null ? null : acctName2.trim();
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public Timestamp getLastStatusDate() {
        return lastStatusDate;
    }

    public void setLastStatusDate(Timestamp lastStatusDate) {
        this.lastStatusDate = lastStatusDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}