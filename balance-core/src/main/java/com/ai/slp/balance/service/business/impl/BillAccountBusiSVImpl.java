package com.ai.slp.balance.service.business.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.DateUtil;
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
		//String 
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
			 if(!StringUtil.isBlank(String.valueOf(funAccountInfo.getBillCycleDefId()))){
				 billCycleDef = this.billCycleDefAtomSV.getBillCycleDef(Integer.valueOf(funAccountInfo.getBillCycleDefId().toString())); 
			 }
		 }
		 String billGenType = billCycleDef.getBillGenType();
		 if(!StringUtil.isBlank(billGenType) && billGenType.equals("D")){
			 billCycleId = DateUtil.getDateString(request.getOrderTime(), "YYYYMMddHHmmss");
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
			 billAccount.setPayDay(DateUtil.getSysDate());
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
			 billAccount.setPayDay(DateUtil.getSysDate());
			 //
			 this.billAccountAtomSV.insert(billAccount);
		 }
		 
	}

}
