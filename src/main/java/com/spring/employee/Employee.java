package com.spring.employee;

import java.util.List;

import com.spring.project.Project;

public class Employee {

	private String empName;
	private int empId;
	
	//private List<Project> projects;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

/*	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}*/

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId /*+ ", projects=" + projects + "]"*/;
	}
	
	
}
