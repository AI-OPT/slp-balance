package com.ai.slp.balance.dao.mapper.bo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class FunResBook {
    private Long bookId;

    private String tenantId;

    private Long ownerId;

    private Integer ownerType;

    private Long subjectId;

    private Integer resourceType;

    private Timestamp createTime;

    private Timestamp effectTime;

    private Timestamp expireTime;

    private BigDecimal totalAmount;

    private BigDecimal deductAmount;

    private BigDecimal presentAmount;

    private BigDecimal exchangeAmount;

    private String bookStatus;

    private Integer allowPresent;

    private Integer allowConvert;

    private Integer allowClear;

    private Integer sourceType;

    private Long sourceId;

    private Long useVersion;

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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(Integer ownerType) {
        this.ownerType = ownerType;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Timestamp effectTime) {
        this.effectTime = effectTime;
    }

    public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDeductAmount() {
        return deductAmount;
    }

    public void setDeductAmount(BigDecimal deductAmount) {
        this.deductAmount = deductAmount;
    }

    public BigDecimal getPresentAmount() {
        return presentAmount;
    }

    public void setPresentAmount(BigDecimal presentAmount) {
        this.presentAmount = presentAmount;
    }

    public BigDecimal getExchangeAmount() {
        return exchangeAmount;
    }

    public void setExchangeAmount(BigDecimal exchangeAmount) {
        this.exchangeAmount = exchangeAmount;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus == null ? null : bookStatus.trim();
    }

    public Integer getAllowPresent() {
        return allowPresent;
    }

    public void setAllowPresent(Integer allowPresent) {
        this.allowPresent = allowPresent;
    }

    public Integer getAllowConvert() {
        return allowConvert;
    }

    public void setAllowConvert(Integer allowConvert) {
        this.allowConvert = allowConvert;
    }

    public Integer getAllowClear() {
        return allowClear;
    }

    public void setAllowClear(Integer allowClear) {
        this.allowClear = allowClear;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getUseVersion() {
        return useVersion;
    }

    public void setUseVersion(Long useVersion) {
        this.useVersion = useVersion;
    }
}