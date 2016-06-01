package com.ai.slp.balance.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.balance.dao.mapper.bo.FunResBook;
import com.ai.slp.balance.dao.mapper.bo.FunResBookCriteria;

public interface FunResBookMapper {
    int countByExample(FunResBookCriteria example);

    int deleteByExample(FunResBookCriteria example);

    int deleteByPrimaryKey(Long bookId);

    int insert(FunResBook record);

    int insertSelective(FunResBook record);

    List<FunResBook> selectByExample(FunResBookCriteria example);

    FunResBook selectByPrimaryKey(Long bookId);

    int updateByExampleSelective(@Param("record") FunResBook record, @Param("example") FunResBookCriteria example);

    int updateByExample(@Param("record") FunResBook record, @Param("example") FunResBookCriteria example);

    int updateByPrimaryKeySelective(FunResBook record);

    int updateByPrimaryKey(FunResBook record);
}