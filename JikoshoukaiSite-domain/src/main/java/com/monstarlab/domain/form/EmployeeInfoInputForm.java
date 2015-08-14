package com.monstarlab.domain.form;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.monstarlab.domain.model.Employee;

public class EmployeeInfoInputForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private Employee employee;

	private String birthdate;

	// Variable for storing the genders : (i) Male (ii) Female
	private List<String> genderList;

	public EmployeeInfoInputForm() {
		genderList = Arrays.asList("Male", "Female");
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<String> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<String> genderList) {
		this.genderList = genderList;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	

}
