package com.tucs.core.commons.dto;

import java.util.List;

import com.tucs.core.model.entity.EnControl.AutomaticClosing;
import com.tucs.core.model.entity.EnControl.TypeSplit;
import com.tucs.core.model.entity.TyCurrency;


public class ControlLookupsDto {
	
	private List<TyCurrency> currencies;
	private TypeSplit[] splities;
	private AutomaticClosing[] automatics;
	private Integer[] startDays;
	
	
	public ControlLookupsDto() {
		this.splities = TypeSplit.values();		
		this.automatics = AutomaticClosing.values();		
		this.startDays = new Integer[31];
		int index =0;
		for (int i=1; i< 32 ; i++) {
			this.startDays[index++] = i;
		}
	}

	public ControlLookupsDto(List<TyCurrency> currencies) {
		this();
		this.currencies = currencies;
	}

	
	public List<TyCurrency> getCurrencies() {
		return currencies;
	}

	
	public void setCurrencies(List<TyCurrency> currencies) {
		this.currencies = currencies;
	}

	public TypeSplit[] getSplities() {
		return splities;
	}

	public void setSplities(TypeSplit[] splities) {
		this.splities = splities;
	}

	public AutomaticClosing[] getAutomatics() {
		return automatics;
	}

	public void setAutomatics(AutomaticClosing[] automatics) {
		this.automatics = automatics;
	}

	public Integer[] getStartDays() {
		return startDays;
	}

	public void setStartDays(Integer[] startDays) {
		this.startDays = startDays;
	}	
}
