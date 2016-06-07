package com.ai.slp.balance.service.business.interfaces;

import java.util.List;

import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.balance.api.accountmaintain.param.AccountUpdateParam;
import com.ai.slp.balance.api.accountmaintain.param.RegAccReq;
import com.ai.slp.balance.api.accountquery.param.AccountInfoVo;

public interface IAccountManagerSV {
    
    /**
     * 创建 账户
     * @param regAccReq
     * @return
     * @throws BusinessException
     * @author limy6
     * @ApiDocMethod
     */
    public long createAccount(RegAccReq regAccReq) throws BusinessException;
    
    /**
     * 更新账户设置
     * @param param
     * @throws BusinessException
     * @author fanpw
     * @ApiDocMethod
     */
    public void updateAccount(AccountUpdateParam param) throws BusinessException;
    
    /**
     * 根据账户ID查询账户
     * @param tenantId
     * @param accountId
     * @return
     * @throws BusinessException
     * @author lilg
     * @ApiDocMethod
     */
    public AccountInfoVo queryAccountInfoById(String tenantId, long accountId) throws BusinessException;
    
    /**
     * 根据客户ID查询账户
     * @param tenantId
     * @param accountId
     * @return
     * @throws BusinessException
     * @author lilg
     * @ApiDocMethod
     */
    public List<AccountInfoVo> queryAccountInfoByCustId(String tenantId, String custId) throws BusinessException;

}
