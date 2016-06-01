package com.ai.slp.balance.api.deposit.param;

import java.io.Serializable;

/**
 * 存款交易摘要 <br>
 *
 * Date: 2015年8月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class TransSummary implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 科目ID，必填
     */
    private long subjectId;

    /**
     * 金额，单位(厘)，必填
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
     * 特征码，可选
     */
    private String featureCode;

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

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }
}
