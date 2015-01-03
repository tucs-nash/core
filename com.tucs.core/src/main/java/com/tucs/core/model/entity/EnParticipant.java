package com.tucs.core.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.joda.ser.LocalDateTimeSerializer;
import com.tucs.core.model.entity.profile.TyProfile;

@Entity
@Table(name="EN_PARTICIPANT")
public class EnParticipant extends BaseModel {
	
	private static final long serialVersionUID = -4125460570021501677L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")	
	@Column(name="ID", length=255)
	private String id;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="USER_ID")
	private EnUser user;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="PROFILE_ID")
	private TyProfile profile;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="GROUP_ID")
	private EnGroup group;
	
	@NotNull
	@Column(nullable=false,name="DELETED")
	private Boolean deleted;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@NotNull
	@Column(nullable = false, name="CREATED_DATE", updatable=false)
	private LocalDateTime createdDate;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false, name="CREATED_USER_ID", updatable=false)
	private EnUser createdUser;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@Column(name="UPDATED_DATE")
	private LocalDateTime updatedDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UPDATED_USER_ID")
	private EnUser updatedUser;
	
	public EnParticipant() {} 
	public EnParticipant(String id) {this.id = id;} 
	
	public EnParticipant(String id, EnUser user,
			TyProfile profile, EnGroup group,
			Boolean deleted, LocalDateTime createdDate,
			EnUser createdUser, LocalDateTime updatedDate,
			EnUser updatedUser) {
		this.id = id;
		this.user = user;
		this.profile = profile;
		this.group = group;
		this.deleted = deleted;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.updatedDate = updatedDate;
		this.updatedUser = updatedUser;
	}


	public String getId() {
		return id;
	}

	
	public void setId(String id) {
		this.id = id;
	}

	
	public EnUser getUser() {
		return user;
	}

	
	public void setUser(EnUser user) {
		this.user = user;
	}

	
	public TyProfile getProfile() {
		return profile;
	}

	
	public void setProfile(TyProfile profile) {
		this.profile = profile;
	}

	
	public EnGroup getGroup() {
		return group;
	}

	
	public void setGroup(EnGroup group) {
		this.group = group;
	}

	
	public Boolean getDeleted() {
		return deleted;
	}

	
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	
	public EnUser getCreatedUser() {
		return createdUser;
	}

	
	public void setCreatedUser(EnUser createdUser) {
		this.createdUser = createdUser;
	}

	
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	
	public EnUser getUpdatedUser() {
		return updatedUser;
	}

	
	public void setUpdatedUser(EnUser updatedUser) {
		this.updatedUser = updatedUser;
	}

}
