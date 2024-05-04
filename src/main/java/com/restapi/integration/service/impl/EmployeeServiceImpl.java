package com.restapi.integration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.integration.dto.EmployeeRequest;
import com.restapi.integration.entity.Employee;
import com.restapi.integration.exception.ResourceNotFoundException;
import com.restapi.integration.repository.EmployeeRepository;
import com.restapi.integration.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(EmployeeRequest employeeRequest) {
		Employee savedEmployee = new Employee(0l, employeeRequest.getFirstName(), employeeRequest.getLastName(), employeeRequest.getEmail());
		return employeeRepository.save(savedEmployee);
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(
						() -> new ResourceNotFoundException("Employee is not exists with the given id : "+ employeeId));
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee updateEmployee(Long employeeId, EmployeeRequest updateEmployee) {
		 Employee employee = employeeRepository.findById(employeeId)
				 .orElseThrow(
						 () -> new ResourceNotFoundException("Employee is not exists with the given id : "+employeeId));
		 
		 employee.setFirstName(updateEmployee.getFirstName());
		 employee.setLastName(updateEmployee.getLastName());
		 employee.setEmail(updateEmployee.getEmail());
		 
		 Employee updateEmployeeObj = employeeRepository.save(employee);
		 
		return updateEmployeeObj;
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(
						() -> new ResourceNotFoundException("Employee is not exists with the given id : " + employeeId));	
		
		employeeRepository.delete(employee);
	}

	@Override
	public List<Employee> searchEmployeeByName(String employeeName) {
		List<Employee> list = employeeRepository.searchByname(employeeName);
		if(list.size() > 0) {
			return list;
		}
		throw new ResourceNotFoundException("Employee is not exists with the given Name : "+ employeeName);
	}

}
