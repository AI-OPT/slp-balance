package com.ai.slp.balance.service.business.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.DateUtil;
import com.ai.slp.balance.constants.BalancesCostants;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.dao.mapper.bo.FunResBook;
import com.ai.slp.balance.dao.mapper.bo.FunResOperaDetail;
import com.ai.slp.balance.service.atom.interfaces.IFunResBookAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunResBookRestAmountAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunResOperaDetailAtomSV;
import com.ai.slp.balance.service.business.interfaces.ITaskMaintainResBookBusiSV;

@Service
@Transactional
public class TaskMaintainResBookBusiSVImpl implements ITaskMaintainResBookBusiSV {

    private static final Logger LOG = LogManager.getLogger(TaskMaintainResBookBusiSVImpl.class);

    @Autowired
    private IFunResBookAtomSV funResBookAtomSV;

    @Autowired
    private IFunResOperaDetailAtomSV funResOperaDetailAtomSV;

    @Autowired
    private IFunResBookRestAmountAtomSV funResBookRestAmountAtomSV;

    @Override
    public List<FunResBook> queryTimeoutResBook(int start, int end) throws BusinessException {
        return funResBookAtomSV.getTimeoutResBook(start, end);
    }

    @Override
    public void maintainResBook(FunResBook book) throws BusinessException {
        LOG.debug("开始处理账本{}", book.getBookId());
        String logInfo = "{tenantId:" + book.getTenantId() + ",ownerId:" + book.getOwnerId()
                + ",ownerType:" + book.getOwnerType() + ",resourceType:" + book.getResourceType()
                + ",bookId:" + book.getBookId() + "}";
        BigDecimal changeAmount = BigDecimal.ZERO;
        String externalId = null;
        // 1.更新账本
        BigDecimal balance = book.getTotalAmount().subtract(book.getDeductAmount())
                .subtract(book.getExchangeAmount()).subtract(book.getPresentAmount());
        if (BalancesCostants.FunResBook.BookStatus.VALID.equals(book.getBookStatus())) {
            // 有效账本过期处理
            externalId = "INVALID_" + book.getBookId();
            // 账本状态更新为：作废
            String newStatus = BalancesCostants.FunResBook.BookStatus.INVALID;
            if (balance.compareTo(BigDecimal.ZERO) > 0) {
                // 仍有余额，从总量中减去
                changeAmount = balance.negate();
                if (BalancesCostants.FunResBook.AllowClear.NO == book.getAllowClear()) {
                    // 不清零账本更新为：冻结
                    newStatus = BalancesCostants.FunResBook.BookStatus.FREEZE;
                }
            }
            int result = funResBookAtomSV.updateResBookStatus(book.getBookId(), newStatus,
                    book.getUseVersion());
            if (result != 1) {
                throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR,
                        "账本过期处理失败，版本号过期:" + logInfo);
            }
        } else if (BalancesCostants.FunResBook.BookStatus.UN_ACTIVATED.equals(book.getBookStatus())) {
            // 待激活账本激活处理
            externalId = "ACTIVATE_" + book.getBookId();
            changeAmount = balance;
            int result = funResBookAtomSV.updateResBookStatus(book.getBookId(),
                    BalancesCostants.FunResBook.BookStatus.VALID, book.getUseVersion());
            if (result != 1) {
                throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR,
                        "账本激活处理失败，版本号过期:" + logInfo);
            }
            // 不清零账本激活，还要激活冻结的不清零账本
            if (BalancesCostants.FunResBook.AllowClear.NO == book.getAllowClear()) {
                LOG.debug("不清零账本，开始激活其他冻结的不清零账本");
                BigDecimal activateAmount = funResBookAtomSV.activateNoclearBook(book);
                changeAmount = changeAmount.add(activateAmount);
            }
        } else {
            throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR,
                    "账本状态异常，不能做过期处理或激活处理:" + logInfo);
        }
        // 2.更新总表额度
        if (changeAmount.compareTo(BigDecimal.ZERO) != 0) {
            int result = funResBookRestAmountAtomSV.offsetAmount(book.getTenantId(),
                    book.getOwnerId(), book.getOwnerType(), book.getResourceType(), changeAmount);
            if (result != 1) {
                throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR,
                        "总表额度更新失败，总表记录不存在或存在多条记录:" + logInfo);
            }
            // 记录操作记录
            FunResOperaDetail opera = new FunResOperaDetail();
            opera.setTenantId(book.getTenantId());
            opera.setSystemId("RUNNER-BALANCE");
            opera.setExternalId(externalId);
            opera.setOwnerId(book.getOwnerId());
            opera.setOwnerType(book.getOwnerType());
            opera.setResourceType(book.getResourceType());
            opera.setChangeAmount(changeAmount);
            opera.setOptType(BalancesCostants.FunResOperaDetail.OptType.MAINTAIN_RESBOOK);
            opera.setOptTime(DateUtil.getSysDate());
            opera.setBookStatus("");
            funResOperaDetailAtomSV.insert(opera);
        }

    }

}
