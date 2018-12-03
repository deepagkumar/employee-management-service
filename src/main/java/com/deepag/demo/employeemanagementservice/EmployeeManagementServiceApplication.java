package com.deepag.demo.employeemanagementservice;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.deepag.demo.employeemanagementservice.model.Employee;
import com.deepag.demo.employeemanagementservice.service.EmployeeService;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class EmployeeManagementServiceApplication implements CommandLineRunner{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeManagementServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementServiceApplication.class, args);
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
	}
	
	
	@Autowired
	private EmployeeService empService;

	@Override
	public void run(String... args) throws Exception {
		Employee emp1 = new Employee();
		emp1.setFirstName("FN1");
		emp1.setLastName("LN1");
		emp1.setAddress("Address 1");
		emp1.setAge(25);
		emp1.setDateOfBirth(new Date());
		empService.saveEmployee(emp1);
		
		LOGGER.info("Creating Employee==>"+emp1);
		
		Employee emp2 = new Employee();
		emp2.setFirstName("FN2");
		emp2.setLastName("LN2");
		emp2.setAddress("Address 2");
		emp2.setAge(35);
		emp2.setDateOfBirth(new Date());
		empService.saveEmployee(emp2);
		
		LOGGER.info("Creating Employee==>"+emp2);
	}
}
