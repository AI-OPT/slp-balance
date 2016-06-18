package com.ai.slp.balance.service.atom.interfaces;

import java.util.List;
import java.util.Map;

import com.ai.slp.balance.dao.mapper.bo.FunFundBook;
import com.ai.slp.balance.vo.DeductVo;
import com.ai.slp.balance.vo.SubjectFundVo;

/**
 * 扣款原子服务
 *
 * Date: 2015年8月27日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IDeductAtomSV {
    
    /**
     * 账户校验
     * @param accountId
     * @param tenantId
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    public void validAccountInfo(long accountId,String tenantId,int checkPwd,String password);

    /**
     * 幂等性校验，幂等返回存款流水号，否则返回null
     * 
     * @param vo
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public String validIdempotent(DeductVo vo);

    /**
     * 科目校验
     * 
     * @param vo
     * @return
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    public Map<Long, SubjectFundVo> validSubject(DeductVo vo);
    
    /**
     * 账本校验
     * @param account
     * @param tenantId
     * @param bookId
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    public void validFundBook(long account,String tenantId,long bookId);

    /**
     * 单账本扣款
     * 
     * @param vo
     * @param fundBookMap
     * @return 
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    public void deductFundBook(long account,long bookId,long amount) ;
    
    /**
     * 多账本扣款
     * @param vo
     * @return Map<FunFundBook,amount> 每个账本扣减金额
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    public Map<FunFundBook,Long> deductFundBook(String tenantId,long accountId,List<FunFundBook> bookList,long totalAmount);

    /**
     * 记录交易订单表 <br>
     * 返回交易流水号
     * 
     * @param vo
     * @author lilg
     * @ApiDocMethod
     */
    public String recordFundSerial(DeductVo vo);

    /**
     * 记录资金异动 <br>
     * 返回交易流水号
     * 
     * @param vo
     * @author lilg
     * @ApiDocMethod
     */
    public String recordFundDetail(DeductVo vo);

    /**
     * 更新账户信息，增加账户余额
     * 
     * @param vo
     * @author lilg
     * @ApiDocMethod
     */
    public void addAccountInfoBalance(DeductVo vo);

    /**
     * 异步增加索引
     * 
     * @param vo
     * @author lilg
     * @ApiDocMethod
     */
    public void sendAtsAddFunFundSerialByAcctIdIdx(DeductVo vo);
}
