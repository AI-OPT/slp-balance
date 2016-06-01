package com.ai.slp.balance.api.resquery.param;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 套餐余量查询结果,套内资源详细账本
 *
 * Date: 2015年10月21日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class ResBook implements Serializable {
    /**
     * 账本ID
     */
    private long bookId;

    /**
     * 账本总量
     */
    private double totalAmount;

    /**
     * 账本使用量
     */
    private double usedAmount;

    /**
     * 账本余量
     */
    private double balanceAmount;

    /**
     * 账本转出量
     */
    private double transferAmount;

    /**
     * 账本科目ID
     */
    private long subjectId;

    /**
     * 账本生效时间
     */
    private Timestamp effectTime;

    /**
     * 账本失效时间
     */
    private Timestamp expireTime;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(double usedAmount) {
        this.usedAmount = usedAmount;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }
    
    public Timestamp getEffectTime() {
        return effectTime == null ? null : new Timestamp(effectTime.getTime());
    }

    public void setEffectTime(Timestamp effectTime) {
        this.effectTime = effectTime == null ? null : new Timestamp(effectTime.getTime());
    }

    public Timestamp getExpireTime() {
        return expireTime == null ? null : new Timestamp(expireTime.getTime());
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime == null ? null : new Timestamp(expireTime.getTime());
    }

}
