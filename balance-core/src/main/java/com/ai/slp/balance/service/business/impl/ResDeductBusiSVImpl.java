package com.ai.slp.balance.service.business.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.balance.api.resdeduct.param.ResourceDeduct;
import com.ai.slp.balance.constants.BalancesCostants;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.dao.mapper.bo.FunResOperaDetail;
import com.ai.slp.balance.service.atom.interfaces.IFunResBookRestAmountAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunResOperaDetailAtomSV;
import com.ai.slp.balance.service.business.interfaces.IResDeductBusiSV;

@Service
@Transactional
public class ResDeductBusiSVImpl implements IResDeductBusiSV {

    private static final Logger LOG = LogManager.getLogger(ResDeductBusiSVImpl.class);

    @Autowired
    private IFunResBookRestAmountAtomSV funResBookRestAmountAtomSV;

    @Autowired
    private IFunResOperaDetailAtomSV funResOperaDetailAtomSV;

    @Override
    public void deductResource(ResourceDeduct param) throws BusinessException {
        LOG.debug("开始执行资源抵扣服务");
        // 幂等性校验
        FunResOperaDetail funResOperaDetail = funResOperaDetailAtomSV.getBean(param.getTenantId(),
                param.getSystemId(), param.getExternalId(),
                BalancesCostants.FunResOperaDetail.OptType.DEPOSIT);
        if (funResOperaDetail != null) {
            LOG.error("幂等性校验：已经抵扣,不再重复抵扣[tenantId:{},systemId:{},externalId:{}]",
                    param.getTenantId(), param.getSystemId(), param.getExternalId());
            return;
        }
        Timestamp sysdate = DateUtil.getSysDate();
        BigDecimal amount = BigDecimal.valueOf(param.getTotalAmount()).negate();
        // 1.创建抵扣记录
        FunResOperaDetail opera = new FunResOperaDetail();
        opera.setTenantId(param.getTenantId());
        opera.setSystemId(param.getSystemId());
        opera.setExternalId(param.getExternalId());
        opera.setOwnerId(param.getOwnerId());
        opera.setOwnerType(param.getOwnerType());
        opera.setResourceType(param.getResourceType());
        opera.setChangeAmount(amount);
        opera.setOptType(BalancesCostants.FunResOperaDetail.OptType.DEDUCT);
        opera.setOptTime(sysdate);
        opera.setBookStatus(BalancesCostants.FunResOperaDetail.Status.WAIT_DEDUCT);
        funResOperaDetailAtomSV.insert(opera);
        // 2.更新总表量
        int result = funResBookRestAmountAtomSV.offsetAmount(param.getTenantId(),
                param.getOwnerId(), param.getOwnerType(), param.getResourceType(), amount);
        funResBookRestAmountAtomSV.offsetAmount(null, 0, 0, 0, null);
        if (result != 1) {
            throw new BusinessException(ExceptCodeConstants.Special.NO_RESULT, "该属主尚未进行过入账，不可抵扣");
        }
    }

}
