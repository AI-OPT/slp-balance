package com.ai.slp.balance.util;

import java.util.ArrayList;
import java.util.List;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.paas.ipaas.mcs.interfaces.ICacheClient;
import com.ai.slp.balance.constants.CacheNSMapper;
import com.ai.slp.balance.vo.SubjectFundVo;
import com.ai.slp.balance.vo.SubjectVo;
import com.ai.slp.common.api.subject.param.Subject;
import com.ai.slp.common.api.subject.param.SubjectFund;
import com.ai.slp.common.api.subject.param.SubjectIdParam;
import com.ai.slp.common.api.subject.param.SubjectTypeParam;
import com.alibaba.fastjson.JSONObject;

/**
 * 从缓存中获取科目定义
 *
 * Date: 2015年10月22日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public final class FunSubjectUtil {

    private FunSubjectUtil() {
    }

    /**
     * 从缓存中获取科目，返回JSON对象 <br>
     * 缓存对象融合了FUN_SUBJECT和FUN_SUBJECT_FUND
     * 
     * @param subjectId
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    @Deprecated
    public static JSONObject getFunSubject(Long subjectId) {
        ICacheClient cacheClient = CacheFactoryUtil.getCacheClient(CacheNSMapper.CACHE_FUN_SUBJECT);
        String key = String.valueOf(subjectId);
        String data = cacheClient.hget(CacheNSMapper.CACHE_FUN_SUBJECT, key);
        return StringUtil.isBlank(data) ? new JSONObject() : JSONObject.parseObject(data);
    }

    /**
     * 从缓存中获取科目名称
     * 
     * @param subjectId
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    @Deprecated
    public static String getFunSubjectName(Long subjectId) {
        JSONObject redisData = getFunSubject(subjectId);
        if (redisData == null) {
            throw new BusinessException("109003", // TODO
                    "科目[subjectId:" + subjectId + "]");
        }
        return (String) redisData.get("subjectName");
    }

    /**
     * 从缓存种获取科目 <br>
     * 
     * @param tenantId
     * @param subjectId
     * @return 转换后的科目对象
     * @author lilg
     */
    public static SubjectVo getSubject(String tenantId, Long subjectId) {
        Subject subject = DubboUtil.getIGnSubjectQuerySV().getSubject(
                new SubjectIdParam(tenantId, subjectId));
        if (subject == null) {
            return null;
        }
        SubjectVo vo = new SubjectVo();
        BeanUtils.copyProperties(vo, subject);
        return vo;
    }

    /**
     * 按照科目类型查询科目列表 <br>
     * @param tenantId
     * @param subjectType
     * @return
     * @author lilg
     */
    public static List<SubjectVo> getSubjectByType(String tenantId, String subjectType) {
        List<Subject> subjectList = DubboUtil.getIGnSubjectQuerySV().getSubjectByType(
                new SubjectTypeParam(tenantId, subjectType));
        if(CollectionUtil.isEmpty(subjectList)){
            return new ArrayList<SubjectVo>();
        }
        List<SubjectVo> voList = new ArrayList<SubjectVo>();
        for(Subject subject:subjectList){
            SubjectVo vo = new SubjectVo();
            BeanUtils.copyProperties(vo, subject);
            voList.add(vo);
        }
        return voList;
    }

    /**
     * 从缓存中获取科目，返回对象 <br>
     * 缓存对象融合了FUN_SUBJECT和FUN_SUBJECT_FUND
     * 
     * @param tenantId
     * @param subjectId
     * @return 转换后的资金科目对象
     * @author lilg
     */
    public static SubjectFundVo getSubjectFund(String tenantId, Long subjectId) {
        SubjectFund subjectFund = DubboUtil.getIGnSubjectQuerySV().getSubjectFund(
                new SubjectIdParam(tenantId, subjectId));
        if (subjectFund == null) {
            return null;
        }
        SubjectFundVo vo = new SubjectFundVo();
        BeanUtils.copyProperties(vo, subjectFund);
        return vo;
    }

    /**
     * 从缓存中获取科目名称<br>
     * 
     * @param tenantId
     * @param subjectId
     * @return 科目名称
     * @author lilg
     */
    public static String getSubjectName(String tenantId, Long subjectId) {
        return DubboUtil.getIGnSubjectQuerySV().getSubjectName(
                new SubjectIdParam(tenantId, subjectId));
    }

}
