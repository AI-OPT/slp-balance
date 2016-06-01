package com.ai.slp.balance.service.atom.interfaces;

import java.util.List;

import com.ai.slp.balance.dao.mapper.bo.FunFundBook;
import com.ai.slp.balance.dao.mapper.bo.FunSubsFreeze;

public interface IFunSubsFreezeAtomSV {
    /**
     * 通过账户ID和转兑ID查询转兑
     * @param accountId
     * @param subsFreezeIds
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public List<FunSubsFreeze> getFunSubsFreeze(long accountId,List<Long> subsFreezeIds);
    
    /**
     * 通过冻结账本查询转兑
     * @param funFundBokList
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    public List<FunSubsFreeze> getFunSubsFreeze(List<FunFundBook> funFundBokList);
    
}
