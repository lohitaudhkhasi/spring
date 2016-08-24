package com.spring.employee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.spring.employee.Employee;
import com.spring.employee.service.EmployeeService;
import com.spring.employee.validator.EmployeeValidator;

@Controller
public class EmployeeController {
	
	private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	EmployeeValidator empValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(empValidator);
	}
	
	@RequestMapping(value="/empMgmt", method = RequestMethod.GET)
	public String showEmpManagement(Model model) {
		logger.debug("index()");
		return "redirect:/employees";
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String showAllEmployees(Model model) {
		logger.debug("showAllEmployees()");
		model.addAttribute("employees", empService.findAll());
		return "employee/list";
	}
	
	@RequestMapping(value = "/employee/add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {
		logger.debug("showAllEmployeeForm()");
		Employee emp = new Employee();
		emp.setEmpId(1);
		emp.setEmpName("SampleName");
		model.addAttribute("empForm", emp);
		return "employee/empform";
	}
	
	@RequestMapping(value = "/employee/save", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated Employee employee,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		logger.debug("saveOrUpdateUser() : {}", employee);
		if (result.hasErrors()) {
			employee.setEmpId(1);
			employee.setEmpName("SampleName");
			model.addAttribute("empForm", employee);
			return "employee/add";
		} else {
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "User added successfully!");
		}
		empService.saveOrUpdate(employee);
		return "employees";
	}

}
