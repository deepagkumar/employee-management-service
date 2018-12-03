package com.deepag.demo.employeemanagementservice.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.deepag.demo.employeemanagementservice.dao.EmployeeRepository;
import com.deepag.demo.employeemanagementservice.model.Employee;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
	
	@InjectMocks
	private EmployeeService employeeService;
	
	@Mock
	private EmployeeRepository employeeRepository;

	@Before
	public void setUp() throws Exception {
		Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(null);
		Employee emp = new Employee();
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(emp);
		Mockito.when(employeeRepository.findAll()).thenReturn(empList);
	}
	
	@Test
	public void save() {
		employeeService.saveEmployee(new Employee());
		assert(true);
	}

	@Test
	public void getAll() {
		List<Employee> empList = employeeService.getAll();
		Assert.assertEquals(1, empList.size());
	}

}
