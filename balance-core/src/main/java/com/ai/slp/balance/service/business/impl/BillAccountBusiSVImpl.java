package com.ai.slp.balance.service.business.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.ordertobillaccount.param.BillGenRequest;
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
@Service
public class BillAccountBusiSVImpl implements IBillAccountBusiSV {
	@Autowired
	private IBillAccountAtomSV billAccountAtomSV;
	
	@Autowired
	private IBillCycleDefAtomSV billCycleDefAtomSV;
	
	@Autowired
	private IBillOrder2feeAtomSV billOrder2feeAtomSV;
	
	@Autowired
	private IFunAccountInfoAtomSV funAccountInfoAtomSV;
	
	@Override
	public void orderToBillAccount(BillGenRequest request) throws BusinessException, SystemException {
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
			 billAccount.setOverdraftQuota(overdraftQuota+billAccountPrimaryKey.getFee());
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
		List<BillAccount> billAccountList = this.billAccountAtomSV.queryBillAccount(request.getTenantId(), request.getAccountId());
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
}
