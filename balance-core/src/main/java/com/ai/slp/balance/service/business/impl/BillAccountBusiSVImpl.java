package com.ai.slp.balance.service.business.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.ordertobillaccount.param.BillGenRequest;
import com.ai.slp.balance.api.ordertobillaccount.param.BillGenRollBackRequest;
import com.ai.slp.balance.dao.mapper.bo.BillAccount;
import com.ai.slp.balance.dao.mapper.bo.BillAccountKey;
import com.ai.slp.balance.dao.mapper.bo.BillCycleDef;
import com.ai.slp.balance.dao.mapper.bo.BillOrder2fee;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfo;
import com.ai.slp.balance.service.atom.interfaces.IBillAccountAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IBillCycleDefAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IBillOrder2feeAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountInfoAtomSV;
import com.ai.slp.balance.service.business.interfaces.IBillAccountBusiSV;
import com.ai.slp.balance.util.BillCycleUtil;
import com.esotericsoftware.minlog.Log;
@Service
public class BillAccountBusiSVImpl implements IBillAccountBusiSV {
	private static final Logger log = LogManager.getLogger(BillAccountBusiSVImpl.class);
	
	@Autowired
	private IBillAccountAtomSV billAccountAtomSV;
	
	@Autowired
	private IBillCycleDefAtomSV billCycleDefAtomSV;
	
	@Autowired
	private IBillOrder2feeAtomSV billOrder2feeAtomSV;
	
	@Autowired
	private IFunAccountInfoAtomSV funAccountInfoAtomSV;
	
