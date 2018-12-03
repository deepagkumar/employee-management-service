package com.deepag.demo.employeemanagementservice;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.deepag.demo.employeemanagementservice.model.Employee;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeManagementServiceApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void testSavedEmployees() {
		ResponseEntity<List<Employee>> response = testRestTemplate.exchange("/employee/all", HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>(){}); 
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals(2, response.getBody().size());
	}

}
