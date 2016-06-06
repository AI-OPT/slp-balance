package com.ai.slp.balance.api.deposit.param;

import com.ai.opt.base.vo.BaseInfo;

/**
 * 押金存入请求参数 <br>
 * Date: 2015年8月14日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class ForegiftDeposit extends BaseInfo {

    /**
     * 系统ID，必填
     */
    private String systemId;

    /**
     * 押金科目ID，必填
     */
    private long subjectId;

    /**
     * 账户ID，必填
     */
    private long accountId;

    /**
     * 押金金额，单位：厘，必填
     */
    private long amount;

    /**
     * 生效时间 格式：yyyy-MM-dd HH:mm:ss </br> 可选，默认[存入时间]
     */
    private String fundeffDate;

    /**
     * 失效时间 </br> 格式：yyyy-MM-dd HH:mm:ss </br> 可选，默认[2099-12-31 23:59:59]
     */
    private String fundexpDate;

    /**
     * 业务订单流水号，必填
     */
    private String busiSerialNo;
    
    /**
     * 专款用户ID，默认0非专款，可选
     */
    private long subsId;

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

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getBusiSerialNo() {
        return busiSerialNo;
    }

    public void setBusiSerialNo(String busiSerialNo) {
        this.busiSerialNo = busiSerialNo;
    }

    public String getBusiDesc() {
        return busiDesc;
    }

    public void setBusiDesc(String busiDesc) {
        this.busiDesc = busiDesc;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getFundeffDate() {
        return fundeffDate;
    }

    public void setFundeffDate(String fundeffDate) {
        this.fundeffDate = fundeffDate;
    }

    public String getFundexpDate() {
        return fundexpDate;
    }

    public void setFundexpDate(String fundexpDate) {
        this.fundexpDate = fundexpDate;
    }

    public long getSubsId() {
        return subsId;
    }

    public void setSubsId(long subsId) {
        this.subsId = subsId;
    }

}
