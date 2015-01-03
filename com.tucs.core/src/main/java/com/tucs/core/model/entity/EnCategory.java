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

@Entity
@Table(name="EN_CATEGORY")
public class EnCategory extends BaseModel {
	
	private static final long serialVersionUID = 731161373035881610L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")	
	@Column(name="ID", length=255)
	private String id;
	
	@NotNull
	@Column(nullable=false, length=50, name="NAME")
	private String name;
	
	@Column(length=100, name="DESCRIPTION")
	private String description;
	
	@NotNull
	@Column(nullable=false, name="BUDGET", precision=12, scale=4)
	private Double budget;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="CONTROL_ID")
	private EnControl control;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CATEGORY_PARENT_ID")
	private EnCategory parent;
	
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
	
	public EnCategory() {} 
	public EnCategory(String id) {this.id = id;} 
	
	public EnCategory(String id, String name,
			String description, Double budget,
			EnControl control, EnCategory parent,
			LocalDateTime createdDate, EnUser createdUser,
			LocalDateTime updatedDate, EnUser updatedUser) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.budget = budget;
		this.control = control;
		this.parent = parent;
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

	
	public Double getBudget() {
		return budget;
	}

	
	public void setBudget(Double budget) {
		this.budget = budget;
	}

	
	public EnControl getControl() {
		return control;
	}

	
	public void setControl(EnControl control) {
		this.control = control;
	}

	
	public EnCategory getParent() {
		return parent;
	}

	
	public void setParent(EnCategory parent) {
		this.parent = parent;
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
