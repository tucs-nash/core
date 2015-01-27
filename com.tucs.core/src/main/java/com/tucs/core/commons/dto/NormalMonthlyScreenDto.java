package com.tucs.core.commons.dto;

import java.util.List;

import com.tucs.core.model.entity.EnControlMonthly;


public class NormalMonthlyScreenDto extends AbstractMonthlyScreenDto {
	
	private EnControlMonthly monthly;
	private List<CategoryTransactionsDto> categories;
	
	public NormalMonthlyScreenDto(EnControlMonthly monthly) {
		super(monthly.getControl(), monthly.getMonth().intValue(), monthly.getYear().intValue());
		this.monthly = monthly;
	}
	
	public EnControlMonthly getMonthly() {
		return monthly;
	}
	public void setMonthly(EnControlMonthly monthly) {
		this.monthly = monthly;
	}
	
	public List<CategoryTransactionsDto> getCategories() {
		return categories;
	}
	public void setCategories(List<CategoryTransactionsDto> categories) {
		this.categories = categories;
	}
	
	
	
}
