package com.tucs.core.commons.enums;


public enum ProfileEnum {
	ADMIN(1L),
	ADMIN_GROUP(2L),
	USER_GROUP(3L)
	;
	
	private final Long id;
	
	private ProfileEnum(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}
