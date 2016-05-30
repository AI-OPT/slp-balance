package com.ai.runner.center.balance.dao.mapper.interfaces;

import com.ai.runner.center.balance.dao.mapper.bo.FunFundSerial;
import com.ai.runner.center.balance.dao.mapper.bo.FunFundSerialCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunFundSerialMapper {
    int countByExample(FunFundSerialCriteria example);

    int deleteByExample(FunFundSerialCriteria example);

    int deleteByPrimaryKey(String paySerialCode);

    int insert(FunFundSerial record);

    int insertSelective(FunFundSerial record);

    List<FunFundSerial> selectByExample(FunFundSerialCriteria example);

    FunFundSerial selectByPrimaryKey(String paySerialCode);

    int updateByExampleSelective(@Param("record") FunFundSerial record, @Param("example") FunFundSerialCriteria example);

    int updateByExample(@Param("record") FunFundSerial record, @Param("example") FunFundSerialCriteria example);

    int updateByPrimaryKeySelective(FunFundSerial record);

    int updateByPrimaryKey(FunFundSerial record);
}