package com.deepag.demo.employeemanagementservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deepag.demo.employeemanagementservice.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
