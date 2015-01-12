package com.tucs.core.commons.dto;

import java.util.List;

import com.tucs.core.model.entity.EnUser.TypeUser;
import com.tucs.core.model.entity.TyLanguage;

public class UserLookupsDto {
	
	private List<TyLanguage> languages;
	private TypeUser[] accounts;
	
	public UserLookupsDto() {
		this.accounts = TypeUser.values();	
	}
	
	public UserLookupsDto(List<TyLanguage> languages){
		this();
		this.setLanguages(languages);
	}

	public TypeUser[] getAccounts() {
		return accounts;
	}

	public void setAccounts(TypeUser[] accounts) {
		this.accounts = accounts;
	}

	public List<TyLanguage> getLanguages() {
		return languages;
	}

	public void setLanguages(List<TyLanguage> languages) {
		this.languages = languages;
	}
	
}
