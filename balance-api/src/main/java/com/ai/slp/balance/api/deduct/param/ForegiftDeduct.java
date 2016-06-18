package com.ai.slp.balance.api.deduct.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 押金扣减请求参数
 *
 * Date: 2015年9月10日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class ForegiftDeduct extends BaseInfo {
    /**
     * 系统ID，必填
     */
    private String systemId;

    /**
     * 押金科目ID，必填
     */
    private long subjectId;

    /**
     * 押金账本ID，必填
     */
    private long bookId;

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
     * 押金金额，单位：厘，必填
     */
    private long amount;

    /**
     * 外部单号，必填
     */
    private String externalId;

    /**
     * 业务描述
     */
    private String busiDesc;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getBusiDesc() {
        return busiDesc;
    }

    public void setBusiDesc(String busiDesc) {
        this.busiDesc = busiDesc;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

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

}
