package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByCustIdIdx;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByCustIdIdxCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunAccountInfoByCustIdIdxMapper {
    int countByExample(FunAccountInfoByCustIdIdxCriteria example);

    int deleteByExample(FunAccountInfoByCustIdIdxCriteria example);

    int deleteByPrimaryKey(Long accountId);

    int insert(FunAccountInfoByCustIdIdx record);

    int insertSelective(FunAccountInfoByCustIdIdx record);

    List<FunAccountInfoByCustIdIdx> selectByExample(FunAccountInfoByCustIdIdxCriteria example);

    FunAccountInfoByCustIdIdx selectByPrimaryKey(Long accountId);

    int updateByExampleSelective(@Param("record") FunAccountInfoByCustIdIdx record, @Param("example") FunAccountInfoByCustIdIdxCriteria example);

    int updateByExample(@Param("record") FunAccountInfoByCustIdIdx record, @Param("example") FunAccountInfoByCustIdIdxCriteria example);

    int updateByPrimaryKeySelective(FunAccountInfoByCustIdIdx record);

    int updateByPrimaryKey(FunAccountInfoByCustIdIdx record);
}