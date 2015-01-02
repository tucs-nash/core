package com.tucs.core.model.deprecated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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


@Entity
@Table(name="TY_PARAMETER")
@Deprecated
public class TyParameter extends BaseModel{
	
	private static final long serialVersionUID = 1289376955752622843L;

	public enum GroupParameter {
		DEFAULT
	}

	@Id
	@Column(name="ID")
	private Long id;
	
	@NotNull
	@Column(length=20, name="CODE")
	private String code;
	
	@NotNull
	@Column(name="DELETED")
	private Boolean deleted;
	
	@NotNull
	@Column(length=100, name="DESCRIPTION")
	private String description;

	@NotNull
	@Column(length=1000, name="VALUE")
	private String value;

	@NotNull
	@Column(length=1, name="TYPE_VALUE")
	private Character typeValue;

	@NotNull
	@Column(length=10, name="GROUP_PARAMETER")
	@Enumerated(EnumType.STRING)
	private GroupParameter groupParameter;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	@Column(name="UPDATED_DATE")
	private LocalDateTime updatedDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UPDATED_USER_ID")
	private EnUser updatedUser;
		
	public TyParameter() {
	}
	
	public TyParameter(Long id) {
		this.id = id;
	}
	
	public TyParameter(Long id, String code,
			Boolean deleted, String description,
			String value, Character typeValue,
			GroupParameter groupParameter, LocalDateTime updatedDate, EnUser updatedUser) {
		this.id = id;
		this.code = code;
		this.deleted = deleted;
		this.description = description;
		this.value = value;
		this.typeValue = typeValue;
		this.groupParameter = groupParameter;
		this.updatedDate = updatedDate;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public Boolean getDeleted() {
		return deleted;
	}
	
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
