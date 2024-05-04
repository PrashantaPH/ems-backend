package com.restapi.integration.service;

import java.util.List;

import com.restapi.integration.dto.EmployeeRequest;
import com.restapi.integration.entity.Employee;

public interface EmployeeService {

	Employee createEmployee(EmployeeRequest employee);
	
	Employee getEmployeeById(Long employeeId);
	
	List<Employee> getAllEmployees();
	
	Employee updateEmployee(Long employeeId, EmployeeRequest updateEmployee);
	
	void deleteEmployee(Long employeeId);
	
	List<Employee> searchEmployeeByName(String employeeName);
	
}
