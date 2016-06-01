package com.ai.slp.balance.ats.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByCustIdIdx;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByExternalIdIdx;


public interface IAccountIndexTableSV {

    public void insertFunAccountInfoByExternalIdIdx(FunAccountInfoByExternalIdIdx vo);
    public void insertFunAccountInfoByCustIdIdx(FunAccountInfoByCustIdIdx vo);
}
