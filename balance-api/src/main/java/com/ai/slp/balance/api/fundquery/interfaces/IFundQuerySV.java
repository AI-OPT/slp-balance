package com.ai.slp.balance.api.fundquery.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.fundquery.param.AccountIdParam;
import com.ai.slp.balance.api.fundquery.param.ForegiftInfo;
import com.ai.slp.balance.api.fundquery.param.ForegiftQuery;
import com.ai.slp.balance.api.fundquery.param.FundInfo;
import com.ai.slp.balance.api.fundquery.param.SubjectId;

/**
 * 账户资金查询接口
 * 
 * Date: 2015年8月24日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
@Path("/fundQueryService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IFundQuerySV {
    /**
     * 押金查询.<br>
     * 查询账户下的押金<br>
     * 注：按账户/用户查询押金，用户默认0查询账户下所有押金<br>
     * 
     * @param param
     * @return 押金信息列表，
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0007
     * @RestRelativeURL fundQueryService/queryForegift
     */
	@POST
	@Path("/queryForegift")
    public List<ForegiftInfo> queryForegift(ForegiftQuery param) throws BusinessException,SystemException;

    /**
     * 账户余额查询.<br>
     * 按账户ID查询账户余额：查询账户下的资金账本，含现金、通信现金、赠款等之和，包括可用金额＋冻结金之和。不包括红包，优惠券，押金<br>
     * 
     * @param accountId
     * @return 账户余额和账本信息
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0008
     * @RestRelativeURL fundQueryService/queryFund
     */
	@POST
	@Path("/queryFund")
    public FundInfo queryFund(AccountIdParam accountId) throws BusinessException,SystemException;

    /**
     * 可用余额查询.<br>
     * 按账户ID查询账户可用余额：查询账户下的可用余额，含现金、通信现金、赠款及明细查询。不包括红包，优惠券，押金<br>
     * 
     * @param accountId
     * @return
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0009
     * @RestRelativeURL fundQueryService/queryUsableFund
     */
	@POST
	@Path("/queryUsableFund")
    public FundInfo queryUsableFund(AccountIdParam accountId) throws BusinessException,SystemException;

    /**
     * 冻结余额查询.<br>
     * 按账户ID查询账户冻结资金：查询账户下的锁定余额，例如预存转兑金额及明细。不包括红包，优惠券，押金<br>
     * 
     * @param accountId
     * @return
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0010
     * @RestRelativeURL fundQueryService/queryFrozenFund
     */
	@POST
	@Path("/queryFrozenFund")
    public FundInfo queryFrozenFund(AccountIdParam accountId) throws BusinessException,SystemException;

    /**
     * 销账可用账本明细查询.<br>
     * 查询账户下当前可用的通信现金和赠款的账本明细，并且按照资金科目的使用优先级排序，供计费销账使用。不包括红包，优惠券，押金<br>
     * 
     * @param accountId
     * @return
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0036
     * @RestRelativeURL fundQueryService/queryUsableTeleFund
     */
	@POST
	@Path("/queryUsableTeleFund")
    public FundInfo queryUsableTeleFund(AccountIdParam accountId) throws BusinessException,SystemException;

    /**
     * 按照科目和账户查询资金账本
     * 
     * @param subject
     * @return
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0048
     * @RestRelativeURL fundQueryService/queryFundBySubjectId
     */
	@POST
	@Path("/queryFundBySubjectId")
    public FundInfo queryFundBySubjectId(SubjectId subjectId) throws BusinessException,SystemException;

    /**
     * 按账户ID查询优惠券,未规划
     * 
     * @param accountId
     * @return
     * @throws BusinessException,SystemException
     * @author lilg
     * @RestRelativeURL fundQueryService/queryCoupon
     */
	@POST
	@Path("/queryCoupon")
    public List<String> queryCoupon(AccountIdParam accountId) throws BusinessException,SystemException;
}
