package com.ai.slp.balance.service.atom.interfaces;

import java.util.List;

import com.ai.slp.balance.dao.mapper.bo.FunFundBook;

public interface IFunFundBookAtomSV {

    /**
     * 账本查询，通过账户ID，账本ID<br>
     * 注：账本ID是主键，但不是分区字段，因此仍需要账户ID
     * 
     * @param tenantId
     * @param accountId
     * @param bookId
     * @return
     * @author lilg
     */
    public FunFundBook getBean(String tenantId, long accountId, long bookId);

    /**
     * 账本查询，根据账户ID,账本状态[1有效 0无效 2冻结]
     * 
     * @param tenantId
     * @param accountId
     * @param status
     * @return
     * @author lilg
     */
    public List<FunFundBook> getBeans(String tenantId, long accountId, List<String> status);

    /**
     * 账本查询，根据账户ID,科目ID,账本状态
     * 
     * @param tenantId
     * @param accountId
     * @param SubjectId
     * @param status
     * @return
     * @author lilg
     */
    public List<FunFundBook> getBeans(String tenantId, long accountId, List<String> status,
            Long subjectId);

    /**
     * 账本查询，根据账户ID,账本类型,账本状态
     * 
     * @param tenantId
     * @param accountId
     * @param fundType
     * @param status
     * @return
     * @author lilg
     */
    public List<FunFundBook> getBeans(String tenantId, long accountId, List<String> fundType,
            List<String> status);

    /**
     * 有效账本查询，根据账户ID
     * 
     * @param accountId
     * @return
     * @author lilg
     */
    public List<FunFundBook> getValidFundBooks(String tenantId, long accountId);

    /**
     * 冻结账本查询，根据账户ID
     * 
     * @param accountId
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public List<FunFundBook> getFreezeFundBooks(String tenantId, long accountId);

    /**
     * 有效账本查询，通过账本ID
     * 
     * @param tenantId
     * @param accountId
     * @param bookId
     * @return
     * @author lilg
     */
    public FunFundBook getValidFundBookByBookID(String tenantId, long accountId, long bookId);

    /**
     * 有效账本查询，根据科目类型
     * 
     * @param tenantId
     * @param accountId
     * @param subjectType
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public List<FunFundBook> getValidFundBooksByFundType(String tenantId, long accountId,
            List<String> fundType);

    /**
     * 用户有效账本查询(subsId=0为非用户专款)，根据科目类型
     * 
     * @param accountId
     * @param subjectType
     * @return
     * @author lilg
     */
    public List<FunFundBook> getSubsValidFundBooksByFundType(String tenantId, long accountId,
            List<String> fundType, long subsId);

    /**
     * 有效账本查询，根据科目ID
     * 
     * @param accountId
     * @param subjectId
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public List<FunFundBook> getValidFundBooksBySubjectId(String tenantId, long accountId,
            long subjectId);

    /**
     * 用户有效账本查询(subsId=0为非用户专款)，根据科目ID
     * 
     * @param accountId
     * @param subjectId
     * @return
     * @author lilg
     */
    public List<FunFundBook> getSubsValidFundBooksBySubjectId(String tennatId, long accountId,
            long subjectId, long subsId);

    /**
     * 向 FunFundBook表插入一条数据
     * 
     * @param info
     * @author limy6
     * @ApiDocMethod
     */
    public void insertFunFundBook(FunFundBook info);

    /**
     * 按照主键更新赋值字段
     * 
     * @param info
     * @author lilg
     */
    public void updateByPrimaryKeySelective(FunFundBook info);

    /**
     * 
     * 给指定账本增加金额,并修改有效期 <br>
     * 返回修改记录数 <br>
     * 
     * @param accountId
     * @param bookId
     * @param amount
     * @return
     * @author lilg
     */
    public int depositBalance(long accountId, long bookId, long amount);

    /**
     * 从指定账本扣除金额，金额不可为负<br>
     * 返回修改记录数 <br>
     * 
     * @param accountId
     * @param bookId
     * @param amount
     * @return
     * @author lilg
     */
    public int deductBalance(long accountId, long bookId, long amount);
    /**
     * 根据租户id、账户id、资金类型、科目id 查询账本信息
     * @param accountId
     * @param tenantId
     * @param fundType
     * @param subjectId
     * @return
     * @author zhangzd
     * @ApiDocMethod
     * @ApiCode
     */
    public FunFundBook findFunFundBook(Long accountId,String tenantId,String fundType,Long subjectId);
}
