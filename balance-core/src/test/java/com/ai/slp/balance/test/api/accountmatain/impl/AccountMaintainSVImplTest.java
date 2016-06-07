package com.ai.slp.balance.test.api.accountmatain.impl;

import java.util.List;

import junit.framework.TestCase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.opt.sdk.util.UUIDUtil;
import com.ai.slp.balance.api.accountmaintain.interfaces.IAccountMaintainSV;
import com.ai.slp.balance.api.accountmaintain.param.AccountUpdateParam;
import com.ai.slp.balance.api.accountmaintain.param.RegAccReq;
import com.ai.slp.balance.api.accountquery.interfaces.IAccountQuerySV;
import com.ai.slp.balance.api.accountquery.param.AccountIdParam;
import com.ai.slp.balance.api.accountquery.param.AccountInfoVo;
import com.ai.slp.balance.api.accountquery.param.CustIdParam;
import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class AccountMaintainSVImplTest extends TestCase {

    private static final Logger log = LogManager.getLogger(AccountMaintainSVImplTest.class);

    //账户管理
    @Autowired
    private IAccountMaintainSV accountMaintainSV;
    
    //账户查询
    @Autowired
    private IAccountQuerySV accountQuerySV;
    
    /**
     * 账号创建
     * 
     * @author limy6
     */
    @Test
    public void testCreateAccount() throws Exception {
        long start = DateUtil.getCurrentTimeMillis();
        log.error("测试类 --- 开始创建账户"+"。开始时间："+start);
        RegAccReq vo = new RegAccReq();
        vo.setExternalId(UUIDUtil.genId32());// 外部流水号ID
        vo.setSystemId("SLP-UAC_WEB");// 系统ID
        vo.setTenantId("SLP");// 租户ID
        vo.setRegCustomerId("101");
        vo.setAcctName("加多宝");
        vo.setAcctType("0");// 账户类型， 0 后付费
        vo.setRegType("3");//注册方式网站注册
        vo.setPayType("2");// 支付方式
        vo.setRegEmail("jiaduobao@asiainfo.com");//注册邮箱
        vo.setAcctAddr("加多宝厂区");
        long newAccountId;
        try {
            newAccountId = accountMaintainSV.createAccount(vo);
            log.debug("创建账户结束");
            log.debug("账户ID：" + newAccountId);
            System.out.println("param:"+JSON.toJSONString(vo));
            System.out.println("账户ID:"+newAccountId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("出错：" + e.getMessage());
        }
        long end = DateUtil.getCurrentTimeMillis();
        log.error("结束时间："+end+",耗时="+(end-start));
    }

    /**
     * 账号查询
     * 
     * @author LLG
     */
    @Test
    public void testQueryAccontById() throws Exception {
        AccountIdParam accountId  = new AccountIdParam();
        accountId.setTenantId("SLP");
        accountId.setAccountId(11171);
        AccountInfoVo account = accountQuerySV.queryAccontById(accountId);
        assertNotNull("返回结果空，存入失败", account);
       // assertEquals("查询账户ID不是预期值", 18, account.getRegCustomerId());
    }
    
    /**
     * 账号查询
     * 
     * @author LLG
     */
    @Test
    public void testQueryAccontByCustId() throws Exception {
        CustIdParam accountId  = new CustIdParam();
        accountId.setTenantId("SLP");
        accountId.setCustId("101");
        List<AccountInfoVo> accountList = accountQuerySV.queryAccontByCustId(accountId);
        assertFalse("账户不存在",CollectionUtil.isEmpty(accountList));
        log.error("按照客户查询账户结果:{}",JSON.toJSONString(accountList));
    }

    /**
     * 
     * @throws Exception
     * @author fanpw
     * @ApiDocMethod
     */
    @Test
    public void testUpdateAccountCase1() throws Exception {
        AccountUpdateParam param = new AccountUpdateParam();
        param.setTenantId("SLP");
        param.setAcctId(11181);
        param.setAcctMailType(2);
        param.setAcctName("louis1111111111111");
        param.setPayCheck(1);
        param.setPayPassword("123%aa");
        param.setTempCredit(100l);
        param.setTempValidTime("20151027");
        param.setdSigQuota(500l);
        accountMaintainSV.updateAccount(param);
        System.out.println("param:"+JSON.toJSONString(param));
    }

    /**
     * 
     * @throws Exception
     * @author fanpw
     * @ApiDocMethod
     */
    @Test
    public void testUpdateAccountCase2() throws Exception {
        AccountUpdateParam param = new AccountUpdateParam();
        param.setTenantId("1");
        param.setAcctId(402);
        param.setOperId("123456");
        param.setCredit(200l);
        param.setAcctMailType(0);
        param.setAcctName("louisFan");
        param.setAcctAddr("beijing");
        param.setEmail("example@asiainfo.com");
        param.setLoginPassword("112233");
        param.setPayCheck(0);
        param.setPayPassword("123%aa");
        param.setTempCredit(20l);
        param.setTempValidTime("20151227");
        param.setdTotQuota(1200l);
        param.setdSigQuota(1000l);
        param.setdTransQuota(200l);
        param.setSecureQ1("who am i");
        param.setSecureA1("louisFan");
        accountMaintainSV.updateAccount(param);
    }
    
    /**
     * 更新账户设置
     * 测试用例：账户信息不存在
     * @author fanpw
     * @ApiDocMethod
     */
    @Test(expected = BusinessException.class)
    public void testUpdateAccountCase3() {
        AccountUpdateParam param = new AccountUpdateParam();
        param.setTenantId("1");
        param.setAcctId(12345);
        accountMaintainSV.updateAccount(param);
    }

}
