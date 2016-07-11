package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.BillPayLog;
import com.ai.slp.balance.dao.mapper.bo.BillPayLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillPayLogMapper {
    int countByExample(BillPayLogCriteria example);

    int deleteByExample(BillPayLogCriteria example);

    int deleteByPrimaryKey(String payLogSeq);

    int insert(BillPayLog record);

    int insertSelective(BillPayLog record);

    List<BillPayLog> selectByExample(BillPayLogCriteria example);

    BillPayLog selectByPrimaryKey(String payLogSeq);

    int updateByExampleSelective(@Param("record") BillPayLog record, @Param("example") BillPayLogCriteria example);

    int updateByExample(@Param("record") BillPayLog record, @Param("example") BillPayLogCriteria example);

    int updateByPrimaryKeySelective(BillPayLog record);

    int updateByPrimaryKey(BillPayLog record);
}