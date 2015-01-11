package com.tucs.core.commons.dto;

import java.util.List;

import com.tucs.core.model.entity.EnCategory;
import com.tucs.core.model.entity.EnControl;
import com.tucs.core.model.entity.EnControlMonthly;
import com.tucs.core.model.entity.EnGroup;
import com.tucs.core.model.entity.EnParticipant;
import com.tucs.core.model.entity.EnSavings;


public class ControlDetailsDto {
	
	private EnControl control;
	private EnSavings savings;
	private List<EnGroup> groups;
	private List<EnParticipant> participants;
	private List<EnCategory> categories;
	private List<EnControlMonthly> closings;
	
	
	public ControlDetailsDto() {
	}


	
	public EnControl getControl() {
		return control;
	}


	
	public void setControl(EnControl control) {
		this.control = control;
	}


	
	public EnSavings getSavings() {
		return savings;
	}



	public void setSavings(EnSavings savings) {
		this.savings = savings;
	}



	public List<EnGroup> getGroups() {
		return groups;
	}


	
	public void setGroups(List<EnGroup> groups) {
		this.groups = groups;
	}


	
	public List<EnParticipant> getParticipants() {
		return participants;
	}


	
	public void setParticipants(List<EnParticipant> participants) {
		this.participants = participants;
	}



	public List<EnCategory> getCategories() {
		return categories;
	}



	public void setCategories(List<EnCategory> categories) {
		this.categories = categories;
	}



	public List<EnControlMonthly> getClosings() {
		return closings;
	}



	public void setClosings(List<EnControlMonthly> closings) {
		this.closings = closings;
	}
	
	
}
