package com.tucs.core.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TY_LANGUAGE")
public class TyLanguage extends BaseModel {

	private static final long serialVersionUID = -3910204238162261529L;

	@Id
	@Column(name="ID", updatable=false, insertable=false)
	private Long id;

    @NotNull
    @Column(nullable=false, length=50, name="NAME", updatable=false, insertable=false)
    protected String name;

    @NotNull
    @Column(nullable=false, length=20, name="CODE", updatable=false, insertable=false)
    protected String code;

    public TyLanguage() {} 
	public TyLanguage(Long id) {this.id = id;} 

    public TyLanguage(Long id, String name, String code) {
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
}
