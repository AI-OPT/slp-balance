package com.ai.slp.balance.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.balance.dao.mapper.bo.FunResOperaDetail;
import com.ai.slp.balance.dao.mapper.bo.FunResOperaDetailCriteria;

public interface FunResOperaDetailMapper {
    int countByExample(FunResOperaDetailCriteria example);

    int deleteByExample(FunResOperaDetailCriteria example);

    int insert(FunResOperaDetail record);

    int insertSelective(FunResOperaDetail record);

    List<FunResOperaDetail> selectByExample(FunResOperaDetailCriteria example);

    int updateByExampleSelective(@Param("record") FunResOperaDetail record, @Param("example") FunResOperaDetailCriteria example);

    int updateByExample(@Param("record") FunResOperaDetail record, @Param("example") FunResOperaDetailCriteria example);
}