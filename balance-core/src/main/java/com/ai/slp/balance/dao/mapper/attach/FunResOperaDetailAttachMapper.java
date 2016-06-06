package com.ai.slp.balance.dao.mapper.attach;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.ai.slp.balance.dao.mapper.bo.FunResOperaDetail;

public interface FunResOperaDetailAttachMapper{

    /**
     * 查询需要更新到账本的抵扣记录
     * 
     * @param optTypes
     * @param status
     * @param count
     * @param mod
     * @return
     * @author lilg
     */
    // @Select("SELECT * FROM fun_res_opera_detail WHERE opt_type IN (#{optType}) AND book_status = #{status} AND MOD(owner_id,#{count}) = #{mod}")
    @Select({ "<script>", "SELECT * FROM fun_res_opera_detail WHERE opt_type IN",
            "<foreach item='item' index='index' collection='optType'",
            "open='(' separator=',' close=')'>", "#{item}", "</foreach>",
            "AND book_status = #{status} AND MOD(owner_id,#{count}) = #{mod}", "</script>" })
    //1.自己编写映射
    //@Results({ @Result(id=true,column="owner_id",property="ownerId")})
    //2.使用配置文件映射
    @ResultMap("com.ai.slp.balance.dao.mapper.interfaces.FunResOperaDetailMapper.BaseResultMap")
    public List<FunResOperaDetail> getWaitDeductOpera(@Param("optType") List<Integer> optTypes,
            @Param("status") String status, @Param("count") int count, @Param("mod") int mod);
}
