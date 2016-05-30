package com.ai.runner.center.balance.dao.mapper.interfaces;

import com.ai.runner.center.balance.dao.mapper.bo.FunAccountInfoByExternalIdIdx;
import com.ai.runner.center.balance.dao.mapper.bo.FunAccountInfoByExternalIdIdxCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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