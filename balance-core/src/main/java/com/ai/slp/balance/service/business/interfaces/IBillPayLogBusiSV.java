package com.ai.slp.balance.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.payfee.param.PayFeeRecordRequest;
import com.ai.slp.balance.api.payfee.param.PayFeeRecordResponse;
import com.ai.slp.balance.api.payfee.param.PayFeeRequest;

public interface IBillPayLogBusiSV {
	public void payFee(PayFeeRequest request) throws BusinessException,SystemException;
	public PayFeeRecordResponse payFeeRecord(PayFeeRecordRequest request);
}
