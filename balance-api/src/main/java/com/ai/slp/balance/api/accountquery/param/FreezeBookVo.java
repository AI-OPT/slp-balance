package com.ai.slp.balance.api.accountquery.param;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 转兑账本VO <br>
 * Date: 2015年7月24日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public class FreezeBookVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 账本ID
     */
    private long freezeBookId;

    /**
     * 预存活动ID
     */
    private long activeId;

    /**
     * 冻结资金科目ID
     */
    private long freezeSubjectId;

    /**
     * 冻结资金科目名称
     */
    private String freezeSubjectName;

    /**
     * 转兑资金科目ID
     */
    private long destSubjectId;

    /**
     * 转兑资金科目名称
     */
    private String destSubjectName;

    /**
     * 计算模式
     */
    private String calMode;

    /**
     * 转兑总额
     */
    private long orginalAmount;

    /**
     * 转兑月数
     */
    private int allotMonth;

    /**
     * 每次转兑金额
     */
    private long thawFee;

    /**
     * 每次转兑比例
     */
    private int thawScale;

    /**
     * 已转兑总额
     */
    private long alreadyAllotAmount;

    /**
     * 已转兑月数
     */
    private int alreadyAllotMonth;

    /**
     * 开始转兑月
     */
    private String startAllotMonth;

    /**
     * 最后转兑月
     */
    private String lastAllotMonth;

    /**
     * 转兑状态
     */
    private String allotStatus;

    /**
     * 最后转兑时间
     */
    private Timestamp lastAllotDate;

    public long getFreezeBookId() {
        return freezeBookId;
    }

    public void setFreezeBookId(long freezeBookId) {
        this.freezeBookId = freezeBookId;
    }

    public long getActiveId() {
        return activeId;
    }

    public void setActiveId(long activeId) {
        this.activeId = activeId;
    }

    public long getFreezeSubjectId() {
        return freezeSubjectId;
    }

    public void setFreezeSubjectId(long freezeSubjectId) {
        this.freezeSubjectId = freezeSubjectId;
    }

    public String getFreezeSubjectName() {
        return freezeSubjectName;
    }

    public void setFreezeSubjectName(String freezeSubjectName) {
        this.freezeSubjectName = freezeSubjectName;
    }

    public long getDestSubjectId() {
        return destSubjectId;
    }

    public void setDestSubjectId(long destSubjectId) {
        this.destSubjectId = destSubjectId;
    }

    public String getDestSubjectName() {
        return destSubjectName;
    }

    public void setDestSubjectName(String destSubjectName) {
        this.destSubjectName = destSubjectName;
    }

    public String getCalMode() {
        return calMode;
    }

    public void setCalMode(String calMode) {
        this.calMode = calMode;
    }

    public long getOrginalAmount() {
        return orginalAmount;
    }

    public void setOrginalAmount(long orginalAmount) {
        this.orginalAmount = orginalAmount;
    }

    public int getAllotMonth() {
        return allotMonth;
    }

    public void setAllotMonth(int allotMonth) {
        this.allotMonth = allotMonth;
    }

    public long getThawFee() {
        return thawFee;
    }

    public void setThawFee(long thawFee) {
        this.thawFee = thawFee;
    }

    public int getThawScale() {
        return thawScale;
    }

    public void setThawScale(int thawScale) {
        this.thawScale = thawScale;
    }

    public long getAlreadyAllotAmount() {
        return alreadyAllotAmount;
    }

    public void setAlreadyAllotAmount(long alreadyAllotAmount) {
        this.alreadyAllotAmount = alreadyAllotAmount;
    }

    public int getAlreadyAllotMonth() {
        return alreadyAllotMonth;
    }

    public void setAlreadyAllotMonth(int alreadyAllotMonth) {
        this.alreadyAllotMonth = alreadyAllotMonth;
    }

    public String getStartAllotMonth() {
        return startAllotMonth;
    }

    public void setStartAllotMonth(String startAllotMonth) {
        this.startAllotMonth = startAllotMonth;
    }

    public String getLastAllotMonth() {
        return lastAllotMonth;
    }

    public void setLastAllotMonth(String lastAllotMonth) {
        this.lastAllotMonth = lastAllotMonth;
    }

    public String getAllotStatus() {
        return allotStatus;
    }

    public void setAllotStatus(String allotStatus) {
        this.allotStatus = allotStatus;
    }

    public Timestamp getLastAllotDate() {
        return lastAllotDate == null ? null : new Timestamp(lastAllotDate.getTime());
    }

    public void setLastAllotDate(Timestamp lastAllotDate) {
        this.lastAllotDate = lastAllotDate == null ? null : new Timestamp(lastAllotDate.getTime());
    }

}
