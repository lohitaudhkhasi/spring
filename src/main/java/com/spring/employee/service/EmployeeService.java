package com.spring.employee.service;

import java.util.List;

import com.spring.employee.Employee;

public interface EmployeeService {
	void saveOrUpdate(Employee emp);
	void delete (Employee emp);
	List<Employee> findAll();
}
