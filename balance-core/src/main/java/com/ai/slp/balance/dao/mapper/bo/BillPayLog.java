package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;

public class BillPayLog {
    private String payLogSeq;

    private String tenantId;

    private String userId;

    private Long accountId;

    private Timestamp payDate;

    private Long payFee;

    private Long status;

    private Timestamp rollbackDate;

    private Long overdraft;

    public String getPayLogSeq() {
        return payLogSeq;
    }

    public void setPayLogSeq(String payLogSeq) {
        this.payLogSeq = payLogSeq == null ? null : payLogSeq.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Timestamp getPayDate() {
        return payDate;
    }

    public void setPayDate(Timestamp payDate) {
        this.payDate = payDate;
    }

    public Long getPayFee() {
        return payFee;
    }

    public void setPayFee(Long payFee) {
        this.payFee = payFee;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Timestamp getRollbackDate() {
        return rollbackDate;
    }

    public void setRollbackDate(Timestamp rollbackDate) {
        this.rollbackDate = rollbackDate;
    }

    public Long getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(Long overdraft) {
        this.overdraft = overdraft;
    }
}