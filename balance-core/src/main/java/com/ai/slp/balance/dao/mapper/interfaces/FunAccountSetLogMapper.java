package com.ai.slp.balance.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.balance.dao.mapper.bo.FunAccountSetLog;
import com.ai.slp.balance.dao.mapper.bo.FunAccountSetLogCriteria;

public interface FunAccountSetLogMapper {
    int countByExample(FunAccountSetLogCriteria example);

    int deleteByExample(FunAccountSetLogCriteria example);

    int insert(FunAccountSetLog record);

    int insertSelective(FunAccountSetLog record);

    List<FunAccountSetLog> selectByExample(FunAccountSetLogCriteria example);

    int updateByExampleSelective(@Param("record") FunAccountSetLog record, @Param("example") FunAccountSetLogCriteria example);

    int updateByExample(@Param("record") FunAccountSetLog record, @Param("example") FunAccountSetLogCriteria example);
}