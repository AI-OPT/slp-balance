package com.ai.slp.balance.service.atom.interfaces;

import com.ai.slp.balance.dao.mapper.bo.FunAccountLog;

/**
 * 账户信息历史记录表
 * Date: 2015年8月7日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author fanpw
 */
public interface IFunAccountLogAtomSV {

    public void saveFunAccountLog(FunAccountLog log);
    
}
