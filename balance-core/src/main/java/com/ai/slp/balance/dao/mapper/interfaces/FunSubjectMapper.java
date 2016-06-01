package com.ai.slp.balance.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.balance.dao.mapper.bo.FunSubject;
import com.ai.slp.balance.dao.mapper.bo.FunSubjectCriteria;

public interface FunSubjectMapper {
    int countByExample(FunSubjectCriteria example);

    int deleteByExample(FunSubjectCriteria example);

    int deleteByPrimaryKey(Long subjectId);

    int insert(FunSubject record);

    int insertSelective(FunSubject record);

    List<FunSubject> selectByExample(FunSubjectCriteria example);

    FunSubject selectByPrimaryKey(Long subjectId);

    int updateByExampleSelective(@Param("record") FunSubject record, @Param("example") FunSubjectCriteria example);

    int updateByExample(@Param("record") FunSubject record, @Param("example") FunSubjectCriteria example);

    int updateByPrimaryKeySelective(FunSubject record);

    int updateByPrimaryKey(FunSubject record);
}