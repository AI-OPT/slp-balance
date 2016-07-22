package com.ai.slp.balance.service.business.impl;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.custcredit.param.CustCreditDetailRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditDetailResponse;
import com.ai.slp.balance.api.custcredit.param.CustCreditRequest;
import com.ai.slp.balance.api.deposit.param.ForegiftDeposit;
import com.ai.slp.balance.constants.BalancesCostants;
import com.ai.slp.balance.constants.FunAccountLogConstants;
import com.ai.slp.balance.dao.mapper.bo.BillCycleDef;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfo;
import com.ai.slp.balance.dao.mapper.bo.FunAccountLog;
import com.ai.slp.balance.dao.mapper.bo.FunFundBook;
import com.ai.slp.balance.service.atom.interfaces.IBillCycleDefAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IDepositAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountInfoAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountLogAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunFundBookAtomSV;
import com.ai.slp.balance.service.business.interfaces.IFunAccountInfoBusiSV;
import com.ai.slp.balance.vo.DepositVo;
import com.ai.slp.balance.vo.SubjectFundVo;
import com.ai.slp.balance.vo.DepositVo.TransSummaryVo;
@Service
public class FunAccountInfoBusiSVImpl implements IFunAccountInfoBusiSV {
	private static final Logger log = LogManager.getLogger(FunAccountInfoBusiSVImpl.class);
	@Autowired
	private IFunAccountInfoAtomSV funAccountInfoAtomSV;
	@Autowired
	private IFunAccountLogAtomSV funAccountLogAtomSV;
	@Autowired
    private IDepositAtomSV depositAtomSV;
	@Autowired
    private IBillCycleDefAtomSV billCycleDefAtomSV;
	@Autowired
    private IFunFundBookAtomSV funFundBookAtomSV;
	
