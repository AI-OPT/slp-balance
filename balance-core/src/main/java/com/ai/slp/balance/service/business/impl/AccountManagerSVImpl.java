package com.ai.slp.balance.service.business.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.BeanUtils;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.accountmaintain.param.AccountUpdateParam;
import com.ai.slp.balance.api.accountmaintain.param.RegAccReq;
import com.ai.slp.balance.api.accountquery.param.AccountInfoVo;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.constants.SeqConstants;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfo;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByCustIdIdx;
import com.ai.slp.balance.dao.mapper.bo.FunAccountInfoByExternalIdIdx;
import com.ai.slp.balance.dao.mapper.bo.FunAccountLog;
import com.ai.slp.balance.dao.mapper.bo.FunAccountSet;
import com.ai.slp.balance.dao.mapper.bo.FunAccountSetLog;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountInfoAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountLogAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountSetAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunAccountSetLogAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunFundBookAtomSV;
import com.ai.slp.balance.service.business.interfaces.IAccountManagerSV;

@Service
@Transactional
public class AccountManagerSVImpl implements IAccountManagerSV {

    private static final Logger LOG = LogManager.getLogger(AccountManagerSVImpl.class);

    @Autowired
    private IFunAccountInfoAtomSV funAccountInfoSV;

    @Autowired
    private IFunAccountSetAtomSV funAccountSetSV;

    @Autowired
    private IFunAccountLogAtomSV funAccountLogSV;

    @Autowired
    private IFunAccountSetLogAtomSV funAccountSetLogSV;

    @Autowired
    private IFunFundBookAtomSV funFundBookSV;

//    @Autowired
//    private IATSSenderAtomSV iATSSSenderAtomSV;

    @Override
    public long createAccount(RegAccReq regAccReq) throws BusinessException {
        /* 一、做幂等性校验---查询账户索引表；如果结果非空，则直接返回"账户已创建" */
        // 根据 系统ID 和 外部流水ID 查询索引表
        List<FunAccountInfoByExternalIdIdx> list = funAccountInfoSV.getBeanByExternalIdSystemId(
                regAccReq.getExternalId(), regAccReq.getSystemId());
        if (!CollectionUtil.isEmpty(list)) {
            LOG.debug("索引表不为空");
            // return -1;// 返回 -1，表示 创建账户 的请求已经发送。
            return list.get(0).getAccountId();
        } else {
            LOG.debug("索引表为空");
        }
        /* 二、创建账户 */
        LOG.debug("开始生成账户ID");
        Long newAccountId = SeqUtil.getNewId(SeqConstants.FUN_ACCOUNT_INFO$ACCOUNT_ID);
        LOG.debug("开始写入FunAccountInfo表");
        this.createFunAccountInfo(newAccountId, regAccReq);
        LOG.debug("开始写入FunAccountSet表");
        this.createFunAccountSet(newAccountId, regAccReq);
        /*
         * 暂时不创建默认账本 LOG.debug("开始生成账本ID"); long newBookId =
         * SeqUtil.getNewId(SeqConstants.FUN_FUND_BOOK$BOOK_ID); LOG.debug("开始写入FunFundBook表");
         * this.createFunFundBook(newAccountId, newBookId, regAccReq);
         */
        /* 四、返回结果 --- 返回创建账户的ID信息 */
        LOG.debug("创建账户成功");
        /* 五、写入 账户的 两张索引表 FunAccountInfoByExternalIdIdx 和 FunAccountInfoByCustIdIdx */
//        if (!StringUtil.isBlank(regAccReq.getExternalId())
//                && !StringUtil.isBlank(regAccReq.getSystemId())) {
//            FunAccountInfoByExternalIdIdx info = new FunAccountInfoByExternalIdIdx();
//            BeanUtils.copyProperties(info, regAccReq);
//            info.setAccountId(newAccountId);
////            iATSSSenderAtomSV.sendAtsInsertFunAccountInfoByExternalIdIdx(info);
//        }
//        if (!StringUtil.isBlank(regAccReq.getRegCustomerId())) {
//            FunAccountInfoByCustIdIdx info = new FunAccountInfoByCustIdIdx();
//            info.setTenantId(regAccReq.getTenantId());
//            info.setCustId(Long.parseLong(regAccReq.getRegCustomerId()));
//            info.setAccountId(newAccountId);
////            iATSSSenderAtomSV.sendAtsInsertFunAccountInfoByCustIdIdx(info);
//        }
        
        return newAccountId;
    }

