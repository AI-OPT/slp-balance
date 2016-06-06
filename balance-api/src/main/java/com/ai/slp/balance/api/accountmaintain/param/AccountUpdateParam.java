package com.ai.slp.balance.api.accountmaintain.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 账户设置入参.<br>
 * Date: 2015年7月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author fanpw
 */
public class AccountUpdateParam extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 账户ID（必填项）
     */
    private long acctId;

    /**
     * 操作员ID
     */
    private String operId;

    /**
     * 账户名称
     */
    private String acctName;

    /**
     * 账单邮寄方式:<br>
     * 0 不寄送<br>
     * 1 Email<br>
     * 2 邮寄<br> 
     */
    private Integer acctMailType;

    /**
     * 账单地址
     */
    private String acctAddr;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 信用额度
     */
    private Long credit;

    /**
     * 临时信用额度,单位厘
     */
    private Long tempCredit;

    /**
     * 临时信用额度有效期,格式yyyymmdd
     */
    private String tempValidTime;

    /**
     * 每天消费总额度,单位厘
     */
    private Long dTotQuota;

    /**
     * 每天消费单笔上限,单位厘
     */
    private Long dSigQuota;

    /**
     * 每天提现/转账上限,单位厘
     */
    private Long dTransQuota;

    /**
     * 账户状态:<br>
     * 0：无效<br>
     * 1：有效<br>
     * 2：冻结<br> 
     */
    private Integer acctStatus;

    /**
     * 查询密码
     */
    private String loginPassword;

    /**
     * 支付密码是否验证:<br>
     * 0：不验证<br>
     * 1：验证<br> 
     */
    private Integer payCheck;

    /**
     * 支付密码
     */
    private String payPassword;

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

    public long getAcctId() {
        return acctId;
    }

    public void setAcctId(long acctId) {
        this.acctId = acctId;
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public Integer getAcctMailType() {
        return acctMailType;
    }

    public void setAcctMailType(Integer acctMailType) {
        this.acctMailType = acctMailType;
    }

    public String getAcctAddr() {
        return acctAddr;
    }

    public void setAcctAddr(String acctAddr) {
        this.acctAddr = acctAddr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    public Long getTempCredit() {
        return tempCredit;
    }

    public void setTempCredit(Long tempCredit) {
        this.tempCredit = tempCredit;
    }

    public String getTempValidTime() {
        return tempValidTime;
    }

    public void setTempValidTime(String tempValidTime) {
        this.tempValidTime = tempValidTime;
    }

    public Long getdTotQuota() {
        return dTotQuota;
    }

    public void setdTotQuota(Long dTotQuota) {
        this.dTotQuota = dTotQuota;
    }

    public Long getdSigQuota() {
        return dSigQuota;
    }

    public void setdSigQuota(Long dSigQuota) {
        this.dSigQuota = dSigQuota;
    }

    public Long getdTransQuota() {
        return dTransQuota;
    }

    public void setdTransQuota(Long dTransQuota) {
        this.dTransQuota = dTransQuota;
    }

    public Integer getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(Integer acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public Integer getPayCheck() {
        return payCheck;
    }

    public void setPayCheck(Integer payCheck) {
        this.payCheck = payCheck;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
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
