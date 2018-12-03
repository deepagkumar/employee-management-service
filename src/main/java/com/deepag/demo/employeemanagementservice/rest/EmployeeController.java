package com.deepag.demo.employeemanagementservice.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deepag.demo.employeemanagementservice.model.Employee;
import com.deepag.demo.employeemanagementservice.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void saveEmployee(@RequestBody @Valid Employee employee) {
		empService.saveEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/all")
	public List<Employee> getAll() {
		return empService.getAll();
	}

}
