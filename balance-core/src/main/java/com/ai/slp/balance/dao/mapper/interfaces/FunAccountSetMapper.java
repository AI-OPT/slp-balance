package com.ai.slp.balance.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.balance.dao.mapper.bo.FunAccountSet;
import com.ai.slp.balance.dao.mapper.bo.FunAccountSetCriteria;

public interface FunAccountSetMapper {
    int countByExample(FunAccountSetCriteria example);

    int deleteByExample(FunAccountSetCriteria example);

    int deleteByPrimaryKey(Long accountId);

    int insert(FunAccountSet record);

    int insertSelective(FunAccountSet record);

    List<FunAccountSet> selectByExample(FunAccountSetCriteria example);

    FunAccountSet selectByPrimaryKey(Long accountId);

    int updateByExampleSelective(@Param("record") FunAccountSet record, @Param("example") FunAccountSetCriteria example);

    int updateByExample(@Param("record") FunAccountSet record, @Param("example") FunAccountSetCriteria example);

    int updateByPrimaryKeySelective(FunAccountSet record);

    int updateByPrimaryKey(FunAccountSet record);
}