package com.ai.slp.balance.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.balance.dao.mapper.bo.FunSubsFreeze;
import com.ai.slp.balance.dao.mapper.bo.FunSubsFreezeCriteria;

public interface FunSubsFreezeMapper {
    int countByExample(FunSubsFreezeCriteria example);

    int deleteByExample(FunSubsFreezeCriteria example);

    int deleteByPrimaryKey(Long subsFreezeId);

    int insert(FunSubsFreeze record);

    int insertSelective(FunSubsFreeze record);

    List<FunSubsFreeze> selectByExample(FunSubsFreezeCriteria example);

    FunSubsFreeze selectByPrimaryKey(Long subsFreezeId);

    int updateByExampleSelective(@Param("record") FunSubsFreeze record, @Param("example") FunSubsFreezeCriteria example);

    int updateByExample(@Param("record") FunSubsFreeze record, @Param("example") FunSubsFreezeCriteria example);

    int updateByPrimaryKeySelective(FunSubsFreeze record);

    int updateByPrimaryKey(FunSubsFreeze record);
}