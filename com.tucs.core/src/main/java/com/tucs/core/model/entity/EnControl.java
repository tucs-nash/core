package com.tucs.core.model.entity;

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

@Entity
@Table(name="EN_CONTROL")
public class EnControl extends BaseModel {
	
	public enum TypeSplit {
		PER_GROUP,
		PER_PERSON
	}
	
	private static final long serialVersionUID = 1612200128795081944L;
	
	@Id
	@SequenceGenerator(name="EN_CONTROL_SQ", sequenceName="EN_CONTROL_SQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EN_CONTROL_SQ")
	@Column(name="ID")
	private Long id;
	
	@NotNull
	@Column(nullable=false, length=50, name="NAME")
	private String name;
	
	@Column(length=255, name="DESCRIPTION")
	private String description;

	@NotNull
	@Column(nullable=false,name="START_DAY")
	private Long startDay;

	@NotNull
	@Column(nullable=false,name="TYPE_SPLIT")
	private TypeSplit typeSplit;
	
	@NotNull
	@Column(nullable=false,name="HAS_CLOSING")
	private Boolean hasClosing;

	@NotNull
	@Column(nullable=false,name="HAS_SAVINGS")
	private Boolean hasSaving;

	@Column(name="BALANCE_DEFAULT", precision=12, scale=4)
	private Double balanceDefault;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="CURRENCY_ID")
	private TyCurrency currency;
	
	@NotNull
	@Column(nullable=false, name="DELETED")
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
	
	public EnControl() {} 
	public EnControl(Long id) {super(id);} 
	
	public EnControl(Long id, String name,
			String description, Long startDay,
			TypeSplit typeSplit, Boolean hasClosing,
			Boolean hasSaving, Double balanceDefault,
			TyCurrency currency, Boolean deleted,
			LocalDateTime createdDate, EnUser createdUser,
			LocalDateTime updatedDate, EnUser updatedUser) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDay = startDay;
		this.typeSplit = typeSplit;
		this.hasClosing = hasClosing;
		this.hasSaving = hasSaving;
		this.balanceDefault = balanceDefault;
		this.currency = currency;
		this.deleted = deleted;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.updatedDate = updatedDate;
		this.updatedUser = updatedUser;
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
	
	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}

	
	public Long getStartDay() {
		return startDay;
	}

	public void setStartDay(Long startDay) {
		this.startDay = startDay;
	}
	
	public Boolean getHasClosing() {
		return hasClosing;
	}

	
	public void setHasClosing(Boolean hasClosing) {
		this.hasClosing = hasClosing;
	}

	
	public Boolean getHasSaving() {
		return hasSaving;
	}

	
	public void setHasSaving(Boolean hasSaving) {
		this.hasSaving = hasSaving;
	}

	
	public Double getBalanceDefault() {
		return balanceDefault;
	}

	public void setBalanceDefault(Double balanceDefault) {
		this.balanceDefault = balanceDefault;
	}

	public TyCurrency getCurrency() {
		return currency;
	}

	public void setCurrency(TyCurrency currency) {
		this.currency = currency;
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
