package com.ai.runner.center.balance.api.resquery.impl;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.runner.base.exception.BusinessException;
import com.ai.runner.base.exception.CallerException;
import com.ai.runner.center.balance.api.resquery.interfaces.IResQuerySV;
import com.ai.runner.center.balance.api.resquery.param.ResAmount;
import com.ai.runner.center.balance.api.resquery.param.ResAmountQuery;
import com.ai.runner.center.balance.api.resquery.param.ResDetailQuery;
import com.ai.runner.center.balance.api.resquery.param.ResPkgInfo;
import com.ai.runner.center.balance.api.resquery.param.ResPkgQuery;
import com.ai.runner.center.balance.api.resquery.param.ResUsableDetail;
import com.ai.runner.center.balance.constants.BalancesCostants;
import com.ai.runner.center.balance.constants.ExceptCodeConstants;
import com.ai.runner.center.balance.service.business.interfaces.IResQueryBusiSV;
import com.ai.runner.utils.util.StringUtil;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class ResQuerySVImpl implements IResQuerySV {
    
    private static final Logger LOG = LogManager.getLogger(ResQuerySVImpl.class);
    
    @Autowired
    private IResQueryBusiSV resQueryBusiSV;

    @Override
    public ResAmount queryUsableAmount(ResAmountQuery param) throws CallerException {
        LOG.debug("开始资源可用总量查询");
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(param.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (param.getOwnerId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "属主ID不能为空");
        }
        if(Collections.binarySearch(BalancesCostants.FunResBook.OwnerType.ALL, param.getOwnerType())<0){
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,"属主类型不合法");
        }
        if(Collections.binarySearch(BalancesCostants.FunResBook.ResourceType.ALL,param.getResourceType())<0){
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_NOT_VALID,"资源类型不合法");
        }
        return resQueryBusiSV.queryUsableAmount(param);
    }

    @Override
    public List<ResPkgInfo> queryResPackage(ResPkgQuery param) throws CallerException {
        LOG.debug("开始查询套餐余量");
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "请求参数不能为空");
        }
        if (StringUtil.isBlank(param.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "租户ID不能为空");
        }
        if (param.getOwnerId() == 0) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "属主ID不能为空");
        }
        List<ResPkgInfo> result = resQueryBusiSV.queryResPackage(param);
        LOG.debug("套餐余量查询结束");
        return result;
    }

    @Override
    public ResUsableDetail queryUsableDetail(ResDetailQuery param) throws CallerException {
        return null;
    }

}
