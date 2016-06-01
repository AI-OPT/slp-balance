package com.ai.slp.balance.dao.mapper.attach;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface FunResBookAttachMapper {

    /**
     * 更新账本<b>状态</b> (加版本号)
     * 
     * @param status
     * @param bookId
     * @param version
     * @return
     * @author lilg
     */
    @Update("UPDATE fun_res_book SET book_status = #{status},use_version=use_version+1 WHERE book_id = #{bookId} AND use_version = #{version} ")
    int updateStatus(@Param("status") String status, @Param("bookId") long bookId,
            @Param("version") long version);

    /**
     * 更新账本<b>状态</b>和<b>抵扣额</b> (加版本号)
     * 
     * @param deductAmount
     * @param status
     * @param bookId
     * @param version
     * @return
     * @author lilg
     */
    @Update("UPDATE fun_res_book SET deduct_amount= #{deductAmount} ,book_status = #{status},use_version=use_version+1 WHERE book_id = #{bookId} AND use_version = #{version} ")
    int updateDeduct(@Param("deductAmount") BigDecimal deductAmount, @Param("status") String status,
            @Param("bookId") long bookId, @Param("version") long version);

    /**
     * 更新账本<b>状态</b>和<b>生失效时间</b> (加版本号)
     * 
     * @param effectTime
     * @param expireTime
     * @param status
     * @param bookId
     * @param version
     * @return
     * @author lilg
     */
    @Update("UPDATE fun_res_book SET effect_time = #{effectTime}, expire_time = #{expireTime} ,book_status = #{status} ,use_version=use_version+1 WHERE book_id = #{bookId} AND use_version = #{version} ")
    int updateTime(@Param("effectTime") Timestamp effectTime,
            @Param("expireTime") Timestamp expireTime, @Param("status") String status,
            @Param("bookId") long bookId, @Param("version") long version);

}
