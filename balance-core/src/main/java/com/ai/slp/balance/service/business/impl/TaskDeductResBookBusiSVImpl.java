package com.ai.slp.balance.service.business.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.balance.constants.BalancesCostants;
import com.ai.slp.balance.constants.ExceptCodeConstants;
import com.ai.slp.balance.dao.mapper.bo.FunResBook;
import com.ai.slp.balance.dao.mapper.bo.FunResOperaDetail;
import com.ai.slp.balance.service.atom.interfaces.IFunResBookAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunResOperaDetailAtomSV;
import com.ai.slp.balance.service.business.interfaces.ITaskDeductResBookBusiSV;

@Service
@Transactional
public class TaskDeductResBookBusiSVImpl implements ITaskDeductResBookBusiSV {

    private static final Logger LOG = LogManager.getLogger(TaskDeductResBookBusiSVImpl.class);

    @Autowired
    private IFunResOperaDetailAtomSV funResOperaDetailAtomSV;

    @Autowired
    private IFunResBookAtomSV funResBookAtomSV;

    @Override
    public void deductResBook(FunResOperaDetail operaDetail) throws BusinessException {
        LOG.debug("开始后台抵扣账本服务");
        String logInfo = "{tenantId:" + operaDetail.getTenantId() + ",ownerId:"
                + operaDetail.getOwnerId() + ",ownerType:" + operaDetail.getOwnerType()
                + ",resourceType:" + operaDetail.getResourceType() + ",systemId:"
                + operaDetail.getSystemId() + ",externalId:" + operaDetail.getExternalId() + "}";
        List<FunResBook> bookList = funResBookAtomSV.getValidResBookByResourceType(
                operaDetail.getTenantId(), operaDetail.getOwnerId(), operaDetail.getOwnerType(),
                operaDetail.getResourceType());
        // 1.更新为已抵扣
        int row = funResOperaDetailAtomSV.updateStatus(operaDetail,
                BalancesCostants.FunResOperaDetail.Status.ALREADY_DEDUCT);
        if (row == 0) {
            // 已经被修改，直接返回
            return;
        } else if (row != 1) {
            // 其他异常，抛错
            throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR,
                    "离线抵扣，更新操作记录表异常，同时更新了多条记录：" + logInfo);
        }
        // 2.抵扣
        BigDecimal waitDeduct = operaDetail.getChangeAmount().negate();// 抵扣记录保存的是负值，转为正数
        if (!CollectionUtil.isEmpty(bookList)) {
            // 按照失效时间排序
            Collections.sort(bookList, new Comparator<FunResBook>() {
                @Override
                public int compare(FunResBook o1, FunResBook o2) {
                    return o1.getExpireTime().compareTo(o2.getExpireTime());
                }
            });
            // 循环账本抵扣
            for (FunResBook book : bookList) {
                BigDecimal balance = this.getBalance(book);
                while (waitDeduct.compareTo(BigDecimal.ZERO) != 0
                        && balance.compareTo(BigDecimal.ZERO) > 0) {// 未抵扣完成，并且账本仍有余额 （循环尝试版本号冲突）
                    if (balance.compareTo(waitDeduct) > 0) {
                        // 该账本余额充足,直接累加到DeductAmount，账本状态不变
                        int result = funResBookAtomSV.deductResBook(book.getBookId(), book
                                .getDeductAmount().add(waitDeduct), null, book.getUseVersion());
                        if (result == 1) {// 更新成功
                            waitDeduct = BigDecimal.ZERO;
                        } else {// 版本号冲突 (BookID为主键，不会更新多条)
                            LOG.warn("更新账本[{}]失败，版本号过期,本次抵扣[{}],剩余抵扣金额[{}]", book.getBookId(),
                                    waitDeduct.doubleValue(), waitDeduct.doubleValue());
                            book = funResBookAtomSV.getValidResBookByBookId(book.getBookId());
                            balance = this.getBalance(book);
                        }
                    } else {
                        // 该账本余额不足，全部抵扣，账本状态失效
                        int result = funResBookAtomSV.deductResBook(book.getBookId(), book
                                .getDeductAmount().add(balance),
                                BalancesCostants.FunResBook.BookStatus.INVALID, book
                                        .getUseVersion());
                        if (result == 1) {// 更新成功
                            waitDeduct = waitDeduct.subtract(balance);
                            balance = BigDecimal.ZERO;
                        } else {
                            LOG.warn("更新账本[{}]失败，版本号过期,本次抵扣[{}],剩余抵扣金额[{}]", book.getBookId(),
                                    balance, waitDeduct.doubleValue());
                            book = funResBookAtomSV.getValidResBookByBookId(book.getBookId());
                            balance = this.getBalance(book);
                        }
                    }
                }
                if (waitDeduct.compareTo(BigDecimal.ZERO) == 0) {
                    break;
                }
            }
        }
        // 3.所有账本已抵扣
        if (BalancesCostants.FunResOperaDetail.OptType.PART_DEDUCT == operaDetail.getOptType()
                && waitDeduct.compareTo(operaDetail.getChangeAmount().negate()) == 0) {
            // 之前已经抵扣过的记录，并且本次抵扣掉的为0，不再新增未抵扣记录，并且还原第一步的状态更新
            LOG.warn("账本没有余额，本次未抵扣：", logInfo);
            operaDetail.setBookStatus(BalancesCostants.FunResOperaDetail.Status.ALREADY_DEDUCT);
            int result = funResOperaDetailAtomSV.updateStatus(operaDetail,
                    BalancesCostants.FunResOperaDetail.Status.WAIT_DEDUCT);
            if (result != 1) {
                throw new BusinessException(ExceptCodeConstants.Special.SYSTEM_ERROR,
                        "离线抵扣状态还原，更新操作记录表异常，同时更新了多条记录：" + logInfo);
            }

        } else if (waitDeduct.compareTo(BigDecimal.ZERO) > 0) {
            // 如仍有未抵扣的，新增一条操作记录用来记录尚未抵扣的部分
            LOG.warn("账本已抵扣完,但是账本不够抵扣,剩余部分已记录在操作记录表，系统ID和外部单号与原记录相同：", logInfo);
            operaDetail.setOptType(BalancesCostants.FunResOperaDetail.OptType.PART_DEDUCT);
            operaDetail.setChangeAmount(waitDeduct.negate());// 再转为负存入
            operaDetail.setBookStatus(BalancesCostants.FunResOperaDetail.Status.WAIT_DEDUCT);
            funResOperaDetailAtomSV.insert(operaDetail);
        }
    }

    private BigDecimal getBalance(FunResBook book) {
        // total-deduct-exchange-present
        return book.getTotalAmount().subtract(book.getDeductAmount())
                .subtract(book.getExchangeAmount()).subtract(book.getPresentAmount());
    }

    @Override
    public List<FunResOperaDetail> queryWaitDeduct(int start, int end) throws BusinessException {
        return funResOperaDetailAtomSV.getWaitDeduct(start, end);
    }
}
