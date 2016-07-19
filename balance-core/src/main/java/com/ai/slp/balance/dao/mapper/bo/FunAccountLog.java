package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;

public class FunAccountLog {
    private String tenantId;

    private Long accountId;

    private String acctName;

    private String custId;

    private String acctType;

    private String payType;

    private String postType;

    private String acctAddr;

    private String email;

    private Long totalBalance;

    private Long credit;

    private Long tempCredit;

    private Timestamp tempValidTime;

    private Long dTotQuota;

    private Long dSigQuota;

    private Long dTransQuota;

    private String acctStatus;

    private Timestamp balanceChgDate;

    private String remark;

    private Timestamp updateTime;

    private Long billCycleDefId;

    private String topBillCycleId;

    private Timestamp creditActiveTime;

    private Timestamp creditExpireTime;

    private Long oldCredit;

    private String updateMask;

    private Long operId;

    private String operCode;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName == null ? null : acctName.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType == null ? null : acctType.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType == null ? null : postType.trim();
    }

    public String getAcctAddr() {
        return acctAddr;
    }

    public void setAcctAddr(String acctAddr) {
        this.acctAddr = acctAddr == null ? null : acctAddr.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Long totalBalance) {
        this.totalBalance = totalBalance;
    }

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public Long getTempCredit() {
        return tempCredit;
    }

    public void setTempCredit(Long tempCredit) {
        this.tempCredit = tempCredit;
    }

    public Timestamp getTempValidTime() {
        return tempValidTime;
    }

    public void setTempValidTime(Timestamp tempValidTime) {
        this.tempValidTime = tempValidTime;
    }

    public Long getdTotQuota() {
        return dTotQuota;
    }

    public void setdTotQuota(Long dTotQuota) {
        this.dTotQuota = dTotQuota;
    }

    public Long getdSigQuota() {
        return dSigQuota;
    }

    public void setdSigQuota(Long dSigQuota) {
        this.dSigQuota = dSigQuota;
    }

    public Long getdTransQuota() {
        return dTransQuota;
    }

    public void setdTransQuota(Long dTransQuota) {
        this.dTransQuota = dTransQuota;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus == null ? null : acctStatus.trim();
    }

    public Timestamp getBalanceChgDate() {
        return balanceChgDate;
    }

    public void setBalanceChgDate(Timestamp balanceChgDate) {
        this.balanceChgDate = balanceChgDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Long getBillCycleDefId() {
        return billCycleDefId;
    }

    public void setBillCycleDefId(Long billCycleDefId) {
        this.billCycleDefId = billCycleDefId;
    }

    public String getTopBillCycleId() {
        return topBillCycleId;
    }

    public void setTopBillCycleId(String topBillCycleId) {
        this.topBillCycleId = topBillCycleId == null ? null : topBillCycleId.trim();
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

    public Long getOldCredit() {
        return oldCredit;
    }

    public void setOldCredit(Long oldCredit) {
        this.oldCredit = oldCredit;
    }

    public String getUpdateMask() {
        return updateMask;
    }

    public void setUpdateMask(String updateMask) {
        this.updateMask = updateMask == null ? null : updateMask.trim();
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public String getOperCode() {
        return operCode;
    }

    public void setOperCode(String operCode) {
        this.operCode = operCode == null ? null : operCode.trim();
    }
}