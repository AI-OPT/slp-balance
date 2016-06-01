package com.ai.slp.balance.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByExternalIdIdx;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByExternalIdIdxCriteria;

public interface FunAccountInfoByExternalIdIdxMapper {
    int countByExample(FunAccountInfoByExternalIdIdxCriteria example);

    int deleteByExample(FunAccountInfoByExternalIdIdxCriteria example);

    int deleteByPrimaryKey(Long accountId);

    int insert(FunAccountInfoByExternalIdIdx record);

    int insertSelective(FunAccountInfoByExternalIdIdx record);

    List<FunAccountInfoByExternalIdIdx> selectByExample(FunAccountInfoByExternalIdIdxCriteria example);

    FunAccountInfoByExternalIdIdx selectByPrimaryKey(Long accountId);

    int updateByExampleSelective(@Param("record") FunAccountInfoByExternalIdIdx record, @Param("example") FunAccountInfoByExternalIdIdxCriteria example);

    int updateByExample(@Param("record") FunAccountInfoByExternalIdIdx record, @Param("example") FunAccountInfoByExternalIdIdxCriteria example);

    int updateByPrimaryKeySelective(FunAccountInfoByExternalIdIdx record);

    int updateByPrimaryKey(FunAccountInfoByExternalIdIdx record);
}