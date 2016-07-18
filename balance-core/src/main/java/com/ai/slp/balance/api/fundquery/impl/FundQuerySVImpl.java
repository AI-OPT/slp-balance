package com.ai.slp.balance.api.fundquery.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.fundquery.interfaces.IFundQuerySV;
import com.ai.slp.balance.api.fundquery.param.AccountIdParam;
import com.ai.slp.balance.api.fundquery.param.ForegiftInfo;
import com.ai.slp.balance.api.fundquery.param.ForegiftQuery;
import com.ai.slp.balance.api.fundquery.param.FundInfo;
import com.ai.slp.balance.api.fundquery.param.SubjectId;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.service.business.interfaces.IFundQueryBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class FundQuerySVImpl implements IFundQuerySV {

    private static final Logger LOG = LogManager.getLogger(FundQuerySVImpl.class);

    @Autowired
    private IFundQueryBusiSV fundQueryBusiSV;

    @Override
    public List<ForegiftInfo> queryForegift(ForegiftQuery param) throws BusinessException,SystemException {
        LOG.debug("按账户ID查询押金开始");
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(param.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (param.getAccountId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "账户ID不能为空");
        }
        List<ForegiftInfo> foregiftInfoList = fundQueryBusiSV.queryForegift(param);
        LOG.debug("押金查询结束");
        return foregiftInfoList;
    }

    @Override
    public FundInfo queryFund(AccountIdParam accountId) throws BusinessException,SystemException {
        LOG.debug("按账户ID查询账户余额");
        if (accountId == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(accountId.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (accountId.getAccountId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "账户ID不能为空");
        }
        FundInfo fundInfo = new FundInfo();
        ResponseHeader responseHeader = new ResponseHeader();
        try{
        	fundInfo = fundQueryBusiSV.queryFund(accountId);
        	LOG.debug("余额查询结束");
        	if(!CollectionUtil.isEmpty(fundInfo.getFundBooks())){
        		responseHeader.setResultCode("0000");
        		responseHeader.setResultMessage("成功");
        		responseHeader.setIsSuccess(true);
        		fundInfo.setResponseHeader(responseHeader);
        	}else{
        		responseHeader.setResultCode("0001");
        		responseHeader.setResultMessage("未查询到余额信息");
        		fundInfo.setResponseHeader(responseHeader);
        	}
        	//
        	return fundInfo;
        }catch(Exception e){
        	responseHeader.setResultCode("0002");
    		responseHeader.setResultMessage("账户余额查询失败");
    		fundInfo.setResponseHeader(responseHeader);
    		return fundInfo;
        }
        
    }

    @Override
    public FundInfo queryUsableFund(AccountIdParam accountId) throws BusinessException,SystemException {
        LOG.debug("按账户ID查询账户可用余额");
        if (accountId == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(accountId.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (accountId.getAccountId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "账户ID不能为空");
        }
        FundInfo fundInfo = fundQueryBusiSV.queryUsableFund(accountId);
        LOG.debug("可用余额查询结束");
        return fundInfo;
    }

    @Override
    public FundInfo queryFrozenFund(AccountIdParam accountId) throws BusinessException,SystemException {
        LOG.debug("按账户ID查询账户冻结资金");
        if (accountId == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(accountId.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (accountId.getAccountId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "账户ID不能为空");
        }
        FundInfo fundInfo = fundQueryBusiSV.queryFrozenFund(accountId);
        LOG.debug("冻结资金查询结束");
        return fundInfo;
    }

    @Override
    public FundInfo queryUsableTeleFund(AccountIdParam accountId) throws BusinessException,SystemException {
        LOG.debug("按账户ID查询可用通信资金");
        if (accountId == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(accountId.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (accountId.getAccountId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "账户ID不能为空");
        }
        FundInfo fundInfo = fundQueryBusiSV.queryUsableTeleFund(accountId);
        LOG.debug("可用通信资金查询结束");
        return fundInfo;
    }

    @Override
    public FundInfo queryFundBySubjectId(SubjectId subjectId) throws BusinessException,SystemException {
        LOG.debug("按科目ID查询资金账本");
        if (subjectId == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(subjectId.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (subjectId.getAccountId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "账户ID不能为空");
        }
        if (subjectId.getSubjectId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "科目ID不能为空");
        }
        return fundQueryBusiSV.queryFund(subjectId);
    }

    @Override
    public List<String> queryCoupon(AccountIdParam accountId) throws BusinessException,SystemException {
        // TODO
        return new ArrayList<String>();
    }

}
