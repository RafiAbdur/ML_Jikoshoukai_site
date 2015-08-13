package com.monstarlab.domain.model;

import java.util.Date;

public class Employee {
	//variable for id
	private String employeeId;
	
	// variable for surname
	private String surName;

	// variable for name
	private String name;

	// variable for surname in kana
	private String surNameKana;

	// variable for name in kana
	private String nameKana;

	// variable for gender
	private String gender;

	// variable for birthdate
	private Date birthdate;

	// variable for self-description
	private String selfIntroduction;
	

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurNameKana() {
		return surNameKana;
	}

	public void setSurNameKana(String surNameKana) {
		this.surNameKana = surNameKana;
	}

	public String getNameKana() {
		return nameKana;
	}

	public void setNameKana(String nameKana) {
		this.nameKana = nameKana;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getSelfIntroduction() {
		return selfIntroduction;
	}

	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}

}
