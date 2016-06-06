package com.ai.slp.balance.api.accountmatain.impl;

import java.io.UnsupportedEncodingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.sdk.util.StringUtil;
import com.ai.slp.balance.api.accountmaintain.interfaces.IAccountMaintainSV;
import com.ai.slp.balance.api.accountmaintain.param.AccountUpdateParam;
import com.ai.slp.balance.api.accountmaintain.param.RegAccReq;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.service.business.interfaces.IAccountManagerSV;
import com.alibaba.dubbo.config.annotation.Service;

@Service
@Component
public class AccountMaintainSVImpl implements IAccountMaintainSV {

    private static final Logger log = LogManager.getLogger(AccountMaintainSVImpl.class);

    @Autowired
    private IAccountManagerSV accountSV;

    @Override
    public long createAccount(RegAccReq regAccReq) throws BusinessException,SystemException {
        log.debug("创建账户---开始");
        long newAccountId = 0;
        try {
            if (regAccReq == null) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:参数不能为空");
            }
            if (StringUtil.isBlank(regAccReq.getExternalId())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:外部流水号ID不能为空");
            }
            if (StringUtil.isBlank(regAccReq.getSystemId())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:系统ID不能为空");
            }
            if (StringUtil.isBlank(regAccReq.getTenantId())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
            }
            if (StringUtil.isBlank(regAccReq.getAcctName())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:账户名称不能为空");
            }
            if (StringUtil.isBlank(regAccReq.getAcctType())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:账户类型不能为空");
            }
            if (StringUtil.isBlank(regAccReq.getPayType())) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:付款方式不能为空");
            }

            if (StringUtil.isBlank(regAccReq.getRegType())) {
                // 注册方式：1、通信客户注册 2、渠道注册 3、网站注册，
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:注册方式不能为空");
            }
            // 校验对应的客户编号、渠道编号、注册邮箱信息是否有效
            switch (regAccReq.getRegType()) {
            case "1": // 通信客户编号 校验
                if (regAccReq.getRegCustomerId() == null || "".equals(regAccReq.getRegCustomerId())) {
                    throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,
                            "0001-注册失败，请填写通讯客户信息");
                }
                break;
            case "2": // 渠道编号 校验
                if (regAccReq.getChnlId() == null || "".equals(regAccReq.getChnlId())) {
                    throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,
                            "0002-注册失败，请填写渠道信息");
                }
                break;
            case "3": // 注册邮箱 校验
                if (regAccReq.getRegEmail() == null || "".equals(regAccReq.getRegEmail())) {
                    throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL,
                            "0003-注册失败，请填写网站账号信息");
                }
                break;
            default:
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "注册方式错误");
            }
            // 校验成功，开始注册
            /* 第一步，根据接口文档，将未传的部分参数，值初始化 */
            String md5DefaultKey = StringUtil.toString(DigestUtils.md5DigestAsHex("000000"
                    .getBytes("UTF-8")));
            regAccReq.setCredit(0L);// 信用额度默认填 0
            if (StringUtil.isBlank(regAccReq.getAcctMailType())) {// 账单邮寄方式 ---
                                                                  // 账户内资金对账单，可以默认填0（0无，1、Email，2、邮寄）
                regAccReq.setAcctMailType("0");
            }
            if (StringUtil.isBlank(regAccReq.getLoginPassword())) {// 查询密码 ---
                                                                   // 如果不传，接口默认设置"000000"MD5加密串
                regAccReq.setLoginPassword(md5DefaultKey);
            }
            if (StringUtil.isBlank(regAccReq.getPayCheck())) {// 支付密码是否验证 --- 如果不传，接口默认为0不验证
                regAccReq.setPayCheck("0");
            }
            if (StringUtil.isBlank(regAccReq.getPayPassword())) {// 支付密码 ---
                                                                 // 如果不传，接口默认设置"000000"MD5加密串
                regAccReq.setPayPassword(md5DefaultKey);
            }
            // 执行 创建账户的业务方法
            newAccountId = accountSV.createAccount(regAccReq);
            if (newAccountId == -1) {
                throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "0004-注册失败，账户号已存在");
            }
            log.debug("创建账户---结束");
        } catch (UnsupportedEncodingException e) {
        	throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "0004-注册失败");
        }
        // 将 新创建的账户 的 账户ID返回
        return newAccountId;
    }

    @Override
    public void updateAccount(AccountUpdateParam param) throws BusinessException,SystemException {
        log.debug("更新余额中心账户开始");
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:账户设置入参不能为空");
        }

        if (StringUtil.isBlank(param.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
        }

        if (param.getAcctId() == 0l) {
            throw new BusinessException(ExceptCodeConstants.Special.PARAM_IS_NULL, "获取参数失败:账户ID不能为空");
        }

        accountSV.updateAccount(param);
        log.debug("更新余额中心账户结束");
    }
}
