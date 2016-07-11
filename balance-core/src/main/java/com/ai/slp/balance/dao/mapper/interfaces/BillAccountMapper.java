package com.ai.slp.balance.dao.mapper.interfaces;

import com.ai.slp.balance.dao.mapper.bo.BillAccount;
import com.ai.slp.balance.dao.mapper.bo.BillAccountCriteria;
import com.ai.slp.balance.dao.mapper.bo.BillAccountKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillAccountMapper {
    int countByExample(BillAccountCriteria example);

    int deleteByExample(BillAccountCriteria example);

    int deleteByPrimaryKey(BillAccountKey key);

    int insert(BillAccount record);

    int insertSelective(BillAccount record);

    List<BillAccount> selectByExample(BillAccountCriteria example);

    BillAccount selectByPrimaryKey(BillAccountKey key);

    int updateByExampleSelective(@Param("record") BillAccount record, @Param("example") BillAccountCriteria example);

    int updateByExample(@Param("record") BillAccount record, @Param("example") BillAccountCriteria example);

    int updateByPrimaryKeySelective(BillAccount record);

    int updateByPrimaryKey(BillAccount record);
}