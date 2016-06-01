package com.ai.slp.balance.dao.mapper.bo;

public class FunFundSerialByAcctIdIdx {
    private String tenantId;

    private Long acctId1;

    private String peerSerialCode;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public Long getAcctId1() {
        return acctId1;
    }

    public void setAcctId1(Long acctId1) {
        this.acctId1 = acctId1;
    }

    public String getPeerSerialCode() {
        return peerSerialCode;
    }

    public void setPeerSerialCode(String peerSerialCode) {
        this.peerSerialCode = peerSerialCode == null ? null : peerSerialCode.trim();
    }
}