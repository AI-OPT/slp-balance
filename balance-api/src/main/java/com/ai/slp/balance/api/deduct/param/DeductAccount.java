package com.ai.slp.balance.api.deduct.param;

import com.ai.opt.base.vo.BaseInfo;

public class DeductAccount extends BaseInfo {
    /**
     * 系统ID，必填
     */
    private String systemId;

    /**
     * 外部单号，必填
     */
    private String externalId;

    /**
     * 业务操作类型，必填
     */
    private String businessCode;

    /**
     * 账户ID，必填
     */
    private long accountId;
    /**
     * 是否校验支付密码
     */
    private int checkPwd;
    /**
     * 支付密码
     */
    private String password;
    /**
     * 扣款总金额，必填
     */
    private long totalAmount;

    /**
     * 专款用户ID，默认0非专款，可选 <br>
     * 1.指定用户ID－本次扣款只从专款中扣减 <br>
     * 2.未指定－本次扣款只从非专款中扣减 <br>
     */
    private long subsId;

    public int getCheckPwd() {
        return checkPwd;
    }

    public void setCheckPwd(int checkPwd) {
        this.checkPwd = checkPwd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getSubsId() {
        return subsId;
    }

    public void setSubsId(long subsId) {
        this.subsId = subsId;
    }
}
