package com.ai.slp.balance.service.business.interfaces;

import java.util.List;

import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.balance.dao.mapper.bo.FunResBook;

/**
 * 账本生失效维护定时任务业务逻辑
 *
 * Date: 2015年11月24日 <br>
 * Copyright (c) 2015 asiainfo.com <br>
 * 
 * @author lilg
 */
public interface ITaskMaintainResBookBusiSV {

    /**
     * 查询即将实效或者即将生效的账本<br>
     * 用于账本生失效维护的定时任务<br>
     * 
     * @param start
     * @param end
     * @return 账本列表
     * @throws BusinessException
     * @author lilg
     */
    public List<FunResBook> queryTimeoutResBook(int start, int end) throws BusinessException;;

    /**
     * 账本生失效维护<br>
     * 用于账本生失效维护的定时任务<br>
     * 
     * @param book
     * @throws BusinessException
     * @author lilg
     */
    public void maintainResBook(FunResBook book) throws BusinessException;;
}
