package com.ai.slp.balance.service.atom.interfaces;

import java.util.List;

import com.ai.slp.balance.dao.mapper.bo.FunResOperaDetail;

/**
 * 资源操作明细表 <br>
 *
 * Date: 2015年11月13日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IFunResOperaDetailAtomSV {

    /**
     * 创建资源操作记录
     * 
     * @param funResOperaDetail
     * @author lilg
     */
    public void insert(FunResOperaDetail funResOperaDetail);

    /**
     * 查询，用户幂等性校验
     * 
     * @param tenantId
     * @param systemId
     * @param externalId
     * @return
     * @author lilg
     */
    public FunResOperaDetail getBean(String tenantId, String systemId, String externalId,
            int optType);

    /**
     * 
     * 更新操作记录状态<br>
     * 查询条件中要包含原状态，防止其他线程已更新
     * 
     * @param operaDetail
     *            查询条件
     * @param status
     *            更新状态
     * @return 返回数据库更新记录数
     * @author lilg
     */
    public int updateStatus(FunResOperaDetail operaDetail, String status);

    /**
     * 查询需要更新到账本表的抵扣记录<br>
     * 1.操作类型抵扣/剩余未抵扣 OPT_TYPE IN (1,2) <br>
     * 2.状态待抵扣 STATUS = 1 <br>
     * 3.按照操作类型、时间排序:优先处理首次抵扣类型，优先处理早的 <br>
     * 
     * @param start
     * @param end
     * @return
     * @author lilg
     */
    public List<FunResOperaDetail> getWaitDeduct(int start, int end);

}
