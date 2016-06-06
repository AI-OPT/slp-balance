package com.ai.slp.balance.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.balance.api.deduct.param.DeductAccount;
import com.ai.slp.balance.api.deduct.param.DeductParam;
import com.ai.slp.balance.api.deduct.param.ForegiftDeduct;
import com.ai.slp.balance.api.deduct.param.SettleParam;

/**
 * 扣款业务层<br>
 *
 * Date: 2015年8月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IDeductBusiSV {

    /**
     * 单次扣款
     * 
     * @param param
     * @return
     * @throws BusinessException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    public String deductFund(DeductParam param) throws BusinessException;

    /**
     * 销账扣款
     * 
     * @param param
     * @return
     * @throws BusinessException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    public String settleAccount(SettleParam param) throws BusinessException;

    /**
     * 押金扣减
     * 
     * @param param
     * @return
     * @throws BusinessException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    public String deductForegift(ForegiftDeduct param) throws BusinessException;

    /**
     * 按照账户ID扣减，支持部分扣减
     * 
     * @param param
     * @return
     * @throws BusinessException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    public long deductPartFundByAccount(DeductAccount param) throws BusinessException;
}
