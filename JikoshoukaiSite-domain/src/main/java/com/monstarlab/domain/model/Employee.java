package com.monstarlab.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee")
public class Employee {

	// variable for id
	@Id
	private String employeeId;

	// variable for surname
	@Column(name = "surname")
	private String surName;

	// variable for name
	@Column(name = "name")
	private String name;

	// variable for surname in kana
	@Column(name = "surname_kana")
	private String surNameKana;

	// variable for name in kana
	@Column(name = "name_kana")
	private String nameKana;

	// variable for gender
	@Column(name = "gender")
	private String gender;

	// variable for birthdate
	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate")
	private Date birthdate;

	// variable for self-description
	@Column(name = "self_introduction")
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
