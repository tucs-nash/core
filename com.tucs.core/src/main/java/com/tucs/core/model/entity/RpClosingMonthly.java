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
@Table(name="RP_CLOSING_MONTHLY")
public class RpClosingMonthly extends BaseModel {
	
	private static final long serialVersionUID = -862442219153589632L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")	
	@Column(name="ID", length=255)
	private String id;

	@NotNull
	@Column(nullable=false, name="BALANCE", precision=12, scale=4)
	private Double balance;
	
	@NotNull
	@Column(nullable=false, name="BUDGET", precision=12, scale=4)
	private Double budget;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="CONTROL_MONTHLY_ID")
	private EnControlMonthly controlMonthly;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="CATEGORY_ID")
	private EnCategory category;
	
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
	
    public RpClosingMonthly() {} 
	public RpClosingMonthly(String id) {this.id = id;} 

	public RpClosingMonthly(String id, Double balance,
			Double budget, EnControlMonthly controlMonthly,
			EnCategory category, LocalDateTime createdDate,
			EnUser createdUser, LocalDateTime updatedDate,
			EnUser updatedUser) {
		this.id = id;
		this.balance = balance;
		this.budget = budget;
		this.controlMonthly = controlMonthly;
		this.category = category;
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

	
	public Double getBalance() {
		return balance;
	}

	
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	
	public Double getBudget() {
		return budget;
	}

	
	public void setBudget(Double budget) {
		this.budget = budget;
	}

	
	public EnControlMonthly getControlMonthly() {
		return controlMonthly;
	}

	
	public void setControlMonthly(
			EnControlMonthly controlMonthly) {
		this.controlMonthly = controlMonthly;
	}

	
	public EnCategory getCategory() {
		return category;
	}

	
	public void setCategory(EnCategory category) {
		this.category = category;
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
