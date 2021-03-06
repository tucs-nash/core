package com.tucs.core.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.joda.ser.LocalDateTimeSerializer;

@Entity
@Table(name="EN_GROUP")
public class EnGroup extends BaseModel {
	
	private static final long serialVersionUID = 3758479333883377705L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")	
	@Column(name="ID", length=255)
	private String id;

	@NotNull
	@Column(nullable=false,length=50, name="NAME")
	private String name;

	@Column(length=255, name="DESCRIPTION")
	private String description;
	
	@NotNull
	@Column(nullable=false, name="AMOUNT_PARTICIPANT")
	private Long amountParticipant;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GROUP_PARENT_ID")
	private EnGroup groupParent;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="CONTROL_ID")
	private EnControl control;

	@NotNull
	@Column(nullable=false,name="DELETED")
	private Boolean deleted;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@Column(nullable = false, name="CREATED_DATE", updatable=false)
	private LocalDateTime createdDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false, name="CREATED_USER_ID", updatable=false)
	private EnUser createdUser;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@Column( name="UPDATED_DATE")
	private LocalDateTime updatedDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UPDATED_USER_ID")
	private EnUser updatedUser;
		
	@OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
	private List<EnParticipant> enParticipants;

	public EnGroup() {} 
	public EnGroup(String id) {this.id = id;} 
		
	public EnGroup(String id, String name,
			Long amountParticipant, String description,
			EnGroup groupParent, EnControl control,
			EnUser ownerUser, Boolean deleted,
			LocalDateTime createdDate, EnUser createdUser,
			LocalDateTime updatedDate, EnUser updatedUser) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.amountParticipant = amountParticipant;
		this.groupParent = groupParent;
		this.control = control;
		this.deleted = deleted;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.updatedDate = updatedDate;
		this.updatedUser = updatedUser;
	}
	
	public EnGroup(String id, String name,
			Long amountParticipant, String description,
			EnGroup groupParent, EnControl control,
			EnUser ownerUser, Boolean deleted,
			LocalDateTime createdDate, EnUser createdUser,
			LocalDateTime updatedDate, EnUser updatedUser,
			List<EnParticipant> enParticipants) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.amountParticipant = amountParticipant;
		this.groupParent = groupParent;
		this.control = control;
		this.deleted = deleted;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.updatedDate = updatedDate;
		this.updatedUser = updatedUser;
		this.enParticipants = enParticipants;
	}
	public String getId() {
		return id;
	}

	
	public void setId(String id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	
	public Long getAmountParticipant() {
		return amountParticipant;
	}
	public void setAmountParticipant(
			Long amountParticipant) {
		this.amountParticipant = amountParticipant;
	}
	public EnGroup getGroupParent() {
		return groupParent;
	}

	
	public void setGroupParent(EnGroup groupParent) {
		this.groupParent = groupParent;
	}

	
	public EnControl getControl() {
		return control;
	}

	
	public void setControl(EnControl control) {
		this.control = control;
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
	public List<EnParticipant> getEnParticipants() {
		return enParticipants;
	}
	public void setEnParticipants(List<EnParticipant> enParticipants) {
		this.enParticipants = enParticipants;
	}

	
}
