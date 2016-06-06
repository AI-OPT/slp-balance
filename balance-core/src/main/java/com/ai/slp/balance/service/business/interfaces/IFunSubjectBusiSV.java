package com.ai.slp.balance.service.business.interfaces;

import java.util.List;

import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.balance.dao.mapper.bo.FunSubject;
import com.ai.slp.balance.dao.mapper.bo.FunSubjectFund;

/**
 * 
 * 科目编码和科目定义业务服务<br>
 * 该类供缓存加载调用，不建议直接调用 <br>
 * Date: 2015年8月19日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IFunSubjectBusiSV {

    /**
     * 根据subjectId查询科目编码
     * 
     * @param subjectId
     * @return
     * @throws BusinessException
     * @author lilg
     * @ApiDocMethod
     */
    public List<FunSubject> queryFunSubject(long subjectId) throws BusinessException;

    /**
     * 根据subjectId查询科目定义
     * 
     * @param subjectId
     * @return
     * @throws BusinessException
     * @author lilg
     * @ApiDocMethod
     */
    public List<FunSubjectFund> queryFunSubjectFund(long subjectId) throws BusinessException;

    /**
     * 查询所有科目编码
     * 
     * @return
     * @throws BusinessException
     * @author lilg
     * @ApiDocMethod
     */
    public List<FunSubject> queryFunSubject() throws BusinessException;

    /**
     * 查询所有科目定义
     * 
     * @return
     * @throws BusinessException
     * @author lilg
     * @ApiDocMethod
     */
    public List<FunSubjectFund> queryFunSubjectFund() throws BusinessException;
}
