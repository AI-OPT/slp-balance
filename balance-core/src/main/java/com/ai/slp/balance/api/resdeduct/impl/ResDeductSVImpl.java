package com.ai.slp.balance.api.resdeduct.impl;

import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.resdeduct.interfaces.IResDeductSV;
import com.ai.slp.balance.api.resdeduct.param.ResourceDeduct;
import com.ai.slp.balance.constants.BalancesCostants;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.service.business.interfaces.IResDeductBusiSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class ResDeductSVImpl implements IResDeductSV {

    private static final Logger log = LogManager.getLogger(ResDeductSVImpl.class);
    
    @Autowired
    private IResDeductBusiSV resDeductBusiSV;

    @Override
    public void deductResource(ResourceDeduct param) throws BusinessException,SystemException {
        log.debug("开始资源扣减服务");
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
        if (param.getOwnerId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "属主ID不能为空");
        }
        if (Collections.binarySearch(BalancesCostants.FunResBook.OwnerType.ALL, param.getOwnerType()) < 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "属主类型不合法");
        }
        resDeductBusiSV.deductResource(param);
    }

}
