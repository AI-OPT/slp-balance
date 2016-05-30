package com.ai.runner.center.balance.dao.mapper.interfaces;

import com.ai.runner.center.balance.dao.mapper.bo.FunSubsFreeze;
import com.ai.runner.center.balance.dao.mapper.bo.FunSubsFreezeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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