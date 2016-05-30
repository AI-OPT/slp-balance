package com.ai.runner.center.balance.dao.mapper.interfaces;

import com.ai.runner.center.balance.dao.mapper.bo.FunFundBook;
import com.ai.runner.center.balance.dao.mapper.bo.FunFundBookCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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