package com.ai.slp.balance.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.balance.dao.mapper.bo.FunResBookRestAmount;
import com.ai.slp.balance.dao.mapper.bo.FunResBookRestAmountCriteria;

public interface FunResBookRestAmountMapper {
    int countByExample(FunResBookRestAmountCriteria example);

    int deleteByExample(FunResBookRestAmountCriteria example);

    int insert(FunResBookRestAmount record);

    int insertSelective(FunResBookRestAmount record);

    List<FunResBookRestAmount> selectByExample(FunResBookRestAmountCriteria example);

    int updateByExampleSelective(@Param("record") FunResBookRestAmount record, @Param("example") FunResBookRestAmountCriteria example);

    int updateByExample(@Param("record") FunResBookRestAmount record, @Param("example") FunResBookRestAmountCriteria example);
}