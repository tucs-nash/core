package com.tucs.core.commons.dto;

import java.util.List;

import com.tucs.core.model.entity.EnCategory;


public class CategoryLookupsDto {
	
	private List<EnCategory> categories;
	private String nameControl;
	private Boolean hasClosing;
	
	public CategoryLookupsDto() {

	}

	public List<EnCategory> getCategories() {
		return categories;
	}

	
	public void setCategories(List<EnCategory> categories) {
		this.categories = categories;
	}

	
	public String getNameControl() {
		return nameControl;
	}

	
	public void setNameControl(String nameControl) {
		this.nameControl = nameControl;
	}

	
	public Boolean getHasClosing() {
		return hasClosing;
	}

	
	public void setHasClosing(Boolean hasClosing) {
		this.hasClosing = hasClosing;
	}

}
