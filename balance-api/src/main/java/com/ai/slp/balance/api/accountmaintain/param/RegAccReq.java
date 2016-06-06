package com.ai.slp.balance.api.accountmaintain.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 创建账户 <br>
 * Date: 2015年7月30日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author limy6
 */
public class RegAccReq extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 系统ID，必填
     */
    private String systemId;

    /**
     * 外部流水号，幂等行校验，每次请求的唯一标识，必填
     */
    private String externalId;

    /**
     * 账户名称，必填
     */
    private String acctName;

    /**
     * 注册方式，必填 <br>
     * 1、客户注册<br>
     * 2、渠道注册<br>
     * 3、邮箱注册<br>
     */
    private String regType;

    /**
     * 客户编号 --- 注册方式是客户创建时，必须填写
     */
    private String regCustomerId;

    /**
     * 渠道编号 --- 注册方式是渠道创建时，必须填写
     */
    private String chnlId;

    /**
     * 注册邮箱 --- 注册方式是注册邮箱时，必须填写
     */
    private String regEmail;

    /**
     * 信用额度 --- 信用额度默认填0
     */
    private long credit;

    /**
     * 账户类型 --- 0 后付;﻿1 准预付; 必填
     */
    private String acctType;

    /**
     * 付款方式 --- 1 现金;0 代收;2:银行托收.必填
     */
    private String payType;

    /**
     * 账单邮寄方式 --- 账户内资金对账单，可以默认填0（0无，1、Email，2、邮寄）
     */
    private String acctMailType;

    /**
     * 账单地址
     */
    private String acctAddr;

    /**
     * 查询密码 --- 如果不传，接口默认设置"000000"MD5加密串
     */
    private String loginPassword;

    /**
     * 支付密码是否验证 --- 如果不传，接口默认为0不验证
     */
    private String payCheck;

    /**
     * 支付密码 --- 如果不传，接口默认设置"000000"MD5加密串
     */
    private String payPassword;

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

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
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

    public String getChnlId() {
        return chnlId;
    }

    public void setChnlId(String chnlId) {
        this.chnlId = chnlId;
    }

    public String getRegEmail() {
        return regEmail;
    }

    public void setRegEmail(String regEmail) {
        this.regEmail = regEmail;
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

}
