package com.monstarlab.domain.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.joda.time.Years;

@Entity
@Table(name = "employee")
public class Employee {

	// variable for id
	@Id
	private String employeeId;

	// variable for surname
	@Size(min = 1, max = 5, message = "surname have to be between 1 and 5 characters")
	@Column(name = "surname")
	private String surName;

	// variable for name
	@NotNull
	@Size(min = 1, max = 5, message = "name have to be between 1 and 5 characters")
	@Column(name = "name")
	private String name;

	// variable for surname in kana
	@NotNull
	@Size(min = 1, max = 10, message = "surname in kana have to be between 1 and 10 characters")
	@Column(name = "surname_kana")
	private String surNameKana;

	// variable for name in kana
	@Size(min = 1, max = 10, message = "name have to be between 1 and 10 characters")
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
	@Size(min=1, max=1000, message="Self-desctiption have to be between 1 and 1000 characters")
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
	
	public int getAge(){
		
		String dateString = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		dateString = formatter.format(birthdate);
		
		//INTO SEPERATE VARIABLES
		int yearDOB = Integer.parseInt(dateString.substring(0, 4));
		int monthDOB = Integer.parseInt(dateString.substring(5, 7));
		int dayDOB = Integer.parseInt(dateString.substring(8, 10));
		
		LocalDate birthdateLocal = new LocalDate (yearDOB, monthDOB, dayDOB);
		LocalDate now = new LocalDate();
		Years age = Years.yearsBetween(birthdateLocal, now);
		int ageInt = age.getYears();
		System.out.println(ageInt);
		
		return ageInt;
	}
}
