package com.ai.slp.balance.service.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.opt.base.exception.BusinessException;
import com.ai.slp.balance.dao.mapper.bo.FunSubject;
import com.ai.slp.balance.dao.mapper.bo.FunSubjectFund;
import com.ai.slp.balance.service.atom.interfaces.IFunSubjectAtomSV;
import com.ai.slp.balance.service.business.interfaces.IFunSubjectBusiSV;

@Service
@Transactional
public class FunSubjectBusiSVImpl implements IFunSubjectBusiSV {

    @Autowired
    private IFunSubjectAtomSV funSubjectSV;

    @Override
    public List<FunSubject> queryFunSubject(long subjectId) throws BusinessException {
        return funSubjectSV.queryFunSubject(subjectId);
    }

    @Override
    public List<FunSubject> queryFunSubject() throws BusinessException {
        return funSubjectSV.queryFunSubject();
    }

    @Override
    public List<FunSubjectFund> queryFunSubjectFund(long subjectId) throws BusinessException {
        return funSubjectSV.queryFunSubjectFund(subjectId);
    }

    @Override
    public List<FunSubjectFund> queryFunSubjectFund() throws BusinessException {
        return funSubjectSV.queryFunSubjectFund();
    }

}
