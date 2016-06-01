package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;

public class FunFundBook {
    private Long bookId;

    private String tenantId;

    private Long accountId;

    private String subjectType;

    private Long subjectId;

    private Long balance;

    private String featureCode;

    private String bookStatus;

    private Timestamp effectDate;

    private Timestamp expireDate;

    private Timestamp createTime;

    private Long subsFreezeId;

    private Long subsId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

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

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType == null ? null : subjectType.trim();
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode == null ? null : featureCode.trim();
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus == null ? null : bookStatus.trim();
    }

    public Timestamp getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Timestamp effectDate) {
        this.effectDate = effectDate;
    }

    public Timestamp getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Timestamp expireDate) {
        this.expireDate = expireDate;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Long getSubsFreezeId() {
        return subsFreezeId;
    }

    public void setSubsFreezeId(Long subsFreezeId) {
        this.subsFreezeId = subsFreezeId;
    }

    public Long getSubsId() {
        return subsId;
    }

    public void setSubsId(Long subsId) {
        this.subsId = subsId;
    }
}