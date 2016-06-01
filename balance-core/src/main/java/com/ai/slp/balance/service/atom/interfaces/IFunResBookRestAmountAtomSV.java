package com.ai.slp.balance.service.atom.interfaces;

import java.math.BigDecimal;

import com.ai.slp.balance.dao.mapper.bo.FunResBookRestAmount;

/**
 * 资源总量原子服务 <br>
 *
 * Date: 2015年11月13日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IFunResBookRestAmountAtomSV {

    /**
     * 创建资源总量记录
     * 
     * @param funResBookRestAmount
     * @author lilg
     */
    public void insert(FunResBookRestAmount funResBookRestAmount);

    /**
     * 根据资源类型获取资源总量 <br>
     * 
     * @param tenantId
     * @param ownerId
     * @param ownerType
     * @param resourceType
     * @return 资源总量对象
     * @author lilg
     */
    public FunResBookRestAmount getBean(String tenantId, long ownerId, int ownerType,
            int resourceType);

    /**
     * 根据资源类型获取资源总量
     * 
     * @param tenantId
     * @param ownerId
     * @param ownerType
     * @param resourceType
     * @return 资源总量值
     * @author lilg
     */
    public BigDecimal getAmount(String tenantId, long ownerId, int ownerType, int resourceType);

    /**
     * 资源量偏移<br>
     * 增加：offset正数 <br>
     * 减少：offset负数 <br>
     * 
     * @param tenantId
     * @param ownerId
     * @param ownerType
     * @param resourceType
     * @param offset
     * @return 数据库更改行数
     * @author lilg
     */
    public int offsetAmount(String tenantId, long ownerId, int ownerType, int resourceType,
            BigDecimal offset);
}
