package com.monstarlab.domain.form;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.monstarlab.domain.model.Employee;

public class SearchEmployeeForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private Employee employee;

	private String keyword;

	private int age;

	//Variable for storing the genders : (i) Male (ii) Female
	private List<String> genderList;
	
	public SearchEmployeeForm(){
		genderList = Arrays.asList("Male", "Female");
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getGenderList() {
		return genderList;
	}

	public void setGenderList(List<String> genderList) {
		this.genderList = genderList;
	}

}
