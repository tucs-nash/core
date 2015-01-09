package com.tucs.core.commons.dto;

import java.util.List;

import com.tucs.core.model.entity.EnControl;
import com.tucs.core.model.entity.EnGroup;
import com.tucs.core.model.entity.EnParticipant;


public class ControlDetailsDto {
	
	private EnControl control;
	private List<EnGroup> groups;
	private List<EnParticipant> participants;
	
	
	public ControlDetailsDto() {
	}


	
	public EnControl getControl() {
		return control;
	}


	
	public void setControl(EnControl control) {
		this.control = control;
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
	
	
}
