package com.ai.slp.balance.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.balance.dao.mapper.bo.FunFundBook;
import com.ai.slp.balance.dao.mapper.bo.FunFundBookCriteria;

public interface FunFundBookMapper {
    int countByExample(FunFundBookCriteria example);

    int deleteByExample(FunFundBookCriteria example);

    int deleteByPrimaryKey(Long bookId);

    int insert(FunFundBook record);

    int insertSelective(FunFundBook record);

    List<FunFundBook> selectByExample(FunFundBookCriteria example);

    FunFundBook selectByPrimaryKey(Long bookId);

    int updateByExampleSelective(@Param("record") FunFundBook record, @Param("example") FunFundBookCriteria example);

    int updateByExample(@Param("record") FunFundBook record, @Param("example") FunFundBookCriteria example);

    int updateByPrimaryKeySelective(FunFundBook record);

    int updateByPrimaryKey(FunFundBook record);
}