    /**
     * 4. 创建默认的普通预存款账本（科目ID100000），插入到FUN_FUND_BOOK，余额0， 生效时间是sysdate，失效时间为系统设置的无限大（例如2099-01-01）。
     * 
     * @param newAccountId
     * @param regAccReq
     * @author Administrator
     * @return bookId --- 账本ID， 账户内 账本的顺序编号，使用序列生成
     * @ApiDocMethod
     */
    /*
     * private long createFunFundBook(long newAccountId, long newBookId, RegAccReq regAccReq) { //
     * 初始化 funFundBook 账本对象 FunFundBook vo = new FunFundBook(); vo.setAccountId(newAccountId); //
     * 账户ID vo.setTenantId(regAccReq.getTenantId());// 租户ID vo.setBookId(newBookId); // 账本ID ---
     * 通过序列生成 的 vo.setSubjectId(100000L); // 资金科目 --- 默认 100000 vo.setBalance(0L); // 账本余额 --- 默认 0
     * vo.setFeatureCode(null); // 特征码， 参数中没有，置为 空 vo.setBookStatus("1"); // 账本状态 '1：有效 0：无效 2：冻结'
     * vo.setEffectDate(DateUtil.getTimestamp("2014-02-01"));// 生效日期
     * vo.setExpireDate(DateUtil.getTimestamp("2099-12-31"));// 失效日期
     * vo.setCreateTime(DateUtil.getSysDate());// 创建时间 vo.setSubsId(Long.valueOf(0)); SubjectFundVo
     * subject = FunSubjectUtil.getSubjectFund(regAccReq.getTenantId(), 100000L); if (subject ==
     * null || StringUtil.isBlank(subject.getFundType())) { throw new
     * BusinessException(ExceptCodeConstants.Subject.SUBJECT_NOT_FOUND, "缓存读取失败，没有找到科目"); }
     * vo.setSubjectType(subject.getFundType()); // 将对象插入 fun_fund_book 表
     * funFundBookSV.insertFunFundBook(vo); // 将 账本ID 返回 return newBookId; }
     */
    /**
     * 3. 将账户ID、注册方式、客户编号、渠道编号、注册邮箱、身份证号码、 身份证姓名、身份证出生年月日、身份证地址、身份证是否验证、身份证有效期、短信校验服务、
     * 绑定手机号、查询密码、支付密码是否验证、支付密码写入FUN_ACCOUNT_SET表。
     * 
     * @param newAccountId
     * @param regAccReq
     * @author Administrator
     * @ApiDocMethod
     */
    private void createFunAccountSet(long newAccountId, RegAccReq regAccReq) {
        // 初始化 funAccountSet 对象
        FunAccountSet vo = new FunAccountSet();
        if (!(newAccountId == -1)) {
            vo.setAccountId(newAccountId); // 账户ID
        }
        if (!StringUtil.isBlank(regAccReq.getTenantId())) {
            vo.setTenantId(regAccReq.getTenantId());// 租户ID
        }
        if (!StringUtil.isBlank(regAccReq.getRegType())) {
            vo.setRegType(String.valueOf(regAccReq.getRegType()));// 注册方式
        }
        if (!StringUtil.isBlank(regAccReq.getRegCustomerId())) {
            vo.setRegCustomerId(regAccReq.getRegCustomerId());// 注册客户编号
        }
        if (!StringUtil.isBlank(regAccReq.getChnlId())) {
            vo.setRegChnlId(regAccReq.getChnlId()); // 注册渠道编号
        }
        if (!StringUtil.isBlank(regAccReq.getRegEmail())) {
            vo.setRegEmail(regAccReq.getRegEmail()); // 注册邮箱
        }
        if (!StringUtil.isBlank(regAccReq.getLoginPassword())) {
            vo.setLoginPassword(regAccReq.getLoginPassword()); // 查询密码
        }
        if (!StringUtil.isBlank(regAccReq.getPayCheck())) {
            vo.setPayCheck(String.valueOf(regAccReq.getPayCheck()));// 支付密码是否验证
        }
        if (!StringUtil.isBlank(regAccReq.getPayPassword())) {
            vo.setPayPassword(regAccReq.getPayPassword()); // 支付密码
        }
        // 将对象插入 fun_account_set 表
        funAccountSetSV.insertFunAccountSet(vo);
    }

