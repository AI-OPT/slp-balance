package com.ai.slp.balance.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.slp.balance.dao.mapper.bo.BillAccount;
import com.ai.slp.balance.dao.mapper.bo.BillAccountCriteria;
import com.ai.slp.balance.dao.mapper.bo.BillAccountKey;
import com.ai.slp.balance.dao.mapper.factory.MapperFactory;
import com.ai.slp.balance.service.atom.interfaces.IBillAccountAtomSV;
@Component
public class BillAccountAtomSVImpl implements IBillAccountAtomSV {

	@Override
	public void insert(BillAccount billAccount) {

		MapperFactory.getBillAccountMapper().insert(billAccount);
	}

	@Override
	public BillAccount getBillAccount(BillAccountKey billAccountKey) {
		return MapperFactory.getBillAccountMapper().selectByPrimaryKey(billAccountKey);
		
	}

	@Override
	public void updateBillAccountByPrimaryKeySelective(BillAccount billAccount) {

		MapperFactory.getBillAccountMapper().updateByPrimaryKeySelective(billAccount);
	}
	/**
	 * 查询透支额度大于零的当前账户的列表信息
	 */
	@Override
	public List<BillAccount> queryBillAccountOverdraftQuotaGreaterThanZero(String tenantId, String accountId) {
		BillAccountCriteria example = new BillAccountCriteria();
		BillAccountCriteria.Criteria criteria = example.createCriteria();
		criteria.andTenantIdEqualTo(tenantId);
		criteria.andAccountIdEqualTo(Long.valueOf(accountId));
		//透支额度大于0
		criteria.andOverdraftQuotaGreaterThan(0l);
		example.setOrderByClause(" pay_day asc");
		//
		List<BillAccount> billAccountList = MapperFactory.getBillAccountMapper().selectByExample(example);
		//
		return billAccountList;
	}
	/**
	 * 通过序列号修改透支额度信息
	 */
	public void updateBillAccountByBillItemSeq(String billItemSeq,Long overdraftQuota){
		BillAccount record = new BillAccount();
		record.setOverdraftQuota(overdraftQuota);
		//
		BillAccountCriteria example = new BillAccountCriteria();
		BillAccountCriteria.Criteria criteria = example.createCriteria();
		criteria.andBillItemSeqEqualTo(billItemSeq);
		//
		MapperFactory.getBillAccountMapper().updateByExampleSelective(record, example);
	}

}
