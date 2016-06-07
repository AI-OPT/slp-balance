package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunAccountInfo;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunAccountInfoMapper {
    int countByExample(FunAccountInfoCriteria example);

    int deleteByExample(FunAccountInfoCriteria example);

    int deleteByPrimaryKey(Long accountId);

    int insert(FunAccountInfo record);

    int insertSelective(FunAccountInfo record);

    List<FunAccountInfo> selectByExample(FunAccountInfoCriteria example);

    FunAccountInfo selectByPrimaryKey(Long accountId);

    int updateByExampleSelective(@Param("record") FunAccountInfo record, @Param("example") FunAccountInfoCriteria example);

    int updateByExample(@Param("record") FunAccountInfo record, @Param("example") FunAccountInfoCriteria example);

    int updateByPrimaryKeySelective(FunAccountInfo record);

    int updateByPrimaryKey(FunAccountInfo record);
}