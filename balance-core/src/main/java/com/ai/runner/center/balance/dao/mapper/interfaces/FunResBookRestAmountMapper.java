package com.ai.runner.center.balance.dao.mapper.interfaces;

import com.ai.runner.center.balance.dao.mapper.bo.FunResBookRestAmount;
import com.ai.runner.center.balance.dao.mapper.bo.FunResBookRestAmountCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunResBookRestAmountMapper {
    int countByExample(FunResBookRestAmountCriteria example);

    int deleteByExample(FunResBookRestAmountCriteria example);

    int insert(FunResBookRestAmount record);

    int insertSelective(FunResBookRestAmount record);

    List<FunResBookRestAmount> selectByExample(FunResBookRestAmountCriteria example);

    int updateByExampleSelective(@Param("record") FunResBookRestAmount record, @Param("example") FunResBookRestAmountCriteria example);

    int updateByExample(@Param("record") FunResBookRestAmount record, @Param("example") FunResBookRestAmountCriteria example);
}