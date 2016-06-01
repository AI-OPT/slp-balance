package com.ai.slp.balance.api.deduct.param;

import java.io.Serializable;

/**
 * 销账交易摘要<br>
 *
 * Date: 2015年8月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class SettleSummary implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账本ID，必填
     */
    private long bookId;

    /**
     * 资金科目ID
     */
    private long subjectId;

    /**
     * 金额，必填
     */
    private long amount;
    
    /**
     * 销账科目ID
     */
    private long feeSubjectId;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public long getFeeSubjectId() {
        return feeSubjectId;
    }

    public void setFeeSubjectId(long feeSubjectId) {
        this.feeSubjectId = feeSubjectId;
    }
}
