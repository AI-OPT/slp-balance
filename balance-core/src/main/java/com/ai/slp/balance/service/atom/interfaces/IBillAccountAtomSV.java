package com.ai.slp.balance.service.atom.interfaces;

import com.ai.slp.balance.dao.mapper.bo.BillAccount;
import com.ai.slp.balance.dao.mapper.bo.BillAccountKey;

public interface IBillAccountAtomSV {
	public void insert(BillAccount billAccount);
	/**
	 * 根据主键查询信息是否存在
	 * @param billAccountKey
	 * @return
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public BillAccount getBillAccount(BillAccountKey billAccountKey);
	/**
	 * 通过主键修改信息
	 * @param billAccount
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void updateBillAccountByPrimaryKeySelective(BillAccount billAccount);
}
