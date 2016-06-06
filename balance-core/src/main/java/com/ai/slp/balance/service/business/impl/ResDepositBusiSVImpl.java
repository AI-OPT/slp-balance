package com.ai.slp.balance.service.business.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.components.sequence.util.SeqUtil;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.paas.ipaas.util.StringUtil;
import com.ai.slp.balance.api.resdeposit.param.ResourceDeposit;
import com.ai.slp.balance.constants.BalancesCostants;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.constants.SeqConstants;
import com.ai.slp.balance.dao.mapper.bo.FunResBook;
import com.ai.slp.balance.dao.mapper.bo.FunResBookRestAmount;
import com.ai.slp.balance.dao.mapper.bo.FunResOperaDetail;
import com.ai.slp.balance.service.atom.interfaces.IFunResBookAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunResBookRestAmountAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunResOperaDetailAtomSV;
import com.ai.slp.balance.service.business.interfaces.IResDepositBusiSV;
import com.ai.slp.balance.util.FunSubjectUtil;
import com.ai.slp.balance.vo.SubjectVo;

@Service
@Transactional
public class ResDepositBusiSVImpl implements IResDepositBusiSV {

    private static final Logger LOG = LogManager.getLogger(ResDepositBusiSVImpl.class);

    @Autowired
    private IFunResBookAtomSV funResBookAtomSV;

    @Autowired
    private IFunResBookRestAmountAtomSV funResBookRestAmountAtomSV;

    @Autowired
    private IFunResOperaDetailAtomSV funResOperaDetailAtomSV;

    @Override
    public void depositResource(ResourceDeposit param) throws BusinessException {
        LOG.debug("开始执行资源入账服务");
        // TODO 属主校验,没法校验
        // 幂等性校验
        FunResOperaDetail funResOperaDetail = funResOperaDetailAtomSV.getBean(param.getTenantId(),
                param.getSystemId(), param.getExternalId(),
                BalancesCostants.FunResOperaDetail.OptType.DEPOSIT);
        if (funResOperaDetail != null) {
            LOG.error("幂等性校验：已经入账,不再重复入账[tenantId:{},systemId:{},externalId:{}]",
                    param.getTenantId(), param.getSystemId(), param.getExternalId());
            return;
        }
        // 科目校验,接口传入的ResourceType对应GN_SUBJECT的fundType
        List<SubjectVo> subjectList = FunSubjectUtil.getSubjectByType(param.getTenantId(),
                String.valueOf(param.getResourceType()));// TODO 类型不一致
        if (CollectionUtil.isEmpty(subjectList)) {
            throw new BusinessException(ExceptCodeConstants.Subject.SUBJECT_NOT_FOUND,
                    "科目不存在:{tenantId:" + param.getTenantId() + ",resourceType:"
                            + param.getResourceType() + "}");
        }
        Timestamp sysdate = DateUtil.getSysDate();
        BigDecimal amount = BigDecimal.valueOf(param.getTotalAmount());
        // 2.创建账本
        FunResBook book = this.convertResBook(param, subjectList.get(0).getSubjectId());// TODO
                                                                                        // 目前规定ResourceType与科目一一对应，只取第一个，否则接口无法支撑
        // 即买即用
        if (BalancesCostants.FunResBook.UseFlag.IMMEDIATELY.equals(param.getUseFlag())) {
            book.setEffectTime(BalancesCostants.FunResBook.DefaultDate.effectDate);// 默认生效时间2000-01-01
        }
        // 已经生效
        if (book.getEffectTime().compareTo(sysdate) <= 0
                && BalancesCostants.FunResBook.AllowClear.NO != book.getAllowClear()) {
            // 不清零账本不立即生效：为了便于激活已冻结的不清零账本而不影响入账效率，交给定时任务激活
            book.setBookStatus(BalancesCostants.FunResBook.BookStatus.VALID);
        } else {
            book.setBookStatus(BalancesCostants.FunResBook.BookStatus.UN_ACTIVATED);
        }
        funResBookAtomSV.insert(book);
        // 3.创建入账记录
        FunResOperaDetail opera = new FunResOperaDetail();
        opera.setTenantId(param.getTenantId());
        opera.setSystemId(param.getSystemId());
        opera.setExternalId(param.getExternalId());
        opera.setOwnerId(param.getOwnerId());
        opera.setOwnerType(param.getOwnerType());
        opera.setResourceType(param.getResourceType());
        opera.setChangeAmount(amount);
        opera.setBookStatus("");
        opera.setOptType(BalancesCostants.FunResOperaDetail.OptType.DEPOSIT);
        opera.setOptTime(sysdate);
        funResOperaDetailAtomSV.insert(opera);
        // 4.判断是否需要，更新总表量，如果更新后记录不存在则创建，如果创建报逐渐冲突则再次尝试更新 //TODO
        if (book.getBookStatus().equals(BalancesCostants.FunResBook.BookStatus.VALID)) {
            int result = funResBookRestAmountAtomSV.offsetAmount(param.getTenantId(),
                    param.getOwnerId(), param.getOwnerType(), param.getResourceType(), amount);
            if (result == 0) {
                FunResBookRestAmount restAmount = new FunResBookRestAmount();
                restAmount.setTenantId(param.getTenantId());
                restAmount.setOwnerId(param.getOwnerId());
                restAmount.setOwnerType(param.getOwnerType());
                restAmount.setResourceType(param.getResourceType());
                restAmount.setRestAmount(amount);
                restAmount.setLastUpdateTime(sysdate);
                funResBookRestAmountAtomSV.insert(restAmount);// TODO 如果报主键冲突，再次更新
            }
        }
    }

    private FunResBook convertResBook(ResourceDeposit param, Long subjectId) {
        FunResBook book = new FunResBook();
        book.setBookId(SeqUtil.getNewId(SeqConstants.FUN_FUND_BOOK$BOOK_ID));
        book.setTenantId(param.getTenantId());
        book.setOwnerId(param.getOwnerId());
        book.setOwnerType(param.getOwnerType());
        book.setSubjectId(subjectId); // 科目ID
        book.setResourceType(param.getResourceType());
        book.setCreateTime(DateUtil.getSysDate());
        book.setEffectTime(StringUtil.isBlank(param.getEffectDate()) ? BalancesCostants.FunResBook.DefaultDate.effectDate
                : DateUtil.getTimestamp(param.getEffectDate(), DateUtil.DATETIME_FORMAT));
        book.setExpireTime(StringUtil.isBlank(param.getExpireDate()) ? BalancesCostants.FunResBook.DefaultDate.expireDate
                : DateUtil.getTimestamp(param.getExpireDate(), DateUtil.DATETIME_FORMAT));
        book.setTotalAmount(BigDecimal.valueOf(param.getTotalAmount()));
        book.setDeductAmount(BigDecimal.ZERO);
        book.setPresentAmount(BigDecimal.ZERO);
        book.setExchangeAmount(BigDecimal.ZERO);
        book.setBookStatus(BalancesCostants.FunResBook.BookStatus.UN_ACTIVATED);// 状态：未激活
        book.setAllowClear(param.getAllowClear());
        book.setAllowConvert(param.getAllowConvert());
        book.setAllowPresent(param.getAllowPresent());
        book.setSourceId(param.getSourceId());
        book.setSourceType(param.getSourceType());
        book.setUseVersion(0l);
        return book;
    }
}
