package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;

public class BillAccount extends BillAccountKey {
    private Long fee;

    private Long overdraftQuota;

    private String userId;

    private Timestamp payDay;

    private String tenantId;

    private String billItemSeq;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Timestamp getPayDay() {
        return payDay;
    }

    public void setPayDay(Timestamp payDay) {
        this.payDay = payDay;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getBillItemSeq() {
        return billItemSeq;
    }

    public void setBillItemSeq(String billItemSeq) {
        this.billItemSeq = billItemSeq == null ? null : billItemSeq.trim();
    }
}