package com.ai.runner.center.balance.dao.mapper.interfaces;

import com.ai.runner.center.balance.dao.mapper.bo.FunFundDetail;
import com.ai.runner.center.balance.dao.mapper.bo.FunFundDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunFundDetailMapper {
    int countByExample(FunFundDetailCriteria example);

    int deleteByExample(FunFundDetailCriteria example);

    int deleteByPrimaryKey(String serialCode);

    int insert(FunFundDetail record);

    int insertSelective(FunFundDetail record);

    List<FunFundDetail> selectByExample(FunFundDetailCriteria example);

    FunFundDetail selectByPrimaryKey(String serialCode);

    int updateByExampleSelective(@Param("record") FunFundDetail record, @Param("example") FunFundDetailCriteria example);

    int updateByExample(@Param("record") FunFundDetail record, @Param("example") FunFundDetailCriteria example);

    int updateByPrimaryKeySelective(FunFundDetail record);

    int updateByPrimaryKey(FunFundDetail record);
}