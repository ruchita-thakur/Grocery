/**
 * desc:This is a category bean class having all the details of category
 * @author Suparna Arya
**/
package com.cg.grocerydeliveryapplication.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	@NotBlank(message = "Category name is required")
	private String categoryName;
	@Size(max = 100, message = "Description must be of maximum 100 characters")
	private String categoryDescription;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date created_At;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updated_At;
	
	
	//Default constructor of bean class 
	public Category() {
		super();
	}
	//Parameterized constructor of bean class with fields
	public Category(Long categoryId, @NotBlank(message = "Category name is required") String categoryName,
			@Size(max = 100, message = "Description must be of maximum 100 characters") String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		
	}
  //This field will be persists on create operation
	@PrePersist
	public void onCreated() {
		this.created_At = new Date();
	}
	//This field will be persists on update operation
	@PreUpdate
	public void onUpdate() {
		this.updated_At = new Date();
	}
	
	//Getters and setters of category bean
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCname(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	

}
