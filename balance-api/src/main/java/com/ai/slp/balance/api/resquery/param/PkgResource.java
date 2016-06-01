package com.ai.slp.balance.api.resquery.param;

import java.io.Serializable;
import java.util.List;

/**
 * 套餐余量查询结果,套内资源信息
 *
 * Date: 2015年10月21日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class PkgResource implements Serializable {

    /**
     * 资源类型 <br>
     * 10-语音 <br>
     * 50-短信 <br>
     * 60-流量 <br>
     * 99-G币 <br>
     */
    private int resourceType;

    /**
     * 资源总量
     */
    private double totalAmount;

    /**
     * 已使用量
     */
    private double usedAmount;

    /**
     * 剩余量
     */
    private double balanceAmount;

    /**
     * 转出资源量
     */
    private double transferAmount;

    /**
     * 资源计量单位
     */
    private String unitName;

    /**
     * 资源账本分布
     */
    private List<ResBook> resBookList;

    public int getResourceType() {
        return resourceType;
    }

    public void setResourceType(int resourceType) {
        this.resourceType = resourceType;
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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public List<ResBook> getResBookList() {
        return resBookList;
    }

    public void setResBookList(List<ResBook> resBookList) {
        this.resBookList = resBookList;
    }

}
