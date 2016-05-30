package com.ai.runner.center.balance.ats.interfaces;

import com.ai.runner.center.balance.dao.mapper.bo.FunAccountInfoByCustIdIdx;
import com.ai.runner.center.balance.dao.mapper.bo.FunAccountInfoByExternalIdIdx;


public interface IAccountIndexTableSV {

    public void insertFunAccountInfoByExternalIdIdx(FunAccountInfoByExternalIdIdx vo);
    public void insertFunAccountInfoByCustIdIdx(FunAccountInfoByCustIdIdx vo);
}
