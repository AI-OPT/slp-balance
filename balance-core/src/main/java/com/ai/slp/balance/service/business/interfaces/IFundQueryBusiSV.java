package com.ai.slp.balance.service.business.interfaces;

import java.util.List;

import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.balance.api.fundquery.param.AccountIdParam;
import com.ai.slp.balance.api.fundquery.param.ForegiftInfo;
import com.ai.slp.balance.api.fundquery.param.ForegiftQuery;
import com.ai.slp.balance.api.fundquery.param.FundInfo;
import com.ai.slp.balance.api.fundquery.param.SubjectId;

public interface IFundQueryBusiSV {
    /**
     * 按账号ID查询押金
     * @param accountId
     * @return 押金账本列表
     * @throws BusinessException
     * @author lilg
     */
    public List<ForegiftInfo> queryForegift(ForegiftQuery param) throws BusinessException;
    
    
    /**
     * 按账户ID查询账户余额
     * 
     * @param accountId
     * @return 账户余额和账本信息
     * @throws BusinessException
     * @author lilg
     */
    public FundInfo queryFund(AccountIdParam accountId) throws BusinessException;

    /**
     * 按账户ID查询账户可用余额
     * 
     * @param accountId
     * @return
     * @throws BusinessException
     * @author lilg
     */
    public FundInfo queryUsableFund(AccountIdParam accountId) throws BusinessException;

    /**
     * 按账户ID查询账户冻结资金
     * 
     * @param accountId
     * @return
     * @throws BusinessException
     * @author lilg
     */
    public FundInfo queryFrozenFund(AccountIdParam accountId) throws BusinessException;
    
    /**
     * 按账户ID查询销账可用账本信息
     * @param accountId
     * @return
     * @throws BusinessException
     * @author lilg
     */
    public FundInfo queryUsableTeleFund(AccountIdParam accountId) throws BusinessException;
    
    /**
     * 按照账户ID和科目ID查询账本信息
     * @param subjectId
     * @return
     * @throws BusinessException
     * @author lilg
     */
    public FundInfo queryFund(SubjectId subjectId) throws BusinessException;
}
