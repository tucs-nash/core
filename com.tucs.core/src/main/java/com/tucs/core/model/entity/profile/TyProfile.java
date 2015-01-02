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
@Table(name="TY_PROFILE")
public class TyProfile extends BaseModel {

	private static final long serialVersionUID = -9123537345469184645L;

	@Id
	@Column(name="ID", updatable=false, insertable=false)
	private Long id;
	
	@NotNull
	@Column(nullable=false, name="NAME", length=50, updatable=false, insertable=false)
	private String name;
	
	@NotNull
	@Column(nullable=false, name="CODE", length=20, updatable=false, insertable=false)
	private String code;
	
	@NotNull
	@Column(nullable=false, name="DELETED", updatable=false, insertable=false)
	private Boolean deleted;
	
	@NotNull
	@Column(nullable=false, name="DESCRIPTION", length=255, updatable=false, insertable=false)
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "profile")
    private List<JnProfilePriv> profilePrivs;
	
	public TyProfile() {} 
	public TyProfile(Long id) {super(id);} 
	
	public TyProfile(Long id, String name, String code,
			Boolean deleted, String description,
			List<JnProfilePriv> profilePrivs) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.deleted = deleted;
		this.description = description;
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

	
	public Boolean getDeleted() {
		return deleted;
	}

	
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	
	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	
	public List<JnProfilePriv> getProfilePrivs() {
		return profilePrivs;
	}

	
	public void setProfilePrivs(List<JnProfilePriv> profilePrivs) {
		this.profilePrivs = profilePrivs;
	}
	
}