    /**
     * 2. 将账户名称、账单邮寄方式、账单地址写入FUN_ACCOUNT_INFO表，信用额度相关信息全部填0。
     * 
     * @param newAccountId
     * @param regAccReq
     * @author Administrator
     * @ApiDocMethod
     */
    private void createFunAccountInfo(long newAccountId, RegAccReq regAccReq) {
        // 初始化 funAccountInfo对象
        FunAccountInfo vo = new FunAccountInfo();
        vo.setExternalId(regAccReq.getExternalId());// 外部流水号ID
        vo.setSystemId(regAccReq.getSystemId());// 系统ID
        vo.setAccountId(newAccountId); // 账户ID
        vo.setTenantId(regAccReq.getTenantId());// 租户ID
        vo.setAcctName(regAccReq.getAcctName());// 账户名称
        vo.setCustId(regAccReq.getRegCustomerId()); // 客户ID
        vo.setAcctType(regAccReq.getAcctType());// 账户类型
        vo.setPayType(regAccReq.getPayType()); // 付款方式
        vo.setPostType(String.valueOf(regAccReq.getAcctMailType())); // 账单邮寄方式
        vo.setAcctAddr(regAccReq.getAcctAddr());// 账单地址
        vo.setEmail(regAccReq.getRegEmail()); // 电子邮件
        vo.setTotalBalance(0L); // 账户余额，默认 为 0
        vo.setCredit(0L); // 信用额度，默认 为 0
        vo.setTempCredit(0L); // 临时信用额度，默认为 0
        vo.setTempValidTime(null); // 临时信用额度有效期，默认 null
        vo.setdTotQuota(0L); // 每天消费总额度，默认 为 0
        vo.setdSigQuota(0L); // 每天消费单笔上限，默认 为 0
        vo.setdTransQuota(0L); // 每天体现/转账上限，默认 为 0
        vo.setAcctStatus("1"); // '0：无效 1：有效 2：冻结'; 写成 1
        vo.setBalanceChgDate(null); // 账户资金最后变更时间，默认 null
        vo.setCreateTime(new Timestamp(System.currentTimeMillis()));// 账户创建时间
        vo.setRemark(null); // 备注，默认 为 null

        // 将对象插入 fun_account_info 表
        funAccountInfoSV.insertFunAccountInfo(vo);
    }

    /**
     * 更新账户设置
     */
    @Override
    public void updateAccount(AccountUpdateParam param) throws BusinessException {
        LOG.info("开始更新账户设置");
        /* 1. 校验账户信息是否存在 */
        long acctId = param.getAcctId();
        FunAccountInfo accountInfo = this.funAccountInfoSV.getBeanByPrimaryKey(acctId);
        if (accountInfo == null) {
            throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_NOT_FOUND,
                    "未找到指定账户信息，账户id:[" + acctId + "]");
        }

