package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.BillCycleDef;
import com.ai.slp.balance.dao.mapper.bo.BillCycleDefCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillCycleDefMapper {
    int countByExample(BillCycleDefCriteria example);

    int deleteByExample(BillCycleDefCriteria example);

    int deleteByPrimaryKey(Integer billCycleDefId);

    int insert(BillCycleDef record);

    int insertSelective(BillCycleDef record);

    List<BillCycleDef> selectByExample(BillCycleDefCriteria example);

    BillCycleDef selectByPrimaryKey(Integer billCycleDefId);

    int updateByExampleSelective(@Param("record") BillCycleDef record, @Param("example") BillCycleDefCriteria example);

    int updateByExample(@Param("record") BillCycleDef record, @Param("example") BillCycleDefCriteria example);

    int updateByPrimaryKeySelective(BillCycleDef record);

    int updateByPrimaryKey(BillCycleDef record);
}