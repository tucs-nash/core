package com.tucs.core.commons.dto;

import java.util.List;

import com.tucs.core.model.entity.TyCurrency;
import com.tucs.core.model.entity.EnControl.AutomaticClosing;
import com.tucs.core.model.entity.EnControl.TypeSplit;
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
		this.languages = languages;
	}

	public TypeUser[] getAccounts() {
		return accounts;
	}

	public void setAccounts(TypeUser[] accounts) {
		this.accounts = accounts;
	}
	
}
