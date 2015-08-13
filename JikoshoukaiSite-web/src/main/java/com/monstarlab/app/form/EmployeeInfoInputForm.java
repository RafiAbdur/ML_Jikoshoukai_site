package com.monstarlab.app.form;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.monstarlab.domain.model.Employee;



public class EmployeeInfoInputForm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Employee employee;
	
	private int birthDate;
	
	private int birthMonth;
	
	private int birthYear;
	
	private String selfIntroduction;

	
	//Variable for storing the genders : (i) Male (ii) Female
		private List<String> genderList;
		
		public EmployeeInfoInputForm(){
			genderList = Arrays.asList("Male", "Female");
		}

	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}

	public int getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public List<String> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<String> genderList) {
		this.genderList = genderList;
	}

	public String getSelfIntroduction() {
		return selfIntroduction;
	}

	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}

	
	
}
