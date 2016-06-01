package com.ai.slp.balance.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.opt.sdk.cache.base.AbstractCache;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.ai.slp.balance.constants.CacheNSMapper;
import com.ai.slp.balance.dao.mapper.bo.FunSubject;
import com.ai.slp.balance.dao.mapper.bo.FunSubjectFund;
import com.ai.slp.balance.service.business.interfaces.IFunSubjectBusiSV;
import com.ai.slp.balance.util.CacheFactoryUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 科目编码和科目类型缓存类 <br>
 * 缓存key为subjectId 缓存对象融合了FUN_SUBJECT和FUN_SUBJECT_FUND <br>
 * Date: 2015年8月19日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
@Component
public class FunSubjectCache extends AbstractCache {

    @Autowired
    private IFunSubjectBusiSV funSubjectBusiSV;

    @Override
    public void write() throws Exception {
        // 查询数据
        List<FunSubject> funSubjectList = funSubjectBusiSV.queryFunSubject();
        List<FunSubjectFund> funSubjectFundList = funSubjectBusiSV.queryFunSubjectFund();
        // 将FUN_SUBJECT_FUND转为Map
        Map<Long, FunSubjectFund> funSubjectFundMap = new HashMap<Long, FunSubjectFund>();
        for (FunSubjectFund funSubjectFund : funSubjectFundList) {
            funSubjectFundMap.put(funSubjectFund.getSubjectId(), funSubjectFund);
        }
        if (CollectionUtil.isEmpty(funSubjectList)) {
            return;
        }
        // 合并FUN_SUBJECT和FUN_SUBJECT_FUND，并放入缓存
        ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_FUN_SUBJECT);
        for (FunSubject funSubject : funSubjectList) {
            String key = String.valueOf(funSubject.getSubjectId()).toUpperCase();
            FunSubjectFund funSubjectFund = funSubjectFundMap.get(funSubject.getSubjectId());
            JSONObject subjectJson = JSON.parseObject(JSON.toJSONString(funSubject));
            if (funSubjectFund != null
                    && funSubjectFund.getTenantId().equals(funSubject.getTenantId())) {
                subjectJson.putAll(JSON.parseObject(JSON.toJSONString(funSubjectFund)));
            }
            cacheClient.hset(CacheNSMapper.CACHE_FUN_SUBJECT, key, subjectJson.toJSONString());
        }
    }

}
