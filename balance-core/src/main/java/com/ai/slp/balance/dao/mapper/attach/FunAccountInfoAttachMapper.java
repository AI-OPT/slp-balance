package com.ai.slp.balance.dao.mapper.attach;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface FunAccountInfoAttachMapper {

    /**
     * 增加账户余额
     * 
     * @param accountId
     * @param amount
     * @return
     * @author lilg
     */
    @Update("UPDATE fun_account_info SET total_balance = total_balance+ #{amount} WHERE account_id = #{accountId}")
    int addBalance(@Param("accountId") long accountId, @Param("amount") long amount);
}
