package com.ai.slp.balance.service.business.interfaces;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.slp.balance.api.custcredit.param.CustCreditDetailRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditDetailResponse;
import com.ai.slp.balance.api.custcredit.param.CustCreditRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditSettingRecordRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditSettingRecordResponse;
import com.ai.slp.balance.api.custcredit.param.CustCreditUnUsedRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditUnUsedResponse;
import com.ai.slp.balance.api.custcredit.param.CustCreditUsedRequest;
import com.ai.slp.balance.api.custcredit.param.CustCreditUsedResponse;

public interface IFunAccountInfoBusiSV {
	public void updateCredit(CustCreditRequest request) throws BusinessException,SystemException;
	/**
	 * 客户授信额度设置
	 * @param request
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void updateSettingCredit(CustCreditRequest request) throws BusinessException,SystemException;
	/**
	 * 授信详情查询
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public CustCreditDetailResponse findCustCreditDetail(CustCreditDetailRequest request) throws BusinessException,SystemException;
	/**
	 * 查询信用额度调整记录
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public CustCreditSettingRecordResponse queryCustCreditSettingRecord(CustCreditSettingRecordRequest request) throws BusinessException,SystemException;
	/**
	 * 客户已使用额度查询
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public CustCreditUsedResponse findCustCreditUsed(CustCreditUsedRequest request)throws BusinessException,SystemException;
	/**
	 * 客户未使用额度查询
	 * @param request
	 * @return
	 * @throws BusinessException
	 * @throws SystemException
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public CustCreditUnUsedResponse findCustCreditUnUsed(CustCreditUnUsedRequest request)throws BusinessException,SystemException;
	
}
