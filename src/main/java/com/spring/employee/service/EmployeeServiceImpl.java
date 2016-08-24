package com.spring.employee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.spring.employee.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	private Map<Integer,Employee> employeeMap = new HashMap<>();
	
	@Override
	public void saveOrUpdate(Employee emp) {
		employeeMap.put(emp.getEmpId(), emp);
	}

	@Override
	public void delete(Employee emp) {
		employeeMap.remove(emp.getEmpId());
	}

	@Override
	public List<Employee> findAll() {
		Iterator<Employee> iterator = employeeMap.values().iterator();
		List<Employee> empList = new ArrayList<>();
		while (iterator.hasNext()) {
			empList.add(iterator.next());
		}
		return empList;
	}

}
