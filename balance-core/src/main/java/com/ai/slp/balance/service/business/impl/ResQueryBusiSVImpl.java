package com.ai.slp.balance.service.business.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.sdk.util.CollectionUtil;
import com.ai.slp.balance.api.resquery.param.PkgResource;
import com.ai.slp.balance.api.resquery.param.ResAmount;
import com.ai.slp.balance.api.resquery.param.ResAmountQuery;
import com.ai.slp.balance.api.resquery.param.ResBook;
import com.ai.slp.balance.api.resquery.param.ResPkgInfo;
import com.ai.slp.balance.api.resquery.param.ResPkgQuery;
import com.ai.slp.balance.dao.mapper.bo.FunResBook;
import com.ai.slp.balance.service.atom.interfaces.IFunResBookAtomSV;
import com.ai.slp.balance.service.atom.interfaces.IFunResBookRestAmountAtomSV;
import com.ai.slp.balance.service.business.interfaces.IResQueryBusiSV;
import com.ai.slp.balance.util.FunSubjectUtil;
import com.ai.slp.balance.vo.SubjectVo;

@Service
@Transactional
public class ResQueryBusiSVImpl implements IResQueryBusiSV {

    private static final Logger LOG = LogManager.getLogger(ResQueryBusiSVImpl.class);

    @Autowired
    private IFunResBookAtomSV funResBookAtomSV;
    
    @Autowired
    private IFunResBookRestAmountAtomSV funResBookRestAmountAtomSV;
    
    @Override
    public ResAmount queryUsableAmount(ResAmountQuery param) throws BusinessException {
        LOG.debug("开始查询资源可用总量业务服务");
        ResAmount amount = new ResAmount();
        amount.setOwnerId(param.getOwnerId());
        amount.setOwnerType(param.getOwnerType());
        amount.setResourceType(param.getResourceType());
        amount.setTenantId(param.getTenantId());
        amount.setTotalAmount(funResBookRestAmountAtomSV.getAmount(param.getTenantId(), param.getOwnerId(),
                param.getOwnerType(), param.getResourceType()).doubleValue());
        return amount;
    }

    @Override
    public List<ResPkgInfo> queryResPackage(ResPkgQuery param) throws BusinessException {
        LOG.debug("开始套餐余量查询业务服务");
        List<FunResBook> allBookList = funResBookAtomSV.getResPgkBook(param.getTenantId(),
                param.getOwnerId(), param.getOwnerType());
        if (CollectionUtil.isEmpty(allBookList)) {
            LOG.debug("未查询到符合条件的套餐资源账本");
            return new ArrayList<ResPkgInfo>();
        }
        // 数据重组
        Map<Long, Map<Integer, List<FunResBook>>> sourceIdMap = new HashMap<Long, Map<Integer, List<FunResBook>>>();
        for (FunResBook book : allBookList) {
            Long sourceType = book.getSourceId();
            int resType = book.getResourceType();
            if (!sourceIdMap.containsKey(sourceType)) {
                sourceIdMap.put(sourceType, new HashMap<Integer, List<FunResBook>>());
            }
            Map<Integer, List<FunResBook>> resTypeMap = sourceIdMap.get(sourceType);
            if (!resTypeMap.containsKey(resType)) {
                resTypeMap.put(resType, new ArrayList<FunResBook>());
            }
            List<FunResBook> bookList = resTypeMap.get(resType);
            bookList.add(book);
        }
        // 结果转换
        Map<Integer,SubjectVo> subjectMap = new HashMap<Integer,SubjectVo>();
        // 第一层，ResPkgInfo
        List<ResPkgInfo> resultList = new ArrayList<ResPkgInfo>();
        for (Entry<Long, Map<Integer, List<FunResBook>>> pkgMap : sourceIdMap.entrySet()) {
            ResPkgInfo resPkgInfo = new ResPkgInfo();
            resPkgInfo.setProdElementId(pkgMap.getKey());
            // 第二层，PkgResource
            resPkgInfo.setPkgResourceList(new ArrayList<PkgResource>());
            for (Entry<Integer, List<FunResBook>> resMap : pkgMap.getValue().entrySet()) {
                PkgResource pkgResource = new PkgResource();
                pkgResource.setResourceType(resMap.getKey());
                // 第三层，ResBook
                pkgResource.setResBookList(new ArrayList<ResBook>());
                BigDecimal totalAmount = BigDecimal.ZERO;
                BigDecimal balanceAmount = BigDecimal.ZERO;
                BigDecimal usedAmount = BigDecimal.ZERO;
                BigDecimal transferAmount = BigDecimal.ZERO;
                for (FunResBook funResBook : resMap.getValue()) {
                    ResBook book = new ResBook();
                    book.setBookId(funResBook.getBookId());
                    book.setSubjectId(funResBook.getSubjectId());
                    book.setEffectTime(funResBook.getEffectTime());
                    book.setExpireTime(funResBook.getExpireTime());
                    // 计算各种Amount
                    BigDecimal used = this.getUsedAmount(funResBook);
                    BigDecimal balance = this.getBalanceAmount(funResBook);
                    BigDecimal transfer = this.getTransferAmount(funResBook);
                    book.setTotalAmount(funResBook.getTotalAmount().doubleValue());
                    book.setTransferAmount(transfer.doubleValue());
                    book.setUsedAmount(used.doubleValue());
                    book.setBalanceAmount(balance.doubleValue());
                    totalAmount = totalAmount.add(funResBook.getTotalAmount());
                    balanceAmount = balanceAmount.add(balance);
                    usedAmount = usedAmount.add(used);
                    transferAmount = transferAmount.add(transfer);
                    pkgResource.getResBookList().add(book);
                    //单位翻译
                    if(!subjectMap.containsKey(funResBook.getResourceType())){
                        subjectMap.put(funResBook.getResourceType(), FunSubjectUtil.getSubject(funResBook.getTenantId(), funResBook.getSubjectId()));
                    }
                }
                pkgResource.setTotalAmount(totalAmount.doubleValue());
                pkgResource.setBalanceAmount(balanceAmount.doubleValue());
                pkgResource.setUsedAmount(usedAmount.doubleValue());
                pkgResource.setTransferAmount(transferAmount.doubleValue());
                //单位
                if(!subjectMap.containsKey(resMap.getKey())){
                    pkgResource.setUnitName(subjectMap.get(resMap.getKey()).getUnitName());   
                }else{
                    pkgResource.setUnitName("");
                }
                resPkgInfo.getPkgResourceList().add(pkgResource);
            }
            resultList.add(resPkgInfo);
        }
        LOG.debug("套餐余量查询数据处理完成");
        return resultList;
    }
    
    private BigDecimal getTransferAmount(FunResBook book){
        return book.getPresentAmount().add(book.getExchangeAmount());
    }

    private BigDecimal getBalanceAmount(FunResBook book) {
        return book.getTotalAmount().subtract(this.getUsedAmount(book)).subtract(this.getTransferAmount(book));
    }

    private BigDecimal getUsedAmount(FunResBook book) {
        return book.getDeductAmount();
    }

}
