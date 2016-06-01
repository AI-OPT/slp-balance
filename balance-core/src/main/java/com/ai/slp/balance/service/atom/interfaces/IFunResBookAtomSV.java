package com.ai.slp.balance.service.atom.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.ai.slp.balance.dao.mapper.bo.FunResBook;

/**
 * 资源账本原子服务 <br>
 *
 * Date: 2015年11月13日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IFunResBookAtomSV {

    /**
     * 创建账本
     * 
     * @param funResBook
     * @author lilg
     */
    public void insert(FunResBook funResBook);

    /**
     * 套餐账本查询
     * 
     * @param tenantId
     * @param ownerId
     * @param ownerType
     * @return 账本列表
     * @author lilg
     */
    public List<FunResBook> getResPgkBook(String tenantId, long ownerId, int ownerType);

    /**
     * 根据资源类型获取有效账本
     * 
     * @param tenantId
     * @param ownerId
     * @param ownerType
     * @param resourceType
     * @return 账本列表
     * @author lilg
     */
    public List<FunResBook> getValidResBookByResourceType(String tenantId, long ownerId,
            int ownerType, int resourceType);

    /**
     * 根据账本ID获取有效账本
     * 
     * @param bookId
     * @return
     * @author lilg
     */
    public FunResBook getValidResBookByBookId(long bookId);

    /**
     * 更新账本状态(加版本号处理)
     * 
     * @param bookId
     * @param status
     * @param useVersion
     * @return 修改行数
     * @author lilg
     */
    public int updateResBookStatus(long bookId, String status, long useVersion);

    /**
     * 激活已冻结不清零账本<br>
     * 入参为新生效的不清零账本，按照该账本去激活其他不清零账本
     * 定时任务<b>账本维护</b>在激活待生效的不清零账本时使用
     * @param template 
     * @return 已激活的总额
     * @author lilg
     */
    public BigDecimal activateNoclearBook(FunResBook template);

    /**
     * 
     * 根据账本ID更新账本抵扣额和状态<br>
     * 用于<b>离线抵扣</b>定时任务
     * 
     * @param bookId
     * @param deduct
     * @param status
     *            账本状态，传空或NULL则不更改状态
     * @param useVersion
     * @return
     * @author lilg
     */
    public int deductResBook(long bookId, BigDecimal deduct, String status, long useVersion);

    /**
     * 获取：<br>
     * 1.失效的有效账本<br>
     * 2.生效的待激活账本<br>
     * 指定返回记录数,用于<b>账本维护</b>定时任务
     * 
     * @param start
     * @param end
     * @return
     * @author lilg
     */
    public List<FunResBook> getTimeoutResBook(int start, int end);

}
