package com.tucs.core.commons.dto;

import java.util.List;

import com.tucs.core.model.entity.EnControlMonthly;
import com.tucs.core.model.entity.EnTransaction;


public class SharedMonthlyScreenDto extends AbstractMonthlyScreenDto {
	
	private List<EnControlMonthly> controls;
	private List<EnTransaction> transactions;
	
	
	public SharedMonthlyScreenDto(List<EnControlMonthly> controls) {
		super(controls.get(0).getControl(), controls.get(0).getMonth().intValue(), controls.get(0).getYear().intValue());
		this.controls = controls;
	}
	

	public List<EnControlMonthly> getControls() {
		return controls;
	}

	public void setControls(List<EnControlMonthly> controls) {
		this.controls = controls;
	}


	public List<EnTransaction> getTransactions() {
		return transactions;
	}


	public void setTransactions(List<EnTransaction> transactions) {
		this.transactions = transactions;
	}
	
}
