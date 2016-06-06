package com.ai.slp.balance.api.resdeposit.impl;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.resdeposit.interfaces.IResDepositSV;
import com.ai.slp.balance.api.resdeposit.param.ResourceDeposit;
import com.ai.slp.balance.constants.BalancesCostants;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.service.business.interfaces.IResDepositBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class ResDepositSVImpl implements IResDepositSV {

    @Autowired
    private IResDepositBusiSV resDepositBusiSV;

    @Override
    public void depositResource(ResourceDeposit param) throws BusinessException,SystemException {

        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(param.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (StringUtil.isBlank(param.getSystemId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "系统ID不能为空");
        }
        if (StringUtil.isBlank(param.getExternalId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "外部流水号不能为空");
        }
        if (Collections.binarySearch(BalancesCostants.FunResBook.OwnerType.ALL,
                param.getOwnerType()) < 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "属主类型不合法");
        }
        if (param.getOwnerId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "属主不能为空");
        }
        if (Collections.binarySearch(BalancesCostants.FunResBook.ResourceType.ALL,
                param.getResourceType()) < 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_NOT_VALID, "资源类型不合法");
        }
        if (!StringUtil.isBlank(param.getEffectDate())
                && !DateUtil.isValidDate(param.getEffectDate(), DateUtil.DATETIME_FORMAT)) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT,
                    "生效时间格式不正确[" + param.getEffectDate() + "]");
        }
        if (!StringUtil.isBlank(param.getExpireDate())
                && !DateUtil.isValidDate(param.getExpireDate(), DateUtil.DATETIME_FORMAT)) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_TYPE_NOT_RIGHT,
                    "失效时间格式不正确[" + param.getExpireDate() + "]");
        }
        if (Collections.binarySearch(BalancesCostants.FunResBook.AllowPresent.ALL,
                param.getAllowPresent()) < 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_NOT_VALID, "转增标识不合法");
        }
        if (Collections.binarySearch(BalancesCostants.FunResBook.AllowConvert.ALL,
                param.getAllowConvert()) < 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_NOT_VALID, "转兑/买卖标识不合法");
        }
        if (Collections.binarySearch(BalancesCostants.FunResBook.AllowClear.ALL,
                param.getAllowClear()) < 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_NOT_VALID, "清零标识不合法");
        }
        if (Collections.binarySearch(BalancesCostants.FunResBook.SourceType.ALL,
                param.getSourceType()) < 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_NOT_VALID, "入账类型不合法");
        }
        if (param.getSourceId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "入账来源不能为空");
        }
        if (!StringUtil.isBlank(param.getUseFlag())
                && !BalancesCostants.FunResBook.UseFlag.IMMEDIATELY.equals(param.getUseFlag())
                && !BalancesCostants.FunResBook.UseFlag.UM_IMMEDIATELY.equals(param.getUseFlag())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_NOT_VALID, "即用即买标识不合法");
        }
        resDepositBusiSV.depositResource(param);
    }

}
