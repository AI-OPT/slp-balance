package com.ai.slp.balance.api.deduct.interfaces;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.deduct.param.DeductAccount;
import com.ai.slp.balance.api.deduct.param.DeductParam;
import com.ai.slp.balance.api.deduct.param.DeductResponse;
import com.ai.slp.balance.api.deduct.param.ForegiftDeduct;
import com.ai.slp.balance.api.deduct.param.SettleParam;

/**
 * 余额扣减服务 <br>
 *
 * Date: 2015年8月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
@Path("/deductService")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IDeductSV {
    /**
     * 扣款 (扣减).<br>
     * 处理外部平台向余额中心发起的单次扣款或提现的请求，支持扣减账户的现金、赠款、红包、优惠券<br>
     * 
     * @param param
     * @return 交易流水号
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0019
     * @RestRelativeURL deductService/deductFund
     */
	@POST
	@Path("/deductFund")
    public DeductResponse deductFund(DeductParam param) throws BusinessException,SystemException;

    /**
     * 销账扣款 (扣减).<br>
     * 支持计费销账时扣减账户指定账本的金额<br>
     * 注：计费调用<br>
     * 
     * @param param
     * @return 交易流水号
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0037
     * @RestRelativeURL deductService/settleAccount
     */
	@POST
	@Path("/settleAccount")
    public String settleAccount(SettleParam param) throws BusinessException,SystemException;

    /**
     * 押金扣减.<br>
     * 支持退押金时从押金账本扣减<br>
     * 
     * @param param
     * @return 交易流水号
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0006
     * @RestRelativeURL deductService/deductForegift
     */
	@POST
	@Path("/deductForegift")
    public String deductForegift(ForegiftDeduct param) throws BusinessException,SystemException;

    /**
     * 
     * 计费实时扣款(支持部分划扣)
     * 
     * @param param
     * @return 未抵扣的金额
     * @throws BusinessException,SystemException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0047
     * @RestRelativeURL deductService/deductPartFundByAccount
     */
	@POST
	@Path("/deductPartFundByAccount")
    public long deductPartFundByAccount(DeductAccount param) throws BusinessException,SystemException;
}
