package com.ai.slp.balance.service.atom.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunAccountSet;

/**
 * 账户设置基础服务接口
 * Date: 2015年8月6日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author fanpw
 */
public interface IFunAccountSetAtomSV {

    public void modifyFunAccountSet(FunAccountSet param);
    
    public FunAccountSet getFunAccountSet(long accountId);
    
    /**
     * 插入账户信息表
     * @param info
     * @author limy6
     * @ApiDocMethod
     */
    public void insertFunAccountSet(FunAccountSet info);
    
}
