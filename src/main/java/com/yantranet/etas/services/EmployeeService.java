package com.yantranet.etas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yantranet.etas.models.Employee;
import com.yantranet.etas.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	//List all employees
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}
	
	//Fetch an employee by ID
	public Optional<Employee> getEmployeeById(Long Id)
	{
		return employeeRepository.findById(Id);
	}
	
	//Add new employee
	public Employee addEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	//Update details of an Employee
	public Employee updateEmployee(Employee employee)
	{
		Optional<Employee> updateEmployee = employeeRepository.findById(employee.getId());
		if(updateEmployee.isPresent())
			return employeeRepository.save(employee);
		else
			throw new RuntimeException("Could Not Update Employee!! No Employee Found with this ID.");
	}
	
	//Remove an Employee
	public void deleteEmployee(Long id)
	{
		Optional<Employee> deleteEmployee = employeeRepository.findById(id);
		if(deleteEmployee.isPresent())
			employeeRepository.deleteById(id);
		else
			throw new RuntimeException("Delete Not Possible!! No Employee Found.");
	}

}
