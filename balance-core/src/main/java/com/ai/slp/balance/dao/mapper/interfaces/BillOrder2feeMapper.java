package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.BillOrder2fee;
import com.ai.slp.balance.dao.mapper.bo.BillOrder2feeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillOrder2feeMapper {
    int countByExample(BillOrder2feeCriteria example);

    int deleteByExample(BillOrder2feeCriteria example);

    int deleteByPrimaryKey(String productCatId);

    int insert(BillOrder2fee record);

    int insertSelective(BillOrder2fee record);

    List<BillOrder2fee> selectByExample(BillOrder2feeCriteria example);

    BillOrder2fee selectByPrimaryKey(String productCatId);

    int updateByExampleSelective(@Param("record") BillOrder2fee record, @Param("example") BillOrder2feeCriteria example);

    int updateByExample(@Param("record") BillOrder2fee record, @Param("example") BillOrder2feeCriteria example);

    int updateByPrimaryKeySelective(BillOrder2fee record);

    int updateByPrimaryKey(BillOrder2fee record);
}