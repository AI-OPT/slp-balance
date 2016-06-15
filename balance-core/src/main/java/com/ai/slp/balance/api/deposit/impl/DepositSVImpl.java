package com.ai.slp.balance.api.deposit.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.deposit.interfaces.IDepositSV;
import com.ai.slp.balance.api.deposit.param.DepositParam;
import com.ai.slp.balance.api.deposit.param.ForegiftDeposit;
import com.ai.slp.balance.api.deposit.param.TransSummary;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.service.business.interfaces.IDepositBusiSV;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;

@Service
@Component
public class DepositSVImpl implements IDepositSV {
    
    private static final Logger log = LogManager.getLogger(DepositSVImpl.class);

    @Autowired
    private IDepositBusiSV depositSV;

    @Override
    public String depositFund(DepositParam param) throws BusinessException,SystemException {
        log.debug("开始存款服务");
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (param.getAccountId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "存款账户号不能为空");
        }
        if (StringUtil.isBlank(param.getBusiSerialNo())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "业务流水号不能为空");
        }
        if (CollectionUtil.isEmpty(param.getTransSummary())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "交易摘要不能为空");
        }
        for (TransSummary summary : param.getTransSummary()) {
            if (summary.getSubjectId() == 0) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "科目ID不能为空["
                        + JSON.toJSONString(summary) + "]");
            }
            if (!StringUtil.isBlank(summary.getFundeffDate())
                    && !DateUtil.isValidDate(summary.getFundeffDate(), DateUtil.DATETIME_FORMAT)) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "生效时间格式不正确["
                        + JSON.toJSONString(summary) + "]");
            }
            if (!StringUtil.isBlank(summary.getFundexpDate())
                    && !DateUtil.isValidDate(summary.getFundexpDate(), DateUtil.DATETIME_FORMAT)) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "失效时间格式不正确["
                        + JSON.toJSONString(summary) + "]");
            }
        }
        return depositSV.depositFund(param);
    }

    @Override
    public String depositForegift(ForegiftDeposit param) throws BusinessException,SystemException {
        log.debug("开始存入押金服务");
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (param.getSubjectId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "科目不能为空");
        }
        if (param.getAccountId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "存款账户号不能为空");
        }
        if (param.getAmount() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "存款金额不能为零");
        }
        if (StringUtil.isBlank(param.getBusiSerialNo())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "业务流水号不能为空");
        }
        if (!StringUtil.isBlank(param.getFundeffDate())
                && !DateUtil.isValidDate(param.getFundeffDate(), DateUtil.DATETIME_FORMAT)) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "生效时间格式不正确["
                    + JSON.toJSONString(param) + "]");
        }
        if (!StringUtil.isBlank(param.getFundexpDate())
                && !DateUtil.isValidDate(param.getFundexpDate(), DateUtil.DATETIME_FORMAT)) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT, "失效时间格式不正确["
                    + JSON.toJSONString(param) + "]");
        }
        return depositSV.depositForegift(param);
    }
}
