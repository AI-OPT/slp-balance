package com.ai.slp.balance.service.business.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.PageInfo;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.slp.balance.api.payfee.param.PayFeeRecordRequest;
import com.ai.slp.balance.api.payfee.param.PayFeeRecordResponse;
import com.ai.slp.balance.api.payfee.param.PayFeeRecordVo;
import com.ai.slp.balance.api.payfee.param.PayFeeRequest;
import com.ai.slp.balance.dao.mapper.bo.BillAccount;
import com.ai.slp.balance.dao.mapper.bo.BillPayDetail;
import com.ai.slp.balance.dao.mapper.bo.BillPayLog;
import com.ai.slp.balance.service.atom.interfaces.IBillAccountAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IBillPayDetailAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IBillPayLogAtomSV;
import com.ai.slp.balance.service.business.interfaces.IBillPayLogBusiSV;
@Service
public class BillPayLogBusiSVImpl implements IBillPayLogBusiSV {
	@Autowired
	private IBillPayLogAtomSV billPayLogAtomSV;
	@Autowired
	private IBillPayDetailAtomSV billPayDetailAtomSV;
	@Autowired
	private IBillAccountAtomSV billAccountAtomSV;

	@Override
	@Transactional
	public void payFee(PayFeeRequest request) throws BusinessException, SystemException {
		
		List<BillAccount> billAccountList = this.billAccountAtomSV.queryBillAccountOverdraftQuotaGreaterThanZero(request.getTenantId(), request.getAccountId());
		//判断支付金额是否大于所有欠费金额，如果大于 提示重新输入
		Integer payFeeTotal = 0;
		for(BillAccount billAccount : billAccountList){
			payFeeTotal += Integer.parseInt(billAccount.getOverdraftQuota().toString());
			if(payFeeTotal < request.getPayFee()){
				throw new BusinessException("999999","支付金额大于还款金额");
			}
		}
		
		//还款流水号
		String payLogSeq = String.valueOf(SeqUtil.getNewId("bill_pay_log$pay_log_seq$SEQ"));
		//
		BillPayLog billPayLog = new BillPayLog();
		billPayLog.setAccountId(Long.valueOf(request.getAccountId()));
		billPayLog.setPayDate(request.getPayFeeTime());
		billPayLog.setPayFee(request.getPayFee());
		billPayLog.setPayLogSeq(payLogSeq);
		billPayLog.setStatus(1l);
		billPayLog.setTenantId(request.getTenantId());
		billPayLog.setUserId(request.getCustId());
		billPayLog.setRollbackDate(null);
		billPayLog.setOverdraft(Long.valueOf(payFeeTotal.toString()));
		//
		this.billPayLogAtomSV.insert(billPayLog);
		
		//1
		Integer totalFee = 0;
		BillPayDetail billPayDetail = null;
		//查询透支额不为0的账单列表
		for(BillAccount billAccount : billAccountList){
			//
			totalFee += Integer.parseInt(billAccount.getOverdraftQuota().toString());
			//添加信息到BillPayDetail
			billPayDetail = new BillPayDetail();
			billPayDetail.setAccountId(Long.valueOf(request.getAccountId()));
			billPayDetail.setBillIteamSeq(billAccount.getBillItemSeq());
			billPayDetail.setPayBillFee(billAccount.getOverdraftQuota());
			billPayDetail.setPayLogSeq(payLogSeq);
			billPayDetail.setStatus(1l);
			billPayDetail.setTenantId(request.getTenantId());
			billPayDetail.setUserId(request.getCustId());
			//
			if(totalFee >= request.getPayFee()){
				//剩余未还款
				Integer fee = totalFee - Integer.parseInt(request.getPayFee().toString());
				//已经还的款
				Integer alreadyFee = Integer.valueOf(billAccount.getOverdraftQuota().toString()) - fee;
				billPayDetail.setPayBillFee(Long.valueOf(alreadyFee));
				this.insertBillPayDetail(billPayDetail);
				//
				this.billAccountAtomSV.updateBillAccountByBillItemSeq(billAccount.getBillItemSeq(), Long.valueOf(fee));
				//
				return;
			}else{
				//
				this.insertBillPayDetail(billPayDetail);
				//将透支额度修改为0
				this.billAccountAtomSV.updateBillAccountByBillItemSeq(billAccount.getBillItemSeq(), 0l);
				
			}
		}
		
	}
	
	public void insertBillPayDetail(BillPayDetail billPayDetail){
		
		this.billPayDetailAtomSV.insert(billPayDetail);
	}
	/**
	 * 查询还款记录
	 */
	@Override
	public PayFeeRecordResponse payFeeRecord(PayFeeRecordRequest request) {
		//
		String tenantId = request.getTenantId();
		Long accountId = request.getAccountId();
		String userId = request.getCustId();
		Timestamp startTime = request.getStartTime();
		Timestamp endTime = request.getEndTime();
		Integer pageNo = request.getPageNo();
		Integer pageSize = request.getPageSize();
		//
		PageInfo<BillPayLog> pageInfo = this.billPayLogAtomSV.queryBillPayLogPageInfo(tenantId, accountId, userId, startTime, endTime, pageNo, pageSize);
		//
		PageInfo<PayFeeRecordVo> pageInfoNew = new PageInfo<PayFeeRecordVo>();
		//
		pageInfoNew.setCount(pageInfo.getCount());
		pageInfoNew.setPageCount(pageInfo.getPageCount());
		pageInfoNew.setPageNo(pageNo);
		pageInfoNew.setPageSize(pageSize);
		//
		List<PayFeeRecordVo> payFeeRecordVoList = new ArrayList<PayFeeRecordVo>();
		//
		PayFeeRecordVo vo = null;
		for(BillPayLog billPayLog : pageInfo.getResult()){
			vo = new PayFeeRecordVo();
			//
			vo.setOverdraft(billPayLog.getOverdraft());
			vo.setPayDate(billPayLog.getPayDate());
			vo.setPayFee(billPayLog.getPayFee());
			vo.setRemark("");
			//
			payFeeRecordVoList.add(vo);
		}
		//
		pageInfoNew.setResult(payFeeRecordVoList);
		//
		PayFeeRecordResponse response = new PayFeeRecordResponse();
		//
		response.setPayFeeRecordVoPageInfo(pageInfoNew);
		//
		return response;
	}

}
