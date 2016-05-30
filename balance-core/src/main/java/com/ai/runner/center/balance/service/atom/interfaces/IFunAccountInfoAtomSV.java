package com.ai.runner.center.balance.service.atom.interfaces;

import java.util.List;

import com.ai.runner.center.balance.dao.mapper.bo.FunAccountInfo;
import com.ai.runner.center.balance.dao.mapper.bo.FunAccountInfoByCustIdIdx;
import com.ai.runner.center.balance.dao.mapper.bo.FunAccountInfoByExternalIdIdx;

public interface IFunAccountInfoAtomSV {
    /**
     * 主键查询
     * @param accountId
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public FunAccountInfo getBeanByPrimaryKey(long accountId);
    

    /**
     * CustID索引查询
     * @param custId
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public List<FunAccountInfoByCustIdIdx> getAccountIdByCustId(String tenantId,long custId);
    
    /**
     * 根据主键修改账户信息表
     * @param info
     * @author fanpw
     * @ApiDocMethod
     */
    public void updateFunAccountInfo(FunAccountInfo info);
    
    /**
     * 插入账户信息表
     * @param info
     * @author limy6
     * @ApiDocMethod
     */
    public void insertFunAccountInfo(FunAccountInfo info);
    
    /**
     * 根据 外部流水ID 和 系统ID 查询 索引表
     * 
     * 返回列表
     * 
     * @param externalId
     * @param systemId
     * @return
     * @author limy6
     * @ApiDocMethod
     */
    public List<FunAccountInfoByExternalIdIdx> getBeanByExternalIdSystemId(String externalId,
            String systemId);
    
    /**
     * 向 账户-外部流水ID 索引表插入一条数据
     * FunAccountInfoByExternalIdIdx
     * @param vo
     * @author limy6
     * @ApiDocMethod
     */
    public void insertFunAccountInfoByExternalIdIdx(FunAccountInfoByExternalIdIdx vo);
    
    /**
     * 向 账户-客户ID 索引表插入一条数据
     * FunAccountInfoByCustIdIdx
     * @param vo
     * @author Administrator
     * @ApiDocMethod
     */
    public void insertFunAccountInfoByCustIdIdx(FunAccountInfoByCustIdIdx vo);
    
    /**
     * 给指定账户信息余额增加amount
     * @param account
     * @param amount
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public int addBalance(long account,long amount);
}
