package com.ai.runner.center.balance.api.deposit.interfaces;

import com.ai.runner.base.exception.CallerException;
import com.ai.runner.center.balance.api.deposit.param.ForegiftDeposit;
import com.ai.runner.center.balance.api.deposit.param.DepositParam;

/**
 * 余额存入接口 <br>
 *
 * Date: 2015年8月24日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IDepositSV {

    /**
     * 存款 (存入).<br>
     * 处理外部平台向余额中心发起的存款的请求，支持存入现金、赠款等<br>
     * 
     * @param param
     * @return 交易流水号
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0016
     */
    public String depositFund(DepositParam param) throws CallerException;

    /**
     * 押金存入.<br>
     * 支持交押金\保证金时将押金存入账户的押金账本<br>
     * 
     * @param param
     * @return 交易流水号
     * @throws CallerException
     * @author lilg
     * @ApiDocMethod
     * @ApiCode ABM_0005
     */
    public String depositForegift(ForegiftDeposit param) throws CallerException;
}
