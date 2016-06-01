package com.ai.slp.balance.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.slp.balance.dao.mapper.bo.FunSubject;
import com.ai.slp.balance.dao.mapper.bo.FunSubjectCriteria;
import com.ai.slp.balance.dao.mapper.bo.FunSubjectFund;
import com.ai.slp.balance.dao.mapper.bo.FunSubjectFundCriteria;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IFunSubjectAtomSV;

@Component
public class FunSubjectAtomSVImpl implements IFunSubjectAtomSV {

    @Override
    public List<FunSubject> queryFunSubject(long subjectId) {
        FunSubjectCriteria subject = new FunSubjectCriteria();
        FunSubjectCriteria.Criteria criteria = subject.createCriteria();
        criteria.andSubjectIdEqualTo(subjectId);
        return MapperFactory.getFunSubjectMapper().selectByExample(subject);
    }

    @Override
    public List<FunSubject> queryFunSubject() {
        return MapperFactory.getFunSubjectMapper().selectByExample(new FunSubjectCriteria());
    }

    @Override
    public List<FunSubjectFund> queryFunSubjectFund(long subjectId) {
        FunSubjectFundCriteria subject = new FunSubjectFundCriteria();
        FunSubjectFundCriteria.Criteria criteria = subject.createCriteria();
        criteria.andSubjectIdEqualTo(subjectId);
        return MapperFactory.getFunSubjectFundMapper().selectByExample(subject);
    }

    @Override
    public List<FunSubjectFund> queryFunSubjectFund() {
        return MapperFactory.getFunSubjectFundMapper()
                .selectByExample(new FunSubjectFundCriteria());
    }

}
