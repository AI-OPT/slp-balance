package com.ai.slp.balance.dao.mapper.bo;

import java.sql.Timestamp;

public class FunAccountSet {
    private Long accountId;

    private String tenantId;

    private String loginPassword;

    private String payCheck;

    private String payPassword;

    private String secureQ1;

    private String secureQ2;

    private String secureQ3;

    private String secureA1;

    private String secureA2;

    private String secureA3;

    private String regType;

    private String regCustomerId;

    private String regChnlId;

    private String regEmail;

    private Timestamp regTime;

    private String updateOperId;

    private Timestamp updateDate;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getPayCheck() {
        return payCheck;
    }

    public void setPayCheck(String payCheck) {
        this.payCheck = payCheck == null ? null : payCheck.trim();
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }

    public String getSecureQ1() {
        return secureQ1;
    }

    public void setSecureQ1(String secureQ1) {
        this.secureQ1 = secureQ1 == null ? null : secureQ1.trim();
    }

    public String getSecureQ2() {
        return secureQ2;
    }

    public void setSecureQ2(String secureQ2) {
        this.secureQ2 = secureQ2 == null ? null : secureQ2.trim();
    }

    public String getSecureQ3() {
        return secureQ3;
    }

    public void setSecureQ3(String secureQ3) {
        this.secureQ3 = secureQ3 == null ? null : secureQ3.trim();
    }

    public String getSecureA1() {
        return secureA1;
    }

    public void setSecureA1(String secureA1) {
        this.secureA1 = secureA1 == null ? null : secureA1.trim();
    }

    public String getSecureA2() {
        return secureA2;
    }

    public void setSecureA2(String secureA2) {
        this.secureA2 = secureA2 == null ? null : secureA2.trim();
    }

    public String getSecureA3() {
        return secureA3;
    }

    public void setSecureA3(String secureA3) {
        this.secureA3 = secureA3 == null ? null : secureA3.trim();
    }

    public String getRegType() {
        return regType;
    }

    public void setRegType(String regType) {
        this.regType = regType == null ? null : regType.trim();
    }

    public String getRegCustomerId() {
        return regCustomerId;
    }

    public void setRegCustomerId(String regCustomerId) {
        this.regCustomerId = regCustomerId == null ? null : regCustomerId.trim();
    }

    public String getRegChnlId() {
        return regChnlId;
    }

    public void setRegChnlId(String regChnlId) {
        this.regChnlId = regChnlId == null ? null : regChnlId.trim();
    }

    public String getRegEmail() {
        return regEmail;
    }

    public void setRegEmail(String regEmail) {
        this.regEmail = regEmail == null ? null : regEmail.trim();
    }

    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    public String getUpdateOperId() {
        return updateOperId;
    }

    public void setUpdateOperId(String updateOperId) {
        this.updateOperId = updateOperId == null ? null : updateOperId.trim();
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
}