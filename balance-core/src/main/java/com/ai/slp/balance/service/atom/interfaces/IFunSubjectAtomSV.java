package com.ai.slp.balance.service.atom.interfaces;

import java.util.List;

import com.ai.slp.balance.dao.mapper.bo.FunSubject;
import com.ai.slp.balance.dao.mapper.bo.FunSubjectFund;

/**
 * 科目编码和科目定义 原子服务 Date: 2015年8月19日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface IFunSubjectAtomSV {
    /**
     * 根据subjectId查询科目编码
     * 
     * @param subjectId
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public List<FunSubject> queryFunSubject(long subjectId);

    /**
     * 根据subjectId查询科目定义
     * 
     * @param subjectId
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public List<FunSubjectFund> queryFunSubjectFund(long subjectId);

    /**
     * 查询所有科目编码
     * 
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public List<FunSubject> queryFunSubject();

    /**
     * 查询所有科目定义
     * 
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public List<FunSubjectFund> queryFunSubjectFund();
}
