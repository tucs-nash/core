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
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.joda.ser.LocalDateTimeSerializer;
import com.tucs.core.model.util.LocalDateSerializer;

@Entity
@Table(name="EN_CONTROL_MONTHLY")
public class EnControlMonthly extends BaseModel {
	
	
	private static final long serialVersionUID = -3057657265126181168L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")	
	@Column(name="ID", length=255)
	private String id;
	
	@NotNull
	@Column(nullable=false, name="MONTH")
	private Long month;

	@NotNull
	@Column(nullable=false, name="YEAR")
	private Long year;
	
	@NotNull
	@Column(nullable=false, name="BALANCE_REVENUE", precision=12, scale=4)
	private Double balanceRevenue;
	
	@NotNull
	@Column(nullable=false, name="BALANCE_EXPENSE", precision=12, scale=4)
	private Double balanceExpense;
	
	@NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(nullable = false, name="START_DATE")
	protected LocalDate startDate;

	@NotNull
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@Column(nullable = false, name="END_DATE")
	protected LocalDate endDate;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=false, name="CONTROL_ID")
	private EnControl control;

	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(nullable=false, name="GROUP_ID")
	private EnGroup group;
	
	@NotNull
	@Column(nullable=false,name="CURRENT_MONTHLY")
	private Boolean currentMonthly;
	
	@NotNull
	@Column(nullable=false,name="CLOSED")
	private Boolean closed;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@Column(name="CLOSED_DATE")
	private LocalDateTime closedDate;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@Column(name="UPDATED_DATE")
	private LocalDateTime updatedDate;
	
	public EnControlMonthly() {} 
	public EnControlMonthly(String id) {this.id = id;}
	
	public EnControlMonthly(String id, Long month,
			Long year, Double balanceRevenue,
			Double balanceExpense, LocalDate startDate,
			LocalDate endDate, EnControl control,
			EnGroup group, Boolean currentMonthly,
			Boolean closed, LocalDateTime closedDate,
			LocalDateTime updatedDate, EnUser updatedUser) {
		this.id = id;
		this.month = month;
		this.year = year;
		this.balanceRevenue = balanceRevenue;
		this.balanceExpense = balanceExpense;
		this.startDate = startDate;
		this.endDate = endDate;
		this.control = control;
		this.group = group;
		this.currentMonthly = currentMonthly;
		this.closed = closed;
		this.closedDate = closedDate;
		this.updatedDate = updatedDate;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Long getMonth() {
		return month;
	}
	
	public void setMonth(Long month) {
		this.month = month;
	}
	
	public Long getYear() {
		return year;
	}
	
	public void setYear(Long year) {
		this.year = year;
	}
	
	public Double getBalanceRevenue() {
		return balanceRevenue;
	}
	
	public void setBalanceRevenue(Double balanceRevenue) {
		this.balanceRevenue = balanceRevenue;
	}
	
	public Double getBalanceExpense() {
		return balanceExpense;
	}
	
	public void setBalanceExpense(Double balanceExpense) {
		this.balanceExpense = balanceExpense;
	}
	
	public LocalDate getStartDate() {
		return startDate;
	}
	
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	public LocalDate getEndDate() {
		return endDate;
	}
	
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public EnControl getControl() {
		return control;
	}
	
	public void setControl(EnControl control) {
		this.control = control;
	}
	
	public EnGroup getGroup() {
		return group;
	}
	
	public void setGroup(EnGroup group) {
		this.group = group;
	}
	
	public Boolean getCurrentMonthly() {
		return currentMonthly;
	}
	
	public void setCurrentMonthly(Boolean currentMonthly) {
		this.currentMonthly = currentMonthly;
	}
	
	public Boolean getClosed() {
		return closed;
	}
	
	public void setClosed(Boolean closed) {
		this.closed = closed;
	}
	
	public LocalDateTime getClosedDate() {
		return closedDate;
	}
	
	public void setClosedDate(LocalDateTime closedDate) {
		this.closedDate = closedDate;
	}
	
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
		
}
