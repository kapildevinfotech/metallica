package com.metallica.refdata.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commodity {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String code;
	private String description;
	
	public Commodity() {
		
	}
	
	public Commodity(String code,String description) {
		this.code=code;
		this.description=description;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
