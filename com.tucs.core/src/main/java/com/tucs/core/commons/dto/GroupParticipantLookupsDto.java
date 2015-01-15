package com.tucs.core.commons.dto;

import java.util.List;

import com.tucs.core.model.entity.EnGroup;
import com.tucs.core.model.entity.profile.TyProfile;


public class GroupParticipantLookupsDto {
	
	private List<TyProfile> profiles;
	private String nameControl;
	private EnGroup group;
	
	public GroupParticipantLookupsDto() {

	}

	public String getNameControl() {
		return nameControl;
	}

	
	public void setNameControl(String nameControl) {
		this.nameControl = nameControl;
	}

	public List<TyProfile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<TyProfile> profiles) {
		this.profiles = profiles;
	}

	public EnGroup getGroup() {
		return group;
	}

	public void setGroup(EnGroup group) {
		this.group = group;
	}
}
