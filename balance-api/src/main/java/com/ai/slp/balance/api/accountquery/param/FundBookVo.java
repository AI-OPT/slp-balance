package com.ai.slp.balance.api.accountquery.param;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 资金账本VO <br>
 * Date: 2015年7月24日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class FundBookVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 账本ID
     */
    private long bookId;

    /**
     * 资金科目ID
     */
    private long fundSubjectId;

    /**
     * 资金科目名称
     */
    private String fundSubjectName;

    /**
     * 资金特征码
     */
    private String featureCode;

    /**
     * 资金金额
     */
    private long amount;

    /**
     * 生效日期
     */
    private Timestamp effectDate;

    /**
     * 失效日期
     */
    private Timestamp expireDate;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getFundSubjectId() {
        return fundSubjectId;
    }

    public void setFundSubjectId(long fundSubjectId) {
        this.fundSubjectId = fundSubjectId;
    }

    public String getFundSubjectName() {
        return fundSubjectName;
    }

    public void setFundSubjectName(String fundSubjectName) {
        this.fundSubjectName = fundSubjectName;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Timestamp getEffectDate() {
        return effectDate == null ? null : new Timestamp(effectDate.getTime());
    }

    public void setEffectDate(Timestamp effectDate) {
        this.effectDate = effectDate == null ? null : new Timestamp(effectDate.getTime());
    }

    public Timestamp getExpireDate() {
        return expireDate == null ? null : new Timestamp(expireDate.getTime());
    }

    public void setExpireDate(Timestamp expireDate) {
        this.expireDate = expireDate == null ? null : new Timestamp(expireDate.getTime());
    }

}
