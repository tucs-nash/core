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
@Table(name="EN_TRANSACTION")
public class EnTransaction extends BaseModel {
	
	private static final long serialVersionUID = 1612200128795081944L;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")	
	@Column(name="ID", length=255)
	private String id;

	@Column(nullable=false, length=255, name="DESCRIPTION")
	private String description;

	@NotNull
	@Column(nullable=false, name="VALUE", precision=12, scale=4)
	private Double value;
	
	@NotNull
	@Column(length=1, nullable=false,name="MONTHLY")
	private Character type;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@NotNull
	@Column(nullable = false, name="DATE_TRANSACTION")
	private LocalDateTime dateTransaction;
	
	@NotNull
	@Column(nullable=false,name="SCHEDULED")
	private Boolean scheduled;
	
	@Column(name="TRANCHE_CURRENT")
	private Long trancheCurrent;
	
	@Column(name="TRANCHE_END")
	private Long trancheEnd;

	@NotNull
	@Column(nullable=false,name="NOTIFICATION")
	private Boolean notification;

	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="CONTROL_MONTHLY_ID")
	private EnControlMonthly controlMonthly;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false, name="CONTROL_ID")
	private EnControl control;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false, name="CATEGORY_ID")
	private EnCategory category;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BASED_TRANSACTION_ID")
	private EnTransaction basedTransaction;
	
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

	public EnTransaction() {} 
	public EnTransaction(String id) {this.id = id;} 
	
	public EnTransaction(String id, String description,
			Double value, Character type,
			LocalDateTime dateTransaction,
			Boolean scheduled, Long trancheCurrent,
			Long trancheEnd, Boolean notification,
			EnControlMonthly controlMonthly,
			EnControl control, EnCategory category,
			EnTransaction basedTransaction,
			LocalDateTime createdDate, EnUser createdUser,
			LocalDateTime updatedDate, EnUser updatedUser) {
		this.id = id;
		this.description = description;
		this.value = value;
		this.type = type;
		this.dateTransaction = dateTransaction;
		this.scheduled = scheduled;
		this.trancheCurrent = trancheCurrent;
		this.trancheEnd = trancheEnd;
		this.notification = notification;
		this.controlMonthly = controlMonthly;
		this.control = control;
		this.category = category;
		this.basedTransaction = basedTransaction;
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

	
	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	
	public Double getValue() {
		return value;
	}

	
	public void setValue(Double value) {
		this.value = value;
	}

	
	public Character getType() {
		return type;
	}

	
	public void setType(Character type) {
		this.type = type;
	}

	
	public LocalDateTime getDateTransaction() {
		return dateTransaction;
	}

	
	public void setDateTransaction(LocalDateTime dateTransaction) {
		this.dateTransaction = dateTransaction;
	}

	
	public Boolean getScheduled() {
		return scheduled;
	}

	
	public void setScheduled(Boolean scheduled) {
		this.scheduled = scheduled;
	}

	
	public Long getTrancheCurrent() {
		return trancheCurrent;
	}

	
	public void setTrancheCurrent(Long trancheCurrent) {
		this.trancheCurrent = trancheCurrent;
	}

	
	public Long getTrancheEnd() {
		return trancheEnd;
	}

	
	public void setTrancheEnd(Long trancheEnd) {
		this.trancheEnd = trancheEnd;
	}

	
	public Boolean getNotification() {
		return notification;
	}

	
	public void setNotification(Boolean notification) {
		this.notification = notification;
	}

	
	public EnControlMonthly getControlMonthly() {
		return controlMonthly;
	}

	
	public void setControlMonthly(
			EnControlMonthly controlMonthly) {
		this.controlMonthly = controlMonthly;
	}

	
	public EnControl getControl() {
		return control;
	}

	
	public void setControl(EnControl control) {
		this.control = control;
	}

	
	public EnCategory getCategory() {
		return category;
	}

	
	public void setCategory(EnCategory category) {
		this.category = category;
	}

	
	public EnTransaction getBasedTransaction() {
		return basedTransaction;
	}

	
	public void setBasedTransaction(
			EnTransaction basedTransaction) {
		this.basedTransaction = basedTransaction;
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
