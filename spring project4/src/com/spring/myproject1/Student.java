package com.spring.myproject1;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstname;
	private String lastname;
	private String country;
	private LinkedHashMap<String,String> countryoptions;
	private String favlang;
	private String[] operatingsystem;
	public Student() {
		//insert country options
		countryoptions=new LinkedHashMap<>();
		countryoptions.put("IN","India");
		countryoptions.put("US","United States Of America");
		countryoptions.put("CN","China");
		countryoptions.put("RS","Russia");
	}
	
	

	
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




	public String getCountry() {
		return country;
	}




	public void setCountry(String country) {
		this.country = country;
	}




public LinkedHashMap<String, String> getCountryoptions() {
		return countryoptions;
	}
	public String getFavlang() {
		return favlang;
	}
	public void setFavlang(String favlang) {
		this.favlang = favlang;
	}
	public String[] getOperatingsystem() {
		return operatingsystem;
	}
	public void setOperatingsystem(String[] operatingsystem) {
		this.operatingsystem = operatingsystem;
	}
	
	
}
	
	


