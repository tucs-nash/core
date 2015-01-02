package com.tucs.core.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by farrells on 29/07/2014.
 */
@Entity
@Table(name = "TY_CURRENCY")
public class TyCurrency extends BaseModel {

	private static final long serialVersionUID = 4207132497882247544L;

	@Id
	@Column(name="ID", updatable=false, insertable=false)
	private Long id;

    @NotNull
    @Column(nullable=false, length=50, name="NAME", updatable=false, insertable=false)
    protected String name;

    @NotNull
    @Column(nullable=false, length=20, name="CODE", updatable=false, insertable=false)
    protected String code;

    @Column(length=10, name="SYMBOL", updatable=false, insertable=false)
    protected String symbol;
    
    @Column(nullable=false, name="SYMBOL_BEFORE", updatable=false, insertable=false)
    protected Boolean symbolBefore;
    
    @Column(nullable=false, name="ACTIVE", updatable=false, insertable=false)
    protected Boolean active;

    public TyCurrency() {} 
	public TyCurrency(Long id) {super(id);} 

    public TyCurrency(Long id, String name, String code,
			String symbol, Boolean symbolBefore,
			Boolean active) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.symbol = symbol;
		this.symbolBefore = symbolBefore;
		this.active = active;
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
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public Boolean getSymbolBefore() {
		return symbolBefore;
	}
	
	public void setSymbolBefore(Boolean symbolBefore) {
		this.symbolBefore = symbolBefore;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}

 }
