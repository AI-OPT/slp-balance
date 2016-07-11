package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;

public class BillPayDetail extends BillPayDetailKey {
    private String tenantId;

    private String userId;

    private Long accountId;

    private Long payBillFee;

    private Long status;

    private Timestamp rollbackDate;

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

    public Long getPayBillFee() {
        return payBillFee;
    }

    public void setPayBillFee(Long payBillFee) {
        this.payBillFee = payBillFee;
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
}