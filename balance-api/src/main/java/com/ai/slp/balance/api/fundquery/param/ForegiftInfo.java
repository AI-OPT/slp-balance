package com.ai.slp.balance.api.fundquery.param;

import java.io.Serializable;

public class ForegiftInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 账户ID
     */
    private long accountId;

    /**
     * 账本ID
     */
    private long fundbookId;

    /**
     * 账本余额
     */
    private long amount;

    /**
     * 科目ID
     */
    private long subjectId;

    /**
     * 专款用户ID (非专款为0)
     */
    private long subsId;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getFundbookId() {
        return fundbookId;
    }

    public void setFundbookId(long fundbookId) {
        this.fundbookId = fundbookId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public long getSubsId() {
        return subsId;
    }

    public void setSubsId(long subsId) {
        this.subsId = subsId;
    }

}
