package com.ai.runner.center.balance.dao.mapper.interfaces;

import com.ai.runner.center.balance.dao.mapper.bo.FunResOperaDetail;
import com.ai.runner.center.balance.dao.mapper.bo.FunResOperaDetailCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunResOperaDetailMapper {
    int countByExample(FunResOperaDetailCriteria example);

    int deleteByExample(FunResOperaDetailCriteria example);

    int insert(FunResOperaDetail record);

    int insertSelective(FunResOperaDetail record);

    List<FunResOperaDetail> selectByExample(FunResOperaDetailCriteria example);

    int updateByExampleSelective(@Param("record") FunResOperaDetail record, @Param("example") FunResOperaDetailCriteria example);

    int updateByExample(@Param("record") FunResOperaDetail record, @Param("example") FunResOperaDetailCriteria example);
}