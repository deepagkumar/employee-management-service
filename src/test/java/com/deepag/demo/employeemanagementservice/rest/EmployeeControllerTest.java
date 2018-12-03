package com.deepag.demo.employeemanagementservice.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.deepag.demo.employeemanagementservice.model.Employee;
import com.deepag.demo.employeemanagementservice.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService employeeService;

	@Before
	public void setUp() throws Exception {
		Mockito.doNothing().when(employeeService).saveEmployee(Mockito.any(Employee.class));
		Employee emp = new Employee();
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(emp);
		Mockito.when(employeeService.getAll()).thenReturn(empList);
	}

	@Test
	public void testSaveEmployee() throws Exception {
		Employee emp1 = new Employee();
		emp1.setFirstName("FN1");
		emp1.setLastName("LN1");
		emp1.setAddress("Address 1");
		emp1.setAge(25);
		emp1.setDateOfBirth(new Date());
		ObjectMapper mapper = new ObjectMapper();
	    String requestJson=mapper.writeValueAsString(emp1);
		mockMvc.perform(MockMvcRequestBuilders.post("/employee").content(requestJson).contentType("application/json")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testSaveEmployee_withoutmandatoryLastname() throws Exception {
		Employee emp1 = new Employee();
		emp1.setFirstName("FN1");
		emp1.setAddress("Address 1");
		emp1.setAge(25);
		emp1.setDateOfBirth(new Date());
		ObjectMapper mapper = new ObjectMapper();
	    String requestJson=mapper.writeValueAsString(emp1);
		mockMvc.perform(MockMvcRequestBuilders.post("/employee").content(requestJson).contentType("application/json")).andExpect(MockMvcResultMatchers.status().is4xxClientError());
	}

	@Test
	public void testGetAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/employee/all")).andExpect(MockMvcResultMatchers.status().isOk());
	}

}
