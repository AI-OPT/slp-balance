package com.ai.slp.balance.api.resdeposit.param;

import com.ai.opt.base.vo.BaseInfo;

public class ResourceDeposit extends BaseInfo {

    /**
     * 请求系统ID
     */
    private String systemId;
    
    /**
     * 请求流水号
     */
    private String externalId;

    /**
     * 属主类型,必填<br>
     * 0 用户 <br>
     * 1 账户 <br>
     * 2 群组<br>
     */
    private int ownerType;

    /**
     * 属主ID,必填<br>
     * 用户－用户ID<br>
     * 账户－账户ID<br>
     * 群组－群组ID<br>
     */
    private long ownerId;

    /**
     * 资源类型,必填<br>
     * 10 语音 <br>
     * 50 短信 <br>
     * 60 流量 <br>
     * 99 资源币<br>
     */
    private int resourceType;

    /**
     * 资源量，必填 <br>
     * 流量单位 k<br>
     * 时长单位 分钟 <br>
     * 短信单位 条<br>
     */
    private long totalAmount;

    /**
     * 生效时间<br>
     * 格式：yyyy-MM-dd HH:mm:ss <br>
     * 可选，默认[2000-01-01 00:00:00]
     */
    private String effectDate;

    /**
     * 失效时间<br>
     * 格式：yyyy-MM-dd HH:mm:ss <br>
     * 可选，默认[2099-12-31 23:59:59]
     */
    private String expireDate;

    /**
     * 可转增标识,必填<br>
     * 0 不可转增<br>
     * 1 可转增<br>
     */
    private int allowPresent;

    /**
     * 可转兑/买卖标识,必填<br>
     * 0 不可转兑/买卖<br>
     * 1 可转兑/买卖<br>
     */
    private int allowConvert;

    /**
     * 清零标识,必填<br>
     * 0 清零<br>
     * 1 不清零<br>
     */
    private int allowClear;

    /**
     * 入账类型,必填<br>
     * 0 产品订购<br>
     * 1 资源赠送<br>
     */
    private int sourceType;

    /**
     * 入账来源 <br>
     * 产品订购 产品构成元素ID <br>
     * 资源赠送 赠送业务流水号<br>
     */
    private long sourceId;
    
    /**
     * 即买即用标识 <br>
     * 0  非即买即用产品 <br>
     * 1  即买即用产品，可用于抵扣用户已经超额使用的部分 <br>
     */
    private String useFlag;

    public int getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(int ownerType) {
        this.ownerType = ownerType;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public int getResourceType() {
        return resourceType;
    }

    public void setResourceType(int resourceType) {
        this.resourceType = resourceType;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(String effectDate) {
        this.effectDate = effectDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public int getAllowPresent() {
        return allowPresent;
    }

    public void setAllowPresent(int allowPresent) {
        this.allowPresent = allowPresent;
    }

    public int getAllowConvert() {
        return allowConvert;
    }

    public void setAllowConvert(int allowConvert) {
        this.allowConvert = allowConvert;
    }

    public int getAllowClear() {
        return allowClear;
    }

    public void setAllowClear(int allowClear) {
        this.allowClear = allowClear;
    }

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public long getSourceId() {
        return sourceId;
    }

    public void setSourceId(long sourceId) {
        this.sourceId = sourceId;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }
}
