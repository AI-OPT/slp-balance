package com.ai.slp.balance.api.fundquery.param;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 余额查询，账本结果对象
 *
 * Date: 2015年10月12日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class FundBook implements Serializable {
    /**
     * 账本ID
     */
    private long bookId;

    /**
     * 资金科目ID
     */
    private long subjectId;

    /**
     * 账本余额
     */
    private long balance;

    /**
     * 生效日期
     */
    private Timestamp effectDate;

    /**
     * 失效日期
     */
    private Timestamp expireDate;

    /**
     * 专款用户ID (非专款为0)
     */
    private long subsId;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
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

    public long getSubsId() {
        return subsId;
    }

    public void setSubsId(long subsId) {
        this.subsId = subsId;
    }
}
