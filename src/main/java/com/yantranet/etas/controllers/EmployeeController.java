package com.yantranet.etas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yantranet.etas.models.Employee;
import com.yantranet.etas.services.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//Fetch all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	//Fetch Employee by Id
	@GetMapping("/employee/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Long id)
	{
		try
		{
			Optional<Employee> employee = employeeService.getEmployeeById(id);
			if(employee.isPresent())
			{
				return ResponseEntity.ok(employee.get());
			}
			else
			{
				return ResponseEntity.badRequest().body("Employee not Found");
			}
		}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	//Add new Employee
	@PostMapping("/employee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee)
	{
		try
		{
			Employee newEmployee = employeeService.addEmployee(employee);
			return ResponseEntity.ok(newEmployee);
		}
		catch(Exception e)
		{
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	// Update an existing employee by Id
    @PutMapping("/employee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee)
    {
        try 
        {
            Employee updatedEmployee = employeeService.updateEmployee(employee);
            return ResponseEntity.ok(updatedEmployee);
        } 
        catch (Exception e) 
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    // Delete an Employee by Id
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id)
    {
    	try
    	{
    		employeeService.deleteEmployee(id);
    		return ResponseEntity.ok("Employee Deleted Successfully");
    	}
    	catch(Exception e)
    	{
    		return ResponseEntity.badRequest().body(e.getMessage());
    	}
    }

}
