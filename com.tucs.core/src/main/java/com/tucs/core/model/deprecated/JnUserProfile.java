package com.tucs.core.model.deprecated;

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
import com.tucs.core.model.entity.EnUser;
import com.tucs.core.model.entity.profile.TyProfile;

@Entity
@Table(name="JN_USER_PROFILE")
@Deprecated
public class JnUserProfile extends BaseModel {
	
	private static final long serialVersionUID = 2057468178254033412L;

	@Id
	@SequenceGenerator(name="JN_USER_PROFILE_SQ", sequenceName="JN_USER_PROFILE_SQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JN_USER_PROFILE_SQ")
	@Column(name="ID", updatable=false)
	private Long id;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="PROFILE_ID", updatable=false)
	private TyProfile profile;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="USER_ID", updatable=false)
	private EnUser user;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@NotNull
	@Column(nullable = false, name="CREATED_DATE", updatable=false)
	private LocalDateTime createdDate;
	
	
	public JnUserProfile() {

	}

	public JnUserProfile(Long id, TyProfile profile,
			EnUser user, LocalDateTime createdDate) {
		this.id = id;
		this.profile = profile;
		this.user = user;
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

	
	public EnUser getUser() {
		return user;
	}

	
	public void setUser(EnUser user) {
		this.user = user;
	}

	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
}
