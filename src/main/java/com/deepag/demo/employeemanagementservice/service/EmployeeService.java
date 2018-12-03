package com.deepag.demo.employeemanagementservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepag.demo.employeemanagementservice.dao.EmployeeRepository;
import com.deepag.demo.employeemanagementservice.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;
	
	public void saveEmployee(Employee employee) {
		empRepository.save(employee);
	}

	public List<Employee> getAll() {
		return empRepository.findAll();
	}

}
