package com.tucs.core.model.entity;

import java.io.Serializable;
import java.lang.reflect.Method;

import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;


public abstract class BaseModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public BaseModel() {
	}
	
	public BaseModel(Long id) {
		setId(id);
	}
	
	/**
	 * Return the Id field value 
	 * Rule: The ID have to be Long
	 */
	@JsonIgnore
	public Long getIdReflection() {
		for (Method method : this.getClass().getDeclaredMethods()) {

		      if (method.getAnnotation(Id.class) != null) {
		    	  try {
		    		  return (Long)method.invoke(this);
		    	  } catch (Exception ex) {
		    		  return null;
		    	  }
		      }

	    }
		return null;
	}
	
	public abstract Long getId();
	public abstract void setId(Long id);
	
}
