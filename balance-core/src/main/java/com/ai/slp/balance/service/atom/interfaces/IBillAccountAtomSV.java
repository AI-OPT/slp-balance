package com.ai.slp.balance.service.atom.interfaces;

import java.util.List;

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
	/**
	 * 根据账户id和租户id查询当前账单透支额信息大于0的信息
	 * @param tenantId
	 * @param accountId
	 * @return
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public List<BillAccount> queryBillAccountOverdraftQuotaGreaterThanZero(String tenantId,String accountId);
	/**
	 * 通过billItemSeq 修改透支额
	 * @param billItemSeq
	 * @param overdraftQuota
	 * @author zhangzd
	 * @ApiDocMethod
	 * @ApiCode
	 */
	public void updateBillAccountByBillItemSeq(String billItemSeq,Long overdraftQuota);
}
