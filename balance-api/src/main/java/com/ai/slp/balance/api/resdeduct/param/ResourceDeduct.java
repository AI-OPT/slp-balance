package com.ai.slp.balance.api.resdeduct.param;

import com.ai.opt.base.vo.BaseInfo;

public class ResourceDeduct extends BaseInfo {

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
}
