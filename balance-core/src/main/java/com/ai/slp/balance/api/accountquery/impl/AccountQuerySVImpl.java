package com.ai.slp.balance.api.accountquery.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.accountquery.interfaces.IAccountQuerySV;
import com.ai.slp.balance.api.accountquery.param.AccountIdParam;
import com.ai.slp.balance.api.accountquery.param.AccountInfoVo;
import com.ai.slp.balance.api.accountquery.param.CustIdParam;
import com.ai.slp.balance.api.accountquery.param.ListAccountResponse;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.service.business.interfaces.IAccountManagerSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class AccountQuerySVImpl implements IAccountQuerySV {

    private static final Logger log = LogManager.getLogger(AccountQuerySVImpl.class);

    @Autowired
    private IAccountManagerSV accountSV;

    @Override
    public AccountInfoVo queryAccontById(AccountIdParam accountId) throws BusinessException,SystemException {
        log.debug("按账户ID查询账户开始");
        AccountInfoVo accountInfoVo = null;
        if (accountId == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(accountId.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (accountId.getAccountId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "账户ID不能为空");
        }
        accountInfoVo = accountSV.queryAccountInfoById(accountId.getTenantId(),
                accountId.getAccountId());
        log.debug("账户查询结束");
        return accountInfoVo;
    }

    @Override
    public List<AccountInfoVo> queryAccontByCustId(CustIdParam custId) throws BusinessException,SystemException {

        log.debug("按客户UD查询账户开始");
        if (custId == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(custId.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (StringUtil.isBlank(custId.getCustId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "客户ID不能为空");
        }
        List<AccountInfoVo> accountInfoVoList = accountSV.queryAccountInfoByCustId(
                custId.getTenantId(), custId.getCustId());
        log.debug("账户查询结束");
        BaseResponse response = new BaseResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        if(CollectionUtil.isEmpty(accountInfoVoList)){
//        	responseHeader.setIsSuccess(false);
//        	responseHeader.setResultCode("0001");
//        	responseHeader.setResultMessage("未找到指定账户");
//        	response.setResponseHeader(responseHeader);
        	throw new BusinessException("0001","未找到指定账户");
        }
        return accountInfoVoList;
    }

	@Override
	public ListAccountResponse queryAccontByCustIdNew(CustIdParam custId) throws BusinessException, SystemException {

        log.debug("按客户UD查询账户开始");
        if (custId == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(custId.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (StringUtil.isBlank(custId.getCustId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "客户ID不能为空");
        }
        
        //
        ListAccountResponse listAccountResponse = new ListAccountResponse();
        ResponseHeader responseHeader = new ResponseHeader();
        try{
	        List<AccountInfoVo> accountInfoVoList = accountSV.queryAccountInfoByCustId(
	                custId.getTenantId(), custId.getCustId());
	        log.debug("账户查询结束");
	        
	        listAccountResponse.setAccountInfoVoList(accountInfoVoList);
	        if(CollectionUtil.isEmpty(accountInfoVoList)){
	        	responseHeader.setResultCode("0001");
	        	responseHeader.setResultMessage("未找到指定账户");
	        	listAccountResponse.setResponseHeader(responseHeader);
	        }else{
	        	responseHeader.setResultCode("0000");
	        	responseHeader.setResultMessage("成功");
	        	responseHeader.setIsSuccess(true);
	        	listAccountResponse.setResponseHeader(responseHeader);
	        }
	        //
	        return listAccountResponse;
        }catch(Exception e){
        	responseHeader.setResultCode("0002");
        	responseHeader.setResultMessage("查询资料失败");
        	listAccountResponse.setResponseHeader(responseHeader);
        	//
        	return listAccountResponse;
        }
        
        //
	}

}
