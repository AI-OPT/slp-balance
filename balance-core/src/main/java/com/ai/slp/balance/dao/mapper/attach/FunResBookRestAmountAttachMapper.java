package com.ai.slp.balance.dao.mapper.attach;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface FunResBookRestAmountAttachMapper {
    /**
     * 资源量偏移
     * 
     * @param tenantId
     * @param ownerId
     * @param ownerType
     * @param resourceType
     * @param offset
     * @return 数据库更改行数
     * @author lilg
     */
    @Update("UPDATE fun_res_book_rest_amount SET rest_amount = rest_amount + #{offset},last_update_time = sysdate() "
            + "WHERE tenant_id = #{tenantId} AND owner_id = #{ownerId}  AND owner_type= #{ownerType} AND resource_type=#{resourceType} ")
    int offsetAmount(@Param("tenantId") String tenantId, @Param("ownerId") long ownerId,
            @Param("ownerType") int ownerType, @Param("resourceType") int resourceType,
            @Param("offset") BigDecimal offset);
}
