package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoLog;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunAccountInfoLogMapper {
    int countByExample(FunAccountInfoLogCriteria example);

    int deleteByExample(FunAccountInfoLogCriteria example);

    int insert(FunAccountInfoLog record);

    int insertSelective(FunAccountInfoLog record);

    List<FunAccountInfoLog> selectByExample(FunAccountInfoLogCriteria example);

    int updateByExampleSelective(@Param("record") FunAccountInfoLog record, @Param("example") FunAccountInfoLogCriteria example);

    int updateByExample(@Param("record") FunAccountInfoLog record, @Param("example") FunAccountInfoLogCriteria example);
}