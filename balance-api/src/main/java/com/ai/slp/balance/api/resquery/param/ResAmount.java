package com.ai.slp.balance.api.resquery.param;

import java.io.Serializable;

public class ResAmount implements Serializable{
    
    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 套餐属主ID,必填
     */
    private long ownerId;

    /**
     * 属主类型,必填 <br>
     * 0 － 用户 <br>
     * 1 － 账户 <br>
     */
    private int ownerType;
    
    /**
     * 资源类型 <br>
     * 10-语音 <br>
     * 50-短信 <br>
     * 60-流量 <br>
     * 99-G币 <br>
     */
    private int resourceType;
    
    /**
     * 资源总量
     */
    private double totalAmount;

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public int getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(int ownerType) {
        this.ownerType = ownerType;
    }

    public int getResourceType() {
        return resourceType;
    }

    public void setResourceType(int resourceType) {
        this.resourceType = resourceType;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

}
