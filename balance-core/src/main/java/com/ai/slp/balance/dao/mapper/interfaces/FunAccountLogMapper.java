package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunAccountLog;
import com.ai.slp.balance.dao.mapper.bo.FunAccountLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunAccountLogMapper {
    int countByExample(FunAccountLogCriteria example);

    int deleteByExample(FunAccountLogCriteria example);

    int insert(FunAccountLog record);

    int insertSelective(FunAccountLog record);

    List<FunAccountLog> selectByExample(FunAccountLogCriteria example);

    int updateByExampleSelective(@Param("record") FunAccountLog record, @Param("example") FunAccountLogCriteria example);

    int updateByExample(@Param("record") FunAccountLog record, @Param("example") FunAccountLogCriteria example);
}