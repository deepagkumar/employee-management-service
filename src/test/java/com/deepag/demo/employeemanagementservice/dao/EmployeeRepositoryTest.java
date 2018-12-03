package com.deepag.demo.employeemanagementservice.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.deepag.demo.employeemanagementservice.model.Employee;
import com.deepag.demo.employeemanagementservice.service.EmployeeService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@MockBean
	private EmployeeService employeeService;
	
	@Test
	public void testSave() {
		Employee emp1 = new Employee();
		emp1.setFirstName("FN1");
		emp1.setLastName("LN1");
		emp1.setAddress("Address 1");
		emp1.setAge(25);
		emp1.setDateOfBirth(new Date());
		employeeRepository.save(emp1);
		assert(true);
	}
	
	@Test
	public void testFindAll() {
		Employee emp1 = new Employee();
		emp1.setFirstName("FN1");
		emp1.setLastName("LN1");
		emp1.setAddress("Address 1");
		emp1.setAge(25);
		emp1.setDateOfBirth(new Date());
		employeeRepository.save(emp1);
		List<Employee> empList = employeeRepository.findAll();
		Assert.assertEquals(1, empList.size());
	}

	

}
