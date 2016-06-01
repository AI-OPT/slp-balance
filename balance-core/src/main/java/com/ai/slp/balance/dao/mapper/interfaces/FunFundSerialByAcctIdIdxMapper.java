package com.ai.slp.balance.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.balance.dao.mapper.bo.FunFundSerialByAcctIdIdx;
import com.ai.slp.balance.dao.mapper.bo.FunFundSerialByAcctIdIdxCriteria;

public interface FunFundSerialByAcctIdIdxMapper {
    int countByExample(FunFundSerialByAcctIdIdxCriteria example);

    int deleteByExample(FunFundSerialByAcctIdIdxCriteria example);

    int insert(FunFundSerialByAcctIdIdx record);

    int insertSelective(FunFundSerialByAcctIdIdx record);

    List<FunFundSerialByAcctIdIdx> selectByExample(FunFundSerialByAcctIdIdxCriteria example);

    int updateByExampleSelective(@Param("record") FunFundSerialByAcctIdIdx record, @Param("example") FunFundSerialByAcctIdIdxCriteria example);

    int updateByExample(@Param("record") FunFundSerialByAcctIdIdx record, @Param("example") FunFundSerialByAcctIdIdxCriteria example);
}