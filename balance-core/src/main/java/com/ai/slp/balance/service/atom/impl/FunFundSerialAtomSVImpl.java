package com.ai.slp.balance.service.atom.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.dao.mapper.bo.FunFundSerial;
import com.ai.slp.balance.dao.mapper.bo.FunFundSerialByAcctIdIdx;
import com.ai.slp.balance.dao.mapper.bo.FunFundSerialByAcctIdIdxCriteria;
import com.ai.slp.balance.dao.mapper.bo.FunFundSerialCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IFunFundSerialAtomSV;

@Component
public class FunFundSerialAtomSVImpl implements IFunFundSerialAtomSV {
    
    private static final Logger log = LogManager.getLogger(FunFundSerialAtomSVImpl.class);

    @Override
    public FunFundSerial getBeans(String peerSerialCode, String tenantId, String systemId) {
        FunFundSerialCriteria example = new FunFundSerialCriteria();
        example.createCriteria().andPeerSerialCodeEqualTo(peerSerialCode)
                .andTenantIdEqualTo(tenantId).andSystemIdEqualTo(systemId);
        List<FunFundSerial> funFundSerialList = MapperFactory.getFunFundSerialMapper()
                .selectByExample(example);
        // peerSerialCode，tenantId，systemId构成幕等性校验，最多存在一个
        return CollectionUtil.isEmpty(funFundSerialList) ? null : funFundSerialList.get(0);
    }

    @Override
    public void insertFunFundSerial(FunFundSerial funFundSerial) {
        MapperFactory.getFunFundSerialMapper().insert(funFundSerial);
    }

    @Override
    public void addIndexAcctId(FunFundSerialByAcctIdIdx idx) {
        log.debug("开始进入创建FunFundSerialByAcctIdIdx原子服务");
        FunFundSerialByAcctIdIdxCriteria example = new FunFundSerialByAcctIdIdxCriteria();
        if (idx.getAcctId1() == 0) {
            log.debug("创建索引FunFundSerialByAcctIdIdx失败：索引表属性AcctId1不能为空");
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "索引表属性AcctId1不能为空");
        }
        if (StringUtil.isBlank(idx.getPeerSerialCode())) {
            log.debug("创建索引FunFundSerialByAcctIdIdx失败：索引表属性PeerSerialCode不能为空");
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,
                    "索引表属性PeerSerialCode不能为空");
        }
        if (StringUtil.isBlank(idx.getTenantId())) {
            log.debug("创建索引FunFundSerialByAcctIdIdx失败：索引表属性TenantId不能为空");
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "索引表属性TenantId不能为空");
        }
        example.createCriteria().andAcctId1EqualTo(idx.getAcctId1())
                .andPeerSerialCodeEqualTo(idx.getPeerSerialCode())
                .andTenantIdEqualTo(idx.getTenantId());
        if (CollectionUtil.isEmpty(MapperFactory.getFunFundSerialByAcctIdIdxMapper()
                .selectByExample(example))) {
            MapperFactory.getFunFundSerialByAcctIdIdxMapper().insert(idx);
        }
    }

}