        FunAccountSet accountSetInfo = this.funAccountSetSV.getFunAccountSet(acctId);
        if (accountSetInfo == null) {
            throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_NOT_FOUND,
                    "未找到指定账户设置信息,账户id:[" + acctId + "]");
        }

        /* 2. 校验账户设置信息 */
        if (!StringUtil.isBlank(param.getTempValidTime())
                && !DateUtil.isValidDate(param.getTempValidTime(), DateUtil.YYYYMMDD)) {
            throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_SET_INFO_CHECK_FAILED,
                    "账户设置资料验证失败:临时信用额度有效期格式不正确");
        }

        if (param.getPayCheck() != null && param.getPayCheck().intValue() == 1
                && StringUtil.isBlank(param.getPayPassword())) {
            throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_SET_INFO_CHECK_FAILED,
                    "账户设置资料验证失败:支付密码验证开通后需设置新的支付密码");
        }

        /* 3. 存放当前信息到账户设置历史表 */
        Timestamp sysDate = DateUtil.getSysDate();
        FunAccountLog accountLog = new FunAccountLog();
        BeanUtils.copyProperties(accountLog, accountInfo);
        accountLog.setUpdateTime(sysDate);
        this.funAccountLogSV.saveFunAccountLog(accountLog);

        FunAccountSetLog accountSetLog = new FunAccountSetLog();
        BeanUtils.copyProperties(accountSetLog, accountSetInfo);
        accountSetLog.setLastUpdateOperId(param.getOperId());
        accountSetLog.setLastUpdateDate(sysDate);
        this.funAccountSetLogSV.saveFunAccountSetLog(accountSetLog);

        /* 4. 更新设置信息 */
        this.updateFunAccountInfo(param);
        this.updateFunAccountSet(param);
        LOG.info("更新账户设置成功");
    }

    /**
     * 更新账户信息表
     * 
     * @param param
     * @author fanpw
     * @ApiDocMethod
     */
    private void updateFunAccountInfo(AccountUpdateParam param) {
        FunAccountInfo accountUpdateInfo = new FunAccountInfo();
        accountUpdateInfo.setAccountId(param.getAcctId());
        accountUpdateInfo.setAcctName(param.getAcctName());
        accountUpdateInfo.setAcctAddr(param.getAcctAddr());
        accountUpdateInfo.setEmail(param.getEmail());
        if (param.getAcctMailType() != null) {
            accountUpdateInfo.setPostType(param.getAcctMailType().toString());
        }

        if (!StringUtil.isBlank(param.getTempValidTime())) {
            accountUpdateInfo.setTempValidTime(DateUtil.getTimestamp(param.getTempValidTime(),
                    DateUtil.YYYYMMDD));
        }

        if (param.getAcctStatus() != null) {
            accountUpdateInfo.setAcctStatus(param.getAcctStatus().toString());
        }
        accountUpdateInfo.setCredit(param.getCredit());
        accountUpdateInfo.setTempCredit(param.getTempCredit());
        accountUpdateInfo.setdTotQuota(param.getdTotQuota());
        accountUpdateInfo.setdSigQuota(param.getdSigQuota());
        accountUpdateInfo.setdTransQuota(param.getdTransQuota());
        this.funAccountInfoSV.updateFunAccountInfo(accountUpdateInfo);
    }

    /**
     * 更新账户设置表
     * 
     * @param param
     * @author fanpw
     * @ApiDocMethod
     */
    private void updateFunAccountSet(AccountUpdateParam param) {
        FunAccountSet acctSetUpdateInfo = new FunAccountSet();
        acctSetUpdateInfo.setAccountId(param.getAcctId());
        if (param.getPayCheck() != null) {
            acctSetUpdateInfo.setPayCheck(param.getPayCheck().toString());
        }
        acctSetUpdateInfo.setLoginPassword(param.getLoginPassword());
        acctSetUpdateInfo.setPayPassword(param.getPayPassword());
        acctSetUpdateInfo.setSecureQ1(param.getSecureQ1());
        acctSetUpdateInfo.setSecureQ2(param.getSecureQ2());
        acctSetUpdateInfo.setSecureQ3(param.getSecureQ3());
        acctSetUpdateInfo.setSecureA1(param.getSecureA1());
        acctSetUpdateInfo.setSecureA2(param.getSecureA2());
        acctSetUpdateInfo.setSecureA3(param.getSecureA3());
        acctSetUpdateInfo.setUpdateOperId(param.getOperId());
        acctSetUpdateInfo.setUpdateDate(DateUtil.getSysDate());
        this.funAccountSetSV.modifyFunAccountSet(acctSetUpdateInfo);
    }

    @Override
    public AccountInfoVo queryAccountInfoById(String tenantId, long accountId)
            throws BusinessException {
        LOG.debug("开始查询账户信息:[account_id=" + accountId + "]");
        // 1.查询账户信息
        FunAccountInfo accountInfo = funAccountInfoSV.getBeanByPrimaryKey(accountId);
        if (accountInfo == null || !tenantId.equals(accountInfo.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_NOT_FOUND, "账户信息不存在");
        }
        // 2.查询账户设置信息
        FunAccountSet accountSet = funAccountSetSV.getFunAccountSet(accountId);
        if (accountSet == null || !tenantId.equals(accountSet.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Account.ACCOUNT_NOT_FOUND, "账户设置信息不存在");
        }
        /*
         * //3.查询账本信息 List<FunFundBook> fundBookList =
         * funFundBookSV.getValidFundBookByAccountId(accountId);//正常账本信息
         * if(CollectionUtil.isEmpty(fundBookList)){ throw new
         * BusinessException(ExceptCodeConstants.Account.NO_RESULT,"账本信息不存在"); } List<FunFundBook>
         * freezeBookList = funFundBookSV.getFreezeFundBookByAccountId(accountId);//冻结账本 //4.查询转兑详细
         * List<FunSubsFreeze> funSubsFreezeList = null;
         * if(!CollectionUtil.isEmpty(freezeBookList)){ funSubsFreezeList =
         * funSubsFreezeSV.getFunSubsFreeze(freezeBookList); }
         */
        // 5.构造返回参数
        AccountInfoVo accountInfoVo = this.convertAccountInfoVo(accountInfo, accountSet);
        /*
         * if(!CollectionUtil.isEmpty(fundBookList)){
         * accountInfoVo.setAcctBookList(this.convertFundBookVo(fundBookList)); }
         * if(!CollectionUtil.isEmpty(freezeBookList) &&
         * !CollectionUtil.isEmpty(funSubsFreezeList)){
         * accountInfoVo.setFreezeBookList(this.convertFreezeBookVo(freezeBookList,
         * funSubsFreezeList)); }
         */
        LOG.debug("账户信息查询结束");
        return accountInfoVo;
    }

    /**
     * 构造返回参数FreezeBookVo
     * 
     * @param freezeBookList
     * @param funSubsFreezeList
     * @return
     * @author lilg
     */
    /*
     * private List<FreezeBookVo> convertFreezeBookVo(List<FunFundBook>
     * freezeBookList,List<FunSubsFreeze> funSubsFreezeList){ //1.转兑详细Map Map<Long,FunSubsFreeze>
     * funSubsFreezeMap = new HashMap<Long,FunSubsFreeze>(); for(FunSubsFreeze
     * freeze:funSubsFreezeList){ funSubsFreezeMap.put(freeze.getSubsFreezeId(), freeze); }
     * //2.构造返回参数 List<FreezeBookVo> fesszeVoList = new ArrayList<FreezeBookVo>(); for(FunFundBook
     * book:freezeBookList){ FreezeBookVo freezeVo =new FreezeBookVo(); FunSubsFreeze freeze =
     * funSubsFreezeMap.get(book.getSubsFreezeId()); freezeVo.setFreezeBookId(book.getBookId());
     * freezeVo.setActiveId(freeze.getAcctId()); freezeVo.setFreezeSubjectId(freeze.getSubjectId());
     * freezeVo.setFreezeSubjectName(FunSubjectUtil.getFunSubjectName(freeze.getSubjectId()));
     * freezeVo.setDestSubjectId(freeze.getDestSubjectId());
     * freezeVo.setDestSubjectName(FunSubjectUtil.getFunSubjectName(freeze.getDestSubjectId()));
     * freezeVo.setCalMode(freeze.getCalMode());
     * freezeVo.setOrginalAmount(freeze.getOrginalAmount());
     * freezeVo.setAllotMonth(freeze.getAllotMonth()); freezeVo.setThawFee(freeze.getThawFee());
     * freezeVo.setThawScale(freeze.getThawScale());
     * freezeVo.setAlreadyAllotAmount(freeze.getAlreadyAllotAmount());
     * freezeVo.setAlreadyAllotMonth(freeze.getAlreadyAllotMonth());
     * freezeVo.setStartAllotMonth(freeze.getStartAllotMonth());
     * freezeVo.setLastAllotMonth(freeze.getLastAllotMonth());
     * freezeVo.setAllotStatus(freeze.getAllotStatus());
     * freezeVo.setLastAllotDate(freeze.getLastAllotDate()); fesszeVoList.add(freezeVo); } return
     * fesszeVoList; }
     */

    /**
     * 构造返回参数FreezeBookVo
     * 
     * @param bookList
     * @return
     * @author lilg
     */
    /*
     * private List<FundBookVo> convertFundBookVo(List<FunFundBook> bookList){ //账本信息
     * List<FundBookVo> bookVoList = new ArrayList<FundBookVo>(); for(FunFundBook
     * fundBook:bookList){ FundBookVo bookVo = new FundBookVo();
     * bookVo.setBookId(fundBook.getBookId()); bookVo.setFundSubjectId(fundBook.getSubjectId());
     * bookVo.setFundSubjectName(FunSubjectUtil.getFunSubjectName(fundBook.getSubjectId()));
     * bookVo.setFeatureCode(fundBook.getFeatureCode()); bookVo.setAmount(fundBook.getBalance());
     * bookVo.setEffectDate(fundBook.getEffectDate());
     * bookVo.setExpireDate(fundBook.getExpireDate()); bookVoList.add(bookVo); } return bookVoList;
     * }
     */

    /**
     * 构造返回参数AccountInfoVo，仅基本属性，不包含List属性
     * 
     * @param accountInfo
     * @param accountSet
     * @return
     * @author lilg
     * @ApiDocMethod
     */
    private AccountInfoVo convertAccountInfoVo(FunAccountInfo accountInfo, FunAccountSet accountSet) {
        AccountInfoVo accountInfoVo = new AccountInfoVo();
        accountInfoVo.setTenantId(accountInfo.getTenantId());
        accountInfoVo.setAcctId(accountInfo.getAccountId());
        accountInfoVo.setRegCustomerId(accountInfo.getCustId());
        accountInfoVo.setRegMail(accountInfo.getEmail());
        accountInfoVo.setCredit(accountInfo.getCredit());
        accountInfoVo.setAcctType(accountInfo.getAcctType());
        accountInfoVo.setPayType(accountInfo.getPayType());
        accountInfoVo.setAcctName(accountInfo.getAcctName());
        accountInfoVo.setAcctMailType(accountInfo.getPostType());
        accountInfoVo.setAcctAddr(accountInfo.getAcctAddr());
        accountInfoVo.setTempCredit(accountInfo.getTempCredit());
        accountInfoVo.setTempValidTime(accountInfo.getTempValidTime());
        accountInfoVo.setdTotQuota(accountInfo.getdTotQuota());
        accountInfoVo.setdSigQuota(accountInfo.getdSigQuota());
        accountInfoVo.setdTransQuota(accountInfo.getdTransQuota());
        accountInfoVo.setAcctStatus(accountInfo.getAcctStatus());

        accountInfoVo.setRegType(accountSet.getRegType());
        accountInfoVo.setLoginPassword(accountSet.getLoginPassword());
        accountInfoVo.setPayCheck(accountSet.getPayCheck());
        accountInfoVo.setPayPassword(accountSet.getPayPassword());
        accountInfoVo.setSecureQ1(accountSet.getSecureQ1());
        accountInfoVo.setSecureQ2(accountSet.getSecureQ2());
        accountInfoVo.setSecureQ3(accountSet.getSecureQ3());
        accountInfoVo.setSecureA1(accountSet.getSecureA1());
        accountInfoVo.setSecureA2(accountSet.getSecureA2());
        accountInfoVo.setSecureA3(accountSet.getSecureA3());

        return accountInfoVo;
    }

    @Override
    public List<AccountInfoVo> queryAccountInfoByCustId(String tenantId, String custId)
            throws BusinessException {
        List<AccountInfoVo> accountInfoVoList = new ArrayList<AccountInfoVo>();
        List<FunAccountInfo> accountIdList = funAccountInfoSV.getAccountInfoByCustId(
                tenantId, custId);
        for (FunAccountInfo accountId : accountIdList) {
            // TODO 事务层不能互相调用；对象转换的convert方法是否也不能定义在事物层
            accountInfoVoList.add(this.queryAccountInfoById(accountId.getTenantId(),
                    accountId.getAccountId()));
        }
        return accountInfoVoList;
    }

}
