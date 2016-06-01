package com.ai.slp.balance.dao.mapper.attach;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface FunFundBookAttachMapper {

    /**
     * 存款 <br>
     * 1.增加账本余额<br>
     * 2.延期账本实效时间 <br>
     * 
     * @param accountId
     * @param bookId
     * @param amount
     * @return
     * @author lilg
     */
    @Update("UPDATE fun_fund_book SET balance=balance+ #{amount} WHERE account_id = #{accountId} AND book_id = #{bookId}")
    int depositBalance(@Param("accountId") long accountId, @Param("bookId") long bookId,
            @Param("amount") long amount);

    // TODO 需要考虑延期时间

    /**
     * 扣款 <br>
     * 1.减去账本余额 <br>
     * 2.账本金额不可为负 <br>
     * 
     * @param accountId
     * @param bookId
     * @param amount
     * @return
     * @author lilg
     */
    @Update("UPDATE fun_fund_book SET balance=balance- #{amount} WHERE account_id = #{accountId} AND book_id = #{bookId} AND balance >= #{amount}")
    int deductBalance(@Param("accountId") long accountId, @Param("bookId") long bookId,
            @Param("amount") long amount);

}
