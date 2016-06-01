package com.ai.slp.balance.service.atom.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ai.slp.balance.dao.mapper.bo.FunFundBook;
import com.ai.slp.balance.vo.DepositVo;
import com.ai.slp.balance.vo.SubjectFundVo;

@Component
public interface IDepositAtomSV {
    
    /**
     * 账户校验
     * @param accountId
     * @param tenantId
     * @author lilg
     * @ApiDocMethod
     * @ApiCode
     */
    public void validAccountInfo(long accountId,String tenantId);

    /**
     * 科目校验 <br>
     * 入参，存款对象DepositVo <br>
     * 出参，Subject的JSON对象<br>
     * 
     * @param subjectIds
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public Map<Long, SubjectFundVo> validSubject(DepositVo vo);

    /**
     * 账本确认，计算交易总额，账本更新 入参，存款对象DepositVo，所用科目Map
     * 
     * @param vo
     * @param subjectMap
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public List<FunFundBook> matchFundBook(DepositVo vo, Map<Long, SubjectFundVo> subjectMap);

    /**
     * 幂等性校验，幂等返回存款流水号，否则返回null
     * 
     * @param vo
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public String validIdempotent(DepositVo vo);

    /**
     * 记录交易订单表 <br>
     * 返回交易流水号
     * 
     * @param vo
     * @author lilg
     * @ApiDocMethod
     */
    public String recordFundSerial(DepositVo vo);

    /**
     * 记录资金异动 <br>
     * 返回交易流水号
     * 
     * @param vo
     * @author lilg
     * @ApiDocMethod
     */
    public String recordFundDetail(DepositVo vo);

    /**
     * 更新账户信息，增加账户余额
     * 
     * @param vo
     * @author lilg
     * @ApiDocMethod
     */
    public void addAccountInfoBalance(DepositVo vo);

    /**
     * 异步增加索引
     * 
     * @param vo
     * @author lilg
     * @ApiDocMethod
     */
    public void sendAtsAddFunFundSerialByAcctIdIdx(DepositVo vo);
}
