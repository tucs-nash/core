package com.tucs.core.commons.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tucs.core.model.entity.EnCategory;
import com.tucs.core.model.entity.EnTransaction;


public class CategoryTransactionsDto {
	
	private EnCategory category;
	private List<EnTransaction> transactions;
	private Double total;
		
	public CategoryTransactionsDto() {
		this.transactions = new ArrayList<EnTransaction>(0);
		this.total = 0D;
	}


	@JsonIgnore
	public void addTransactions(EnTransaction transaction) {
		this.transactions.add(transaction);		
		switch (transaction.getType()) {
			case CREDIT:
				this.total += transaction.getValue();
				break;
			case DEBIT:
				this.total -= transaction.getValue();
				break;
			default:
				break;
		}
		
	}
	
	public EnCategory getCategory() {
		return category;
	}

	
	public void setCategory(EnCategory category) {
		this.category = category;
	}

	
	public List<EnTransaction> getTransactions() {
		return transactions;
	}

	
	public void setTransactions(List<EnTransaction> transactions) {
		this.transactions = transactions;
	}

	
	public Double getTotal() {
		return total;
	}

	
	public void setTotal(Double total) {
		this.total = total;
	}

}
