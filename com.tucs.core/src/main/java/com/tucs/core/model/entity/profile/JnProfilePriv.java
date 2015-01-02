package com.tucs.core.model.entity.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.joda.ser.LocalDateTimeSerializer;
import com.tucs.core.model.entity.BaseModel;

@Entity
@Table(name="JN_PROFILE_PRIV")
public class JnProfilePriv extends BaseModel {
	
	private static final long serialVersionUID = 4680796453847847144L;

	@Id
	@SequenceGenerator(name="JN_PROFILE_PRIV_SQ", sequenceName="JN_PROFILE_PRIV_SQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JN_PROFILE_PRIV_SQ")	
	@Column(name="ID", updatable=false, insertable=false)
	private Long id;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="PROFILE_ID", updatable=false, insertable=false)
	private TyProfile profile;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="PRIVILEGE_ID", updatable=false, insertable=false)
	private TyPrivilege privilege;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@NotNull
	@Column(nullable = false, name="CREATED_DATE", updatable=false, insertable=false)
	private LocalDateTime createdDate;

	public JnProfilePriv() {} 
	public JnProfilePriv(Long id) {super(id);} 
	
	public JnProfilePriv(Long id, TyProfile profile, TyPrivilege privilege, LocalDateTime createdDate) {
		this.id = id;
		this.profile = profile;
		this.privilege = privilege;
		this.createdDate = createdDate;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public TyProfile getProfile() {
		return profile;
	}

	
	public void setProfile(TyProfile profile) {
		this.profile = profile;
	}

	
	public TyPrivilege getPrivilege() {
		return privilege;
	}

	
	public void setPrivilege(TyPrivilege privilege) {
		this.privilege = privilege;
	}

	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