	/**
	 * 客户信用额度修改
	 */
	@Transactional
	public void updateCredit(CustCreditRequest request) throws BusinessException,SystemException{
		FunAccountInfo funAccountInfo = new FunAccountInfo();
		funAccountInfo.setAccountId(Long.valueOf(request.getAccountId()));
		funAccountInfo.setCredit(request.getCredit());
		//
		FunAccountInfo funAccountInfoDbOld = this.funAccountInfoAtomSV.getBeanByPrimaryKey(Long.valueOf(request.getAccountId()));
		long oldCredit = funAccountInfoDbOld.getCredit();
		//
		this.funAccountInfoAtomSV.updateCredit(funAccountInfo);
		//
		FunAccountInfo funAccountInfoDb = this.funAccountInfoAtomSV.getBeanByPrimaryKey(Long.valueOf(request.getAccountId()));
		//
		FunAccountLog funAccountLog = new FunAccountLog();
		//
		BeanUtils.copyProperties(funAccountLog, funAccountInfoDb);
		funAccountLog.setUpdateTime(DateUtil.getSysDate());
		//
		String str32 = FunAccountLogConstants.str32Zero();
		StringBuffer stringBuffer = new StringBuffer(str32);
		//将第十一位字符替换为1 当前修改信用额度
		stringBuffer.replace(10, 11, "1");
		System.out.println("update_mask:"+stringBuffer.toString());
		//
		funAccountLog.setUpdateMask(stringBuffer.toString());
		funAccountLog.setOldCredit(oldCredit);
		
		this.funAccountLogAtomSV.saveFunAccountLog(funAccountLog);
		
	}
	/**
	 * 信用额度设置
	 */
	@Override
	@Transactional
	public void updateSettingCredit(CustCreditRequest request){
		//通过账单周期类型、还款时限周期数，还款时限周期类型查询账期定义表
		BillCycleDef billCycleDef = this.billCycleDefAtomSV.getBillCycleDef(request.getBillGenType(),request.getPostpayType(),request.getPostpayUnits());
		Integer billCycleDefId = null;
		//
		if(null != billCycleDef){
			billCycleDefId = billCycleDef.getBillCycleDefId();
		}else{
			//bill_cycle_def$bill_cycle_def_id$SEQ;
			billCycleDefId = Integer.valueOf(SeqUtil.getNewId("bill_cycle_def$bill_cycle_def_id$SEQ").toString());
			log.info("输出billCycleDefId："+billCycleDefId);
			BillCycleDef billCycleDefNew = new BillCycleDef();
			//
			billCycleDefNew.setBillCycleDefId(billCycleDefId);
			billCycleDefNew.setBillGenType(request.getBillGenType());
			billCycleDefNew.setPostpayType(request.getPostpayType());
			billCycleDefNew.setPostpayUnits(request.getPostpayUnits());
			billCycleDefNew.setTenantId(request.getTenantId());
			//
			this.billCycleDefAtomSV.insertBillCycleDef(billCycleDefNew);
		}
		//获取原始信用额度
		FunAccountInfo funAccountInfoDbOld = this.funAccountInfoAtomSV.getBeanByPrimaryKey(Long.valueOf(request.getAccountId()));
		long oldCredit = funAccountInfoDbOld.getCredit();
		
		// 1、信用额度设置,修改funaccountInfo表中 信用额度、生效时间、失效时间 字段
		FunAccountInfo funAccountInfo = new FunAccountInfo();
		funAccountInfo.setAccountId(Long.valueOf(request.getAccountId()));
		//
		funAccountInfo.setCredit(request.getCredit());
		funAccountInfo.setCreditActiveTime(request.getCreditActiveTime());
		funAccountInfo.setCreditExpireTime(request.getCreditExpireTime());
		funAccountInfo.setBillCycleDefId(Long.valueOf(billCycleDefId));
		//
		this.funAccountInfoAtomSV.updateFunAccountInfo(funAccountInfo);
		
		//更新日志信息
		toFunAccountLog(oldCredit,Long.valueOf(request.getAccountId()));
		//押金存入
		this.toCashDeposit(request);
		
						
	}
	/**
	 * 押金存入
	 * @param request
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void toCashDeposit(CustCreditRequest request){
		FunFundBook funFundBook = this.funFundBookAtomSV.findFunFundBook(Long.valueOf(request.getAccountId()), request.getTenantId(), "8", Long.valueOf(100001));
		//
		if(null != funFundBook){
			FunFundBook funFundBookUpdate = new FunFundBook();
			//
			funFundBookUpdate.setBookId(funFundBook.getBookId());//主键条件
			//
			funFundBookUpdate.setBalance(request.getCashDeposit());//押金
			funFundBookUpdate.setEffectDate(request.getCreditActiveTime());
			funFundBookUpdate.setExpireDate(request.getCreditExpireTime());
			//
			this.funFundBookAtomSV.updateByPrimaryKeySelective(funFundBookUpdate);
		}else{
			Long bookId = SeqUtil.getNewId("fun_fund_book$book_id");
			
			funFundBook = new FunFundBook();
			//
			funFundBook.setAccountId(Long.valueOf(request.getAccountId()));
			funFundBook.setBalance(request.getCashDeposit());
			funFundBook.setBookId(bookId);
			funFundBook.setBookStatus("1");
			funFundBook.setCreateTime(DateUtil.getSysDate());
			funFundBook.setEffectDate(request.getCreditActiveTime());
			funFundBook.setExpireDate(request.getCreditExpireTime());
			funFundBook.setFeatureCode(null);
			funFundBook.setSubjectId(100001l);
			funFundBook.setSubjectType("8");//8为押金
			funFundBook.setSubsFreezeId(null);
			funFundBook.setSubsId(null);
			funFundBook.setTenantId(request.getTenantId());
			//
			this.funFundBookAtomSV.insertFunFundBook(funFundBook);
			
		}
	}
	/**
	 * 写入日志
	 * @param oldCredit
	 * @param accountId
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void toFunAccountLog(Long oldCredit,Long accountId){
		//
		FunAccountInfo funAccountInfoDb = this.funAccountInfoAtomSV.getBeanByPrimaryKey(accountId);
		//
		FunAccountLog funAccountLog = new FunAccountLog();
		//
		BeanUtils.copyProperties(funAccountLog, funAccountInfoDb);
		funAccountLog.setUpdateTime(DateUtil.getSysDate());
		//
		String str32 = FunAccountLogConstants.str32Zero();
		StringBuffer stringBuffer = new StringBuffer(str32);
		//将第十一位字符替换为1 当前修改信用额度
		stringBuffer.replace(10, 11, "1");
		System.out.println("update_mask:"+stringBuffer.toString());
		//
		funAccountLog.setUpdateMask(stringBuffer.toString());
		funAccountLog.setOldCredit(oldCredit);
		
		this.funAccountLogAtomSV.saveFunAccountLog(funAccountLog);
	}
	/**
	 * 押金存入，此方法不要写事务 ，调用的时候再在相应的方法上事务控制
	 * @param params
	 * @return
	 * @throws BusinessException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	@Deprecated
	public String depositForegift(ForegiftDeposit params) throws BusinessException {
        log.debug("进入押金存入业务服务");
        /* 参数转化 */
        DepositVo depositVo = new DepositVo();
        BeanUtils.copyProperties(depositVo, params);
        TransSummaryVo transSummary = depositVo.createTransSummary();
        BeanUtils.copyProperties(transSummary, params);
        // 1.数据校验
        /* 账户校验 */
        depositAtomSV.validAccountInfo(depositVo.getAccountId(), depositVo.getTenantId());
        /* 幂等性校验 */
        String paySerialCode = depositAtomSV.validIdempotent(depositVo);
        if (!StringUtil.isBlank(paySerialCode)) {
            return paySerialCode;
        }
        /* 校验押金科目 */
        // 押金存入，资金类型只能是押金
        depositVo.addFundType(BalancesCostants.FunSubject.FundType.FOREGIFT);
        Map<Long, SubjectFundVo> subjectList = depositAtomSV.validSubject(depositVo);
        // 2.确定账本
        depositAtomSV.matchFundBook(depositVo, subjectList);
        // 3.记录交易订单
        paySerialCode = depositAtomSV.recordFundSerial(depositVo);
        depositVo.setPaySerialCode(paySerialCode);
        // 4.记录资金流水
        depositAtomSV.recordFundDetail(depositVo);
        // 5.更新账户信息余额
        depositAtomSV.addAccountInfoBalance(depositVo);
        // 6.异步更新索引表，索引建立在交易订单FUN_FUND_SERIAL表的ACCT_ID1字段上
        depositAtomSV.sendAtsAddFunFundSerialByAcctIdIdx(depositVo);
        return paySerialCode;
    }
	/**
	 * 查询授信详情
	 */
	public CustCreditDetailResponse findCustCreditDetail(CustCreditDetailRequest request) throws BusinessException,SystemException{
		//
		CustCreditDetailResponse response = new CustCreditDetailResponse();
		//
		
		//查询押金fun FundBook
		FunFundBook funFundBook = this.funFundBookAtomSV.findFunFundBook(request.getAccountId(), request.getTenantId(), "8", 100001l);
		if(null != funFundBook){
			//押金信息
			response.setCashDeposit(funFundBook.getBalance());
		}
		//查询授信额度
		FunAccountInfo funAccountInfo = this.funAccountInfoAtomSV.getBeanByPrimaryKey(request.getAccountId());
		if(null != funAccountInfo){
			//授信额度
			response.setCredit(funAccountInfo.getCredit());
			response.setCreditActiveTime(funAccountInfo.getCreditActiveTime());
			response.setCreditExpireTime(funAccountInfo.getCreditExpireTime());
			//
			if(null != funAccountInfo.getBillCycleDefId()){
				//查询账期信息
				BillCycleDef billCycleDef = this.billCycleDefAtomSV.getBillCycleDef(Integer.valueOf(funAccountInfo.getBillCycleDefId().toString()));
				//
				if(null != billCycleDef){
					//
					response.setBillGenType(billCycleDef.getBillGenType());
					response.setPostpayType(billCycleDef.getPostpayType());
					response.setPostpayUnits(billCycleDef.getPostpayUnits());
				}
			}
			
		}
		//
		return response;
	}
}
