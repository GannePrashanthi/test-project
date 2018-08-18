package com.spring.myproject1;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.spring.myprojectannotation.CourseCode;

public class Customer {
	private String firstname;
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String lastname;
	
	@NotNull(message="is required")
	@Min(value=1,message="value should be greater than or equal to one")
	@Max(value=10,message="value should be less than or equal to one")
	private Integer freepasses;
	
	@NotNull(message="is required")
	@Pattern(regexp="^[a-zA-Z0-9]{5}",message="only five characters or digits")
	private String postalcode;
	
	@CourseCode
	private String coursecode;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getFreepasses() {
		return freepasses;
	}
	public void setFreepasses(Integer freepasses) {
		this.freepasses = freepasses;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	
	
	
	

}
