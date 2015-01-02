package com.tucs.core.model.entity.profile;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.tucs.core.model.entity.BaseModel;


@Entity
@Table(name="TY_PRIVILEGE")
public class TyPrivilege extends BaseModel{
	
	private static final long serialVersionUID = -2267532272699366075L;

	@Id
	@Column(name="ID", updatable=false, insertable=false)
	private Long id;
	
	@NotNull
	@Column(nullable=false, length=50, name="NAME", updatable=false, insertable=false)
	private String name;
	
	@NotNull
	@Column(nullable=false, length=20, name="CODE", updatable=false, insertable=false)
	private String code;
	
	@NotNull
	@Column(nullable=false, length=255, name="DESCRIPTION", updatable=false, insertable=false)
	private String description;

	@NotNull
	@Column(nullable=false, name="DELETED", updatable=false, insertable=false)
	private Boolean deleted;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "privilege")
    private List<JnProfilePriv> profilePrivs;
	
	public TyPrivilege() {} 
	public TyPrivilege(Long id) {super(id);} 
	
	public TyPrivilege(Long id, String name, String code,
			String description, Boolean deleted,
			List<JnProfilePriv> profilePrivs) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.description = description;
		this.deleted = deleted;
		this.profilePrivs = profilePrivs;
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

	
	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	
	public Boolean getDeleted() {
		return deleted;
	}

	
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	
	public List<JnProfilePriv> getProfilePrivs() {
		return profilePrivs;
	}

	
	public void setProfilePrivs(List<JnProfilePriv> profilePrivs) {
		this.profilePrivs = profilePrivs;
	}
	
	
}
