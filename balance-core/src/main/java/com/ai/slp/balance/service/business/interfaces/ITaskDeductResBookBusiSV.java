package com.ai.slp.balance.service.business.interfaces;

import java.util.List;

import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.balance.dao.mapper.bo.FunResOperaDetail;

/**
 * 离线抵扣账本业务逻辑<br>
 *
 * Date: 2015年11月24日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface ITaskDeductResBookBusiSV {
    /**
     * 定时任务离线抵扣账本<br>
     * 根据抵扣记录更新账本表<br>
     * 1.按照账本失效时间排序优先处理 <br>
     * 2.账本总余额不足时，剩余部分记录一条新记录，操作类型2<br>
     * 
     * @param operaDetail
     * @throws BusinessException
     * @author lilg
     */
    public void deductResBook(FunResOperaDetail operaDetail) throws BusinessException;

    /**
     * 
     * 定时任务离线抵扣账本<br>
     * 查询需要更新到账本表的抵扣记录<br>
     * 1.按照“首次抵扣”优先/“时间早”优先而排序，指定提取范围<br>
     * 2.包含首次抵扣记录和已经被离线处理而未完全抵扣的记录(这里需要优化，已经被处理说明账本余额不足，最好不要再立即处理) <br>
     * 
     * @param start
     *            起始序列
     * @param end
     *            结束序列
     * @return
     * @throws BusinessException
     * @author lilg
     */
    public List<FunResOperaDetail> queryWaitDeduct(int start, int end) throws BusinessException;;
}
