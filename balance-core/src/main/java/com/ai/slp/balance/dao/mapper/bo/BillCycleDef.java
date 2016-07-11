package com.ai.slp.balance.dao.mapper.bo;

public class BillCycleDef {
    private Integer billCycleDefId;

    private String billGenType;

    private Integer postpayUnits;

    private String postpayType;

    private String tenantId;

    public Integer getBillCycleDefId() {
        return billCycleDefId;
    }

    public void setBillCycleDefId(Integer billCycleDefId) {
        this.billCycleDefId = billCycleDefId;
    }

    public String getBillGenType() {
        return billGenType;
    }

    public void setBillGenType(String billGenType) {
        this.billGenType = billGenType == null ? null : billGenType.trim();
    }

    public Integer getPostpayUnits() {
        return postpayUnits;
    }

    public void setPostpayUnits(Integer postpayUnits) {
        this.postpayUnits = postpayUnits;
    }

    public String getPostpayType() {
        return postpayType;
    }

    public void setPostpayType(String postpayType) {
        this.postpayType = postpayType == null ? null : postpayType.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }
}