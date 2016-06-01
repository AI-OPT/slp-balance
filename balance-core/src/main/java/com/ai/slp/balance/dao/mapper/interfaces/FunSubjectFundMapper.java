package com.ai.slp.balance.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.balance.dao.mapper.bo.FunSubjectFund;
import com.ai.slp.balance.dao.mapper.bo.FunSubjectFundCriteria;

public interface FunSubjectFundMapper {
    int countByExample(FunSubjectFundCriteria example);

    int deleteByExample(FunSubjectFundCriteria example);

    int deleteByPrimaryKey(Long subjectId);

    int insert(FunSubjectFund record);

    int insertSelective(FunSubjectFund record);

    List<FunSubjectFund> selectByExample(FunSubjectFundCriteria example);

    FunSubjectFund selectByPrimaryKey(Long subjectId);

    int updateByExampleSelective(@Param("record") FunSubjectFund record, @Param("example") FunSubjectFundCriteria example);

    int updateByExample(@Param("record") FunSubjectFund record, @Param("example") FunSubjectFundCriteria example);

    int updateByPrimaryKeySelective(FunSubjectFund record);

    int updateByPrimaryKey(FunSubjectFund record);
}