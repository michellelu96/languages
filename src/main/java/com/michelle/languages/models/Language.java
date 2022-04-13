package com.michelle.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "languages")
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=3, max=20, message = "Name must be at least 3 and smaller than 20 characters")
	private String name;
	
	@NotNull
	@Size(min=5, max=20, message = "Creator Name must be at least 3 and smaller than 20 characters")
	private String creatorName;
	
    @NotNull
    @Min(value=0, message="Version must be bigger than 0")
    private Double version;
	
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Language() {}
    public Language(String name, String creatorName, Double version) {
    	this.name = name;
    	this.creatorName = creatorName;
    	this.version = version;
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
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public Double getVersion() {
		return version;
	}
	public void setVersion(Double version) {
		this.version = version;
	}
	@PreUpdate
    protected void onUpdate(){
    	this.updatedAt = new Date();
    }
    
    @PrePersist
    protected void onCreate(){
    	this.createdAt = new Date();
    }
    
    
}
    
