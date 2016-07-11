package com.ai.slp.balance.dao.mapper.bo;

public class BillPayDetailKey {
    private String payLogSeq;

    private String billIteamSeq;

    public String getPayLogSeq() {
        return payLogSeq;
    }

    public void setPayLogSeq(String payLogSeq) {
        this.payLogSeq = payLogSeq == null ? null : payLogSeq.trim();
    }

    public String getBillIteamSeq() {
        return billIteamSeq;
    }

    public void setBillIteamSeq(String billIteamSeq) {
        this.billIteamSeq = billIteamSeq == null ? null : billIteamSeq.trim();
    }
}