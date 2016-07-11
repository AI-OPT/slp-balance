package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.BillPayDetail;
import com.ai.slp.balance.dao.mapper.bo.BillPayDetailCriteria;
import com.ai.slp.balance.dao.mapper.bo.BillPayDetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillPayDetailMapper {
    int countByExample(BillPayDetailCriteria example);

    int deleteByExample(BillPayDetailCriteria example);

    int deleteByPrimaryKey(BillPayDetailKey key);

    int insert(BillPayDetail record);

    int insertSelective(BillPayDetail record);

    List<BillPayDetail> selectByExample(BillPayDetailCriteria example);

    BillPayDetail selectByPrimaryKey(BillPayDetailKey key);

    int updateByExampleSelective(@Param("record") BillPayDetail record, @Param("example") BillPayDetailCriteria example);

    int updateByExample(@Param("record") BillPayDetail record, @Param("example") BillPayDetailCriteria example);

    int updateByPrimaryKeySelective(BillPayDetail record);

    int updateByPrimaryKey(BillPayDetail record);
}