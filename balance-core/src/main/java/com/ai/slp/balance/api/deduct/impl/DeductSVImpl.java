package com.ai.slp.balance.api.deduct.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.base.vo.ResponseHeader;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.deduct.interfaces.IDeductSV;
import com.ai.slp.balance.api.deduct.param.DeductAccount;
import com.ai.slp.balance.api.deduct.param.DeductParam;
import com.ai.slp.balance.api.deduct.param.DeductResponse;
import com.ai.slp.balance.api.deduct.param.ForegiftDeduct;
import com.ai.slp.balance.api.deduct.param.SettleParam;
import com.ai.slp.balance.api.deduct.param.SettleSummary;
import com.ai.slp.balance.api.deduct.param.TransSummary;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.service.business.interfaces.IDeductBusiSV;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;

@Service
@Component
public class DeductSVImpl implements IDeductSV {

    private static final Logger log = LogManager.getLogger(DeductSVImpl.class);

    @Autowired
    private IDeductBusiSV deductBusiSV;

    @Override
    public DeductResponse deductFund(DeductParam param) throws BusinessException,SystemException {
        log.debug("开始普通扣款服务");
        String serialNo = "";
        ResponseHeader responseHeader = new ResponseHeader(true, "success", "扣款成功");

        DeductResponse deductResponse = new DeductResponse();
        try {
            if (param == null) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
            }
            if (StringUtil.isBlank(param.getTenantId())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
            }
            if (StringUtil.isBlank(param.getSystemId())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "系统ID不能为空");
            }
            if (param.getAccountId() == 0) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "账户号不能为空");
            }
            

            if (param.getCheckPwd() == 0 && StringUtil.isBlank(param.getPassword())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "校验支付密码后支付密码不能为空");
            }
            if (StringUtil.isBlank(param.getExternalId())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "外部流水号不能为空");
            }
            if (StringUtil.isBlank(param.getBusinessCode())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "业务操作类型不能为空");
            }
            if (!CollectionUtil.isEmpty(param.getTransSummary())) {

                for (TransSummary summary : param.getTransSummary()) {
                    if (summary.getSubjectId() == 0) {
                        throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,
                                "资金科目ID不能为空[" + JSON.toJSONString(summary) + "]");
                    }
                }
            }
            serialNo = deductBusiSV.deductFund(param);
            deductResponse.setSerialNo(serialNo);
        } catch (BusinessException e) {
            responseHeader = new ResponseHeader(false, e.getErrorCode(), e.getErrorMessage());
        }catch (SystemException e){
            responseHeader = new ResponseHeader(false, e.getErrorCode(), e.getErrorMessage());
        }catch (Exception e){
            responseHeader = new ResponseHeader(false, e.getMessage(), e.getMessage());
        }
        deductResponse.setResponseHeader(responseHeader);
        return deductResponse;
    }

    @Override
    public String settleAccount(SettleParam param) throws BusinessException,SystemException {
        log.debug("开始销账扣款服务");
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(param.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (StringUtil.isBlank(param.getSystemId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "系统ID不能为空");
        }
        if (param.getAccountId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "账户号不能为空");
        }
        if (StringUtil.isBlank(param.getExternalId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "外部流水号不能为空");
        }
        if (CollectionUtil.isEmpty(param.getTransSummary())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "交易摘要不能为空");
        }
        for (SettleSummary summary : param.getTransSummary()) {
            if (summary.getBookId() == 0) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "账本ID不能为空["
                        + JSON.toJSONString(summary) + "]");
            }
            if (summary.getSubjectId() == 0) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,
                        "资金科目ID不能为空[" + JSON.toJSONString(summary) + "]");
            }
            if (summary.getFeeSubjectId() == 0) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,
                        "销账科目ID不能为空[" + JSON.toJSONString(summary) + "]");
            }
        }
        return deductBusiSV.settleAccount(param);
    }

    @Override
    public String deductForegift(ForegiftDeduct param) throws BusinessException,SystemException {
        log.debug("开始押金扣减服务");
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(param.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (StringUtil.isBlank(param.getSystemId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "系统ID不能为空");
        }
        if (param.getAccountId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "账户号不能为空");
        }
        if (param.getSubjectId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "押金科目不能为空");
        }
        if (param.getBookId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "账本ID不能为空");
        }
        if (StringUtil.isBlank(param.getExternalId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "外部单号不能为空");
        }
        return deductBusiSV.deductForegift(param);
    }

    @Override
    public long deductPartFundByAccount(DeductAccount param) throws BusinessException,SystemException {
        log.debug("开始按照账户部分扣款服务");
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(param.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (StringUtil.isBlank(param.getSystemId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "系统ID不能为空");
        }
        if (param.getAccountId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "账户号不能为空");
        }
        if (StringUtil.isBlank(param.getExternalId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "外部流水号不能为空");
        }
        if (StringUtil.isBlank(param.getBusinessCode())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "业务操作类型不能为空");
        }
        return deductBusiSV.deductPartFundByAccount(param);
    }

}
