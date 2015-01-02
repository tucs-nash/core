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
	@SequenceGenerator(name="EN_CONTROL_MONTHLY_SQ", sequenceName="EN_CONTROL_MONTHLY_SQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EN_CONTROL_MONTHLY_SQ")
	@Column(name="ID")
	private Long id;
	
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
	@JoinColumn(nullable = false, name="START_DATE")
	protected LocalDate startDate;

	@NotNull
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	@JoinColumn(nullable = false, name="END_DATE")
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UPDATED_USER_ID")
	private EnUser updatedUser;
	
	public EnControlMonthly() {} 
	public EnControlMonthly(Long id) {super(id);} 
	
	public EnControlMonthly(Long id, Long month, Long year,
			Double balanceRevenue, Double balanceExpense,
			LocalDate startDate, LocalDate endDate,
			EnControl control, Boolean closed,
			LocalDateTime closedDate,
			LocalDateTime updatedDate, EnUser updatedUser) {
		this.id = id;
		this.month = month;
		this.year = year;
		this.balanceRevenue = balanceRevenue;
		this.balanceExpense = balanceExpense;
		this.startDate = startDate;
		this.endDate = endDate;
		this.control = control;
		this.closed = closed;
		this.closedDate = closedDate;
		this.updatedDate = updatedDate;
		this.updatedUser = updatedUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	
	public EnUser getUpdatedUser() {
		return updatedUser;
	}

	
	public void setUpdatedUser(EnUser updatedUser) {
		this.updatedUser = updatedUser;
	}	
	
	
}
