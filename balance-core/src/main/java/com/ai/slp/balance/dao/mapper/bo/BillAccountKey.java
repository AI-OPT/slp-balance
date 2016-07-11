package com.ai.slp.balance.dao.mapper.bo;

public class BillAccountKey {
    private Long accountId;

    private String billCycleId;

    private String subjectId;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getBillCycleId() {
        return billCycleId;
    }

    public void setBillCycleId(String billCycleId) {
        this.billCycleId = billCycleId == null ? null : billCycleId.trim();
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId == null ? null : subjectId.trim();
    }
}