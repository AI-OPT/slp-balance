package com.ai.slp.balance.service.atom.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ai.slp.balance.dao.mapper.bo.FunFundBook;
import com.ai.slp.balance.dao.mapper.bo.FunSubsFreeze;
import com.ai.slp.balance.dao.mapper.bo.FunSubsFreezeCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IFunSubsFreezeAtomSV;

@Component
public class FunSubsFreezeAtomSVImpl implements IFunSubsFreezeAtomSV {

    @Override
    public List<FunSubsFreeze> getFunSubsFreeze(long accountId, List<Long> subsFreezeIds) {
        FunSubsFreezeCriteria freezeExample = new FunSubsFreezeCriteria();
        freezeExample.createCriteria().andAcctIdEqualTo(accountId).andSubsFreezeIdIn(subsFreezeIds);
        return MapperFactory.getFunSubsFreezeMapper().selectByExample(freezeExample);
    }

    @Override
    public List<FunSubsFreeze> getFunSubsFreeze(List<FunFundBook> funFundBokList) {
        Map<Long, List<Long>> bookMap = new HashMap<Long, List<Long>>();
        // 按照AccountId归类
        for (FunFundBook book : funFundBokList) {
            if (book.getSubsFreezeId() != null) {
                Long accountId = book.getAccountId();
                if (!bookMap.containsKey(accountId)) {
                    bookMap.put(accountId, new ArrayList<Long>());
                }
                bookMap.get(accountId).add(book.getSubsFreezeId());
            }
        }
        // 查询
        List<FunSubsFreeze> funSubsFreezeList = new ArrayList<FunSubsFreeze>();
        for (Map.Entry<Long, List<Long>> entry : bookMap.entrySet()) {
            List<FunSubsFreeze> freezeForAcct = this.getFunSubsFreeze(entry.getKey(),
                    entry.getValue());
            funSubsFreezeList.addAll(freezeForAcct);
        }
        return funSubsFreezeList;
    }

}
