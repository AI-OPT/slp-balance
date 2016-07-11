package com.ai.slp.balance.service.atom.interfaces;

import com.ai.slp.balance.dao.mapper.bo.BillOrder2fee;

public interface IBillOrder2feeAtomSV {
	public void insert(BillOrder2fee billOrder2fee);
	public BillOrder2fee getBillOrder2fee(String productCatId);
}