	@Override
	@Transactional
	public void updateOrderToBillAccount(BillGenRequest request) throws BusinessException, SystemException {
		//判断当前用户授信时间是否失效
		validateCreditActiveTimeAndCreditExpireTime(request);
		//验证账户逾期是否欠费
		validateArrearage(request);
		
		//账户信用额度校验 是否超限
		validateOverdraftQuota(request);
		
		BillAccount billAccount = new BillAccount();
		//
		 Long fee = request.getFee();
		 Long overdraftQuota = request.getOverdraftQuota();
		 String userId = request.getUserId();
		 Timestamp payDay;
		 String tenantId = request.getTenantId();
		 String billItemSeq =String.valueOf(SeqUtil.getNewId("bill_account$bill_item_seq$SEQ")) ;
		 Long accountId = Long.valueOf(request.getAccountId());
		 
		 //查询账期id
		 FunAccountInfo funAccountInfo = this.funAccountInfoAtomSV.getBeanByPrimaryKey(accountId);
		 String billCycleId = "";
		 
		 BillCycleDef billCycleDef = new BillCycleDef();
		 if(null != funAccountInfo){
			 //
			 if(!StringUtils.isEmpty(funAccountInfo.getBillCycleDefId())){
				 billCycleDef = this.billCycleDefAtomSV.getBillCycleDef(Integer.valueOf(funAccountInfo.getBillCycleDefId().toString())); 
			 }else{
				 throw new BusinessException("", "fun_account_info未配置账期信息"); 
			 }
		 }else {
			 throw new BusinessException("", "fun_account_info 信息表为空");
		 }
		 String billGenType = billCycleDef.getBillGenType();
		 Integer amount = billCycleDef.getPostpayUnits();
		 //
		 if(!StringUtil.isBlank(billGenType)){
			 Map<String,Object> billCycleMap = new HashMap<String,Object>();
			 //
			 billCycleMap = BillCycleUtil.getBillCycleIdAndPayDate(billGenType, amount);
			 billCycleId = billCycleMap.get(BillCycleUtil.BILL_CYCLE_ID).toString();
			 billAccount.setPayDay(Timestamp.valueOf(billCycleMap.get(BillCycleUtil.PAY_DATE_NEW).toString()));
		 }
		 //根据商品类目id查询科目id
		 BillOrder2fee billOrder2fee = this.billOrder2feeAtomSV.getBillOrder2fee(request.getProductCatId());
		 
		 String subjectId = "1";
		 if(null != billOrder2fee){
			if(!StringUtil.isBlank(billOrder2fee.getSubjectId())){
				subjectId = billOrder2fee.getSubjectId();
			}
		 }
		 //判断根据主键查询 信息是否存在
		 BillAccountKey billAccountKey = new BillAccountKey();
		 billAccountKey.setAccountId(accountId);
		 billAccountKey.setBillCycleId(billCycleId);
		 billAccountKey.setSubjectId(subjectId);
		 //
		 BillAccount billAccountPrimaryKey = this.billAccountAtomSV.getBillAccount(billAccountKey);
		 //如果存在
		 if(null != billAccountPrimaryKey){
			 billAccount.setFee(fee+billAccountPrimaryKey.getFee());
			 billAccount.setOverdraftQuota(overdraftQuota+billAccountPrimaryKey.getOverdraftQuota());
			 billAccount.setUserId(userId);
			 billAccount.setTenantId(tenantId);
			 billAccount.setAccountId(accountId);
			 billAccount.setSubjectId(subjectId);
			 billAccount.setBillCycleId(billCycleId);
			 
			 //修改信息
			 this.billAccountAtomSV.updateBillAccountByPrimaryKeySelective(billAccount);
		 }else{
		 //不存在
			 billAccount.setFee(fee);
			 billAccount.setOverdraftQuota(overdraftQuota);
			 billAccount.setUserId(userId);
			 billAccount.setTenantId(tenantId);
			 billAccount.setAccountId(accountId);
			 billAccount.setSubjectId(subjectId);
			 billAccount.setBillItemSeq(billItemSeq);
			 billAccount.setBillCycleId(billCycleId);
			 //
			 this.billAccountAtomSV.insert(billAccount);
		 }
		 
	}
	/**
	 * 验证账户透支金额是否超限
	 * @param request
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void validateOverdraftQuota(BillGenRequest request){
		//订单消费额度
		Long fee = request.getFee();
		//
		FunAccountInfo funAccountInfo = this.funAccountInfoAtomSV.getBeanByPrimaryKey(Long.valueOf(request.getAccountId()));
		//查询当前账户的信用额度
		Long credit = 0l;
		if(null != funAccountInfo){
			credit = funAccountInfo.getCredit();
		}
		//查询当前账户的总透支额
		List<BillAccount> billAccountList = this.billAccountAtomSV.queryBillAccountOverdraftQuotaGreaterThanZero(request.getTenantId(), request.getAccountId());
		Long overdraftQuotaTotal = 0l;
		if(!CollectionUtil.isEmpty(billAccountList)){
			for(BillAccount billAccount : billAccountList){
				overdraftQuotaTotal += billAccount.getOverdraftQuota();
			}
		}
		//如果消费额 小于或等于 总信用额度减去账户总透支额 就返回 000002账户信用度不足
		if(fee >= (credit - overdraftQuotaTotal)){
			throw new BusinessException("000002","账户信用度不足");
		}
		
	}
	/**
	 * 验证账户逾期是否欠费
	 * @param request
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void validateArrearage(BillGenRequest request){
		List<BillAccount> billAccountList = this.billAccountAtomSV.queryBillAccountOverdraftQuotaGreaterThanZero(request.getTenantId(), request.getAccountId());
		if(!CollectionUtil.isEmpty(billAccountList)){
			for(BillAccount billAccount : billAccountList){
				//
				String timeStr = DateUtil.getDateString(billAccount.getPayDay(), BillCycleUtil.DATE_FORMAT );
		    	Timestamp payDay = DateUtil.getTimestamp(timeStr+" 23:59:59", BillCycleUtil.DATETIME_FORMAT);
		    	//
				log.info("是否逾期欠费："+request.getOrderTime().after(payDay));
				if(request.getOrderTime().after(billAccount.getPayDay())){
					throw new BusinessException("000001","账户存在逾期欠费");
				}
			}
		}
	}
	/**
	 * 判断当前用户授信时间是否失效
	 * @param request
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void validateCreditActiveTimeAndCreditExpireTime(BillGenRequest request){
		FunAccountInfo funAccountInfo = this.funAccountInfoAtomSV.findFunAccountInfoByCreditActiveTimeAndCreditExpireTime(Long.valueOf(request.getAccountId()), DateUtil.getSysDate());
		if(null == funAccountInfo){
			throw new BusinessException("000003","此账户授信时间已失效");
		}
	}
	@Transactional
	public void updateOrderToBillAccountRollBack(BillGenRollBackRequest request) throws BusinessException,SystemException{
		 Long accountId = Long.valueOf(request.getAccountId()); 
		 Long fee = request.getFee();
		 Long overdraftQuota = request.getOverdraftQuota();
		 String userId = request.getUserId();
		 String tenantId = request.getTenantId();
		 
		//查询账期id
		 FunAccountInfo funAccountInfo = this.funAccountInfoAtomSV.getBeanByPrimaryKey(accountId);
		 String billCycleId = "";
		 //
		 BillCycleDef billCycleDef = new BillCycleDef();
		 if(null != funAccountInfo){
			 //
			 if(!StringUtils.isEmpty(funAccountInfo.getBillCycleDefId())){
				 billCycleDef = this.billCycleDefAtomSV.getBillCycleDef(Integer.valueOf(funAccountInfo.getBillCycleDefId().toString())); 
			 }else{
				 throw new BusinessException("", "fun_account_info未配置账期信息"); 
			 }
		 }else {
			 throw new BusinessException("", "fun_account_info 信息表为空");
		 }
		 String billGenType = billCycleDef.getBillGenType();
		 Integer amount = billCycleDef.getPostpayUnits();
		 //
		 if(!StringUtil.isBlank(billGenType)){
			 Map<String,Object> billCycleMap = new HashMap<String,Object>();
			 //
			 billCycleMap = BillCycleUtil.getBillCycleIdAndPayDate(billGenType, amount);
			 billCycleId = billCycleMap.get(BillCycleUtil.BILL_CYCLE_ID).toString();
		 }
		//根据商品类目id查询科目id
		 BillOrder2fee billOrder2fee = this.billOrder2feeAtomSV.getBillOrder2fee(request.getProductCatId());
		 
		 String subjectId = "1";
		 if(null != billOrder2fee){
			if(!StringUtil.isBlank(billOrder2fee.getSubjectId())){
				subjectId = billOrder2fee.getSubjectId();
			}
		 }
		//判断根据主键查询 信息是否存在
		 BillAccountKey billAccountKey = new BillAccountKey();
		 billAccountKey.setAccountId(accountId);
		 billAccountKey.setBillCycleId(billCycleId);
		 billAccountKey.setSubjectId(subjectId);
		 //
		 BillAccount billAccountPrimaryKey = this.billAccountAtomSV.getBillAccount(billAccountKey);
		 //
		 if(billAccountPrimaryKey.getFee() - fee < 0 || billAccountPrimaryKey.getOverdraftQuota() - overdraftQuota < 0){
			 throw new BusinessException("000002","订单回退金额超限"); 
		 }
		 //如果存在
		 BillAccount billAccount = new BillAccount();
		 if(null != billAccountPrimaryKey){
			 billAccount.setFee(billAccountPrimaryKey.getFee() - fee);
			 billAccount.setOverdraftQuota(billAccountPrimaryKey.getOverdraftQuota() - overdraftQuota);
			 billAccount.setUserId(userId);
			 billAccount.setTenantId(tenantId);
			 billAccount.setAccountId(accountId);
			 billAccount.setSubjectId(subjectId);
			 billAccount.setBillCycleId(billCycleId);
			 //修改信息
			 this.billAccountAtomSV.updateBillAccountByPrimaryKeySelective(billAccount);
		 }else{
			 throw new BusinessException("000001","回退账单不存在");
		 }
	}
}
