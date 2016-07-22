package com.ai.slp.balance.service.atom.interfaces;

import java.sql.Timestamp;

import com.ai.opt.base.vo.PageInfo;
import com.ai.slp.balance.dao.mapper.bo.FunAccountLog;

/**
 * 账户信息历史记录表
 * Date: 2015年8月7日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author fanpw
 */
public interface IFunAccountLogAtomSV {

    public void saveFunAccountLog(FunAccountLog log);
    /**
     * 分页查询信用额度设置记录
     * @param tenantId
     * @param accountId
     * @param pageNo
     * @param pageSize
     * @param startTime
     * @param endTime
     * @return
     * @author zhangzd
     * @ApiDocMethod
     * @ApiCode
     */
    public PageInfo<FunAccountLog> queryCreditSettingRecordPageInfo(String tenantId,Long accountId,Integer pageNo,Integer pageSize,Timestamp startTime,Timestamp endTime);
    
}
