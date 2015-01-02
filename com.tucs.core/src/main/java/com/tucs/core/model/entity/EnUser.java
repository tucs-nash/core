package com.tucs.core.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="EN_USER")
public class EnUser extends BaseModel {

	private static final long serialVersionUID = 4172343689115020486L;
	
	public enum TypeUser {
		ADMIN,
		PREMIUM,
		NORMAL
	}

	@Id
	@SequenceGenerator(name="EN_USER_SQ", sequenceName="EN_USER_SQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EN_USER_SQ")
	@Column(name="ID")
	private Long id;
	
	@NotNull
	@Column(nullable=false, length=255, name="FIRSTNAME")
	private String firstName;
	
	@NotNull
	@Column(nullable=false, length=255, name="LASTNAME")
	private String lastName;
	
	@NotNull
	@Column(nullable=false, length=255, name="PASSWORD")
	private String password;
	
	@NotNull
	@Column(nullable=false, length=50, name="EMAIL", unique=true, updatable=false)
	private String email;
	
	@NotNull
	@Column(name="TYPE_USER")
	private TypeUser typeUser;
		
	@Column(length=20, name="PHONE")
	private String phone;
	@NotNull
	@Column(nullable=false, name="DELETED")
	private Boolean deleted;

	@NotNull
	@Column(nullable=false, name="FORGOT_PASSWORD")
	private Boolean forgotPassword;

	@Column(length=10,name="LANGUAGE")
	private String language;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@NotNull
	@Column(nullable = false, name="CREATED_DATE", updatable=false)
	private LocalDateTime createdDate;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@Column(name="UPDATED_DATE")
	private LocalDateTime updatedDate;	
	
	public EnUser() {} 
	public EnUser(Long id) {super(id);} 
	
	public EnUser(Long id, String firstName,
			String lastName, String password, String email,
			TypeUser typeUser, String phone,
			Boolean deleted, Boolean forgotPassword,
			String language, LocalDateTime createdDate,
			LocalDateTime updatedDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.typeUser = typeUser;
		this.phone = phone;
		this.deleted = deleted;
		this.forgotPassword = forgotPassword;
		this.language = language;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public TypeUser getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(TypeUser typeUser) {
		this.typeUser = typeUser;
	}
	public String getPhone() {
		return phone;
	}

	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public Boolean getDeleted() {
		return deleted;
	}

	
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	
	public Boolean getForgotPassword() {
		return forgotPassword;
	}

	
	public void setForgotPassword(Boolean forgotPassword) {
		this.forgotPassword = forgotPassword;
	}

	
	public String getLanguage() {
		return language;
	}

	
	public void setLanguage(String language) {
		this.language = language;
	}

	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
}
