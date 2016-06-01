package com.ai.slp.balance.api.deduct.param;

import java.io.Serializable;

/**
 * 普通扣款交易摘要<br>
 *
 * Date: 2015年8月31日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * @author lilg
 */
public class TransSummary implements Serializable{
    
    private static final long serialVersionUID = 1L;

    /**
     * 资金科目，必填，限定从某类科目上扣款
     */
    private long subjectId;

    /**
     * 账本ID，可空，限定从某账本上扣款
     */
    private long bookId;

    /**
     * 金额，必填，指明扣款金额
     */
    private long amount;

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

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
