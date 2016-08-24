package com.spring.employee.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.employee.Employee;

@Component
public class EmployeeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target,Errors errors) {
		Employee emp = (Employee) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empName", "empName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empId", "empId.empty");
		if (emp.getEmpName().length() > 10) {
			errors.reject("empName","empName.longer");
		}
	}

}
