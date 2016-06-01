package com.ai.slp.balance.api.resquery.param;

public class ResUsableDetail {
    /**
     * 资源类型 <br>
     * 10-语音 <br>
     * 50-短信 <br>
     * 60-流量 <br>
     * 99-G币 <br>
     */
    private int resourceType;

    /**
     * 资源科目ID
     */
    private long subjectId;

    /**
     * 可用余量 <br>
     * 流量单位 k<br>
     * 时长单位 分钟 <br>
     * 短信单位 条<br>
     */
    private double balance;

    public int getResourceType() {
        return resourceType;
    }

    public void setResourceType(int resourceType) {
        this.resourceType = resourceType;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
