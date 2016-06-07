//package com.ai.slp.balance.service.atom.interfaces;
//
//import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByCustIdIdx;
//import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByExternalIdIdx;
//import com.ai.slp.balance.dao.mapper.bo.FunFundSerialByAcctIdIdx;
//
///**
// * ATS消息发送原子服务接口.<br>
// *
// * Date: 2015年8月7日 <br>
// * Copyright (c) 2015 asiainfo.com <br>
// * 
// * @author limy6
// */
//public interface IATSSenderAtomSV {
//    /**
//     * 发送 消息 ，"写入FunAccountInfoByExternalIdIdx索引表"
//     * 
//     * @param info
//     * @author limy6
//     * @ApiDocMethod
//     */
//    public void sendAtsInsertFunAccountInfoByExternalIdIdx(FunAccountInfoByExternalIdIdx info);
//
//    /**
//     * 发送消息，"写入FunAccountInfoByCustIdIdx索引表"
//     * 
//     * @param info
//     * @author limy6
//     * @ApiDocMethod
//     */
//    public void sendAtsInsertFunAccountInfoByCustIdIdx(FunAccountInfoByCustIdIdx info);
//
//    /**
//     * 发送消息，添加索引FunFundSerialByAcctIdIdx
//     * 
//     * @param idx
//     * @author lilg
//     * @ApiDocMethod
//     */
//    public void sendAtsAddFunFundSerialByAcctIdIdx(FunFundSerialByAcctIdIdx idx);
//
//}
