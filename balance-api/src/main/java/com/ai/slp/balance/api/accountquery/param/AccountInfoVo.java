package com.ai.slp.balance.api.accountquery.param;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 账户VO，包含资金账本和转兑列表 <br>
 * Date: 2015年7月24日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class AccountInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 账户ID
     */
    private long acctId;

    /**
     * 注册方式
     */
    private String regType;

    /**
     * 客户编号
     */
    private String regCustomerId;

    /**
     * 渠道编号
     */
    private String regChnlId;

    /**
     * 注册邮箱
     */
    private String regMail;

    /**
     * 信用额度
     */
    private long credit;

    /**
     * 账户类型
     */
    private String acctType;

    /**
     * 付款方式
     */
    private String payType;

    /**
     * 账户名称
     */
    private String acctName;

    /**
     * 账单邮寄方式
     */
    private String acctMailType;

    /**
     * 账单地址
     */
    private String acctAddr;

    /**
     * 查询密码
     */
    private String loginPassword;

    /**
     * 支付密码是否验证
     */
    private String payCheck;

    /**
     * 支付密码
     */
    private String payPassword;

    /**
     * 临时信用额度
     */
    private long tempCredit;

    /**
     * 临时信用额度有效期
     */
    private Timestamp tempValidTime;

    /**
     * 每天消费总额度
     */
    private long dTotQuota;

    /**
     * 每天消费单笔上限
     */
    private long dSigQuota;

    /**
     * 每天提现/转账上限
     */
    private long dTransQuota;

    /**
     * 账户状态
     */
    private String acctStatus;

    /**
     * 安全问题1
     */
    private String secureQ1;

    /**
     * 安全问题2
     */
    private String secureQ2;

    /**
     * 安全问题3
     */
    private String secureQ3;

    /**
     * 安全答案1
     */
    private String secureA1;

    /**
     * 安全答案2
     */
    private String secureA2;

    /**
     * 安全答案3
     */
    private String secureA3;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public long getAcctId() {
        return acctId;
    }

    public void setAcctId(long acctId) {
        this.acctId = acctId;
    }

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType;
    }

    public String getRegCustomerId() {
        return regCustomerId;
    }

    public void setRegCustomerId(String regCustomerId) {
        this.regCustomerId = regCustomerId;
    }

    public String getRegChnlId() {
        return regChnlId;
    }

    public void setRegChnlId(String regChnlId) {
        this.regChnlId = regChnlId;
    }

    public String getRegMail() {
        return regMail;
    }

    public void setRegMail(String regMail) {
        this.regMail = regMail;
    }

    public long getCredit() {
        return credit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getAcctMailType() {
        return acctMailType;
    }

    public void setAcctMailType(String acctMailType) {
        this.acctMailType = acctMailType;
    }

    public String getAcctAddr() {
        return acctAddr;
    }

    public void setAcctAddr(String acctAddr) {
        this.acctAddr = acctAddr;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getPayCheck() {
        return payCheck;
    }

    public void setPayCheck(String payCheck) {
        this.payCheck = payCheck;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public long getTempCredit() {
        return tempCredit;
    }

    public void setTempCredit(long tempCredit) {
        this.tempCredit = tempCredit;
    }

    public Timestamp getTempValidTime() {
        return tempValidTime == null ? null : new Timestamp(tempValidTime.getTime());
    }

    public void setTempValidTime(Timestamp tempValidTime) {
        this.tempValidTime = tempValidTime == null ? null : new Timestamp(tempValidTime.getTime());
    }

    public long getdTotQuota() {
        return dTotQuota;
    }

    public void setdTotQuota(long dTotQuota) {
        this.dTotQuota = dTotQuota;
    }

    public long getdSigQuota() {
        return dSigQuota;
    }

    public void setdSigQuota(long dSigQuota) {
        this.dSigQuota = dSigQuota;
    }

    public long getdTransQuota() {
        return dTransQuota;
    }

    public void setdTransQuota(long dTransQuota) {
        this.dTransQuota = dTransQuota;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getSecureQ1() {
        return secureQ1;
    }

    public void setSecureQ1(String secureQ1) {
        this.secureQ1 = secureQ1;
    }

    public String getSecureQ2() {
        return secureQ2;
    }

    public void setSecureQ2(String secureQ2) {
        this.secureQ2 = secureQ2;
    }

    public String getSecureQ3() {
        return secureQ3;
    }

    public void setSecureQ3(String secureQ3) {
        this.secureQ3 = secureQ3;
    }

    public String getSecureA1() {
        return secureA1;
    }

    public void setSecureA1(String secureA1) {
        this.secureA1 = secureA1;
    }

    public String getSecureA2() {
        return secureA2;
    }

    public void setSecureA2(String secureA2) {
        this.secureA2 = secureA2;
    }

    public String getSecureA3() {
        return secureA3;
    }

    public void setSecureA3(String secureA3) {
        this.secureA3 = secureA3;
    }

}
