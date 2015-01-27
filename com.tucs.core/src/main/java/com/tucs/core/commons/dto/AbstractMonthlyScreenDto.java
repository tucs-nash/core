package com.tucs.core.commons.dto;

import java.util.List;

import com.tucs.core.model.entity.EnControl;
import com.tucs.core.model.entity.EnControlMonthly;
import com.tucs.core.model.entity.EnSavings;


public abstract class AbstractMonthlyScreenDto {
	
	private int month;
	private int year;
	private boolean isShared;
	private boolean isClosing;
	private boolean isSavings;
	private List<EnControlMonthly> withoutClose;
	private EnSavings savings;
	
	public AbstractMonthlyScreenDto(EnControl enControl, int month, int year) {
		this.isShared = enControl.getShared();
		this.isClosing = enControl.getHasClosing();
		this.isSavings = enControl.getHasSaving();
		this.month = month;
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public boolean isShared() {
		return isShared;
	}

	
	public void setShared(boolean isShared) {
		this.isShared = isShared;
	}
	
	public boolean isClosing() {
		return isClosing;
	}

	
	public void setClosing(boolean isClosing) {
		this.isClosing = isClosing;
	}

	
	public List<EnControlMonthly> getWithoutClose() {
		return withoutClose;
	}

	
	public void setWithoutClose(List<EnControlMonthly> withoutClose) {
		this.withoutClose = withoutClose;
	}

	
	public boolean isSavings() {
		return isSavings;
	}

	
	public void setSavings(boolean isSavings) {
		this.isSavings = isSavings;
	}

	
	public EnSavings getSavings() {
		return savings;
	}

	
	public void setSavings(EnSavings savings) {
		this.savings = savings;
	}
	
}
