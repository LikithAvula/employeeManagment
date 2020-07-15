package com.employee.management.employeeManagement.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.employee.management.employeeManagement.employeeEntity.Employee;
import com.employee.management.employeeManagement.employeeEntity.EmployeeRating;
import com.employee.management.employeeManagement.employeeEntity.EmployeeRatings;
import com.employee.management.employeeManagement.employeeEntity.Employees;
import com.employee.management.employeeManagement.employeeService.EmployeeService;

@RestController
@RequestMapping(path ="/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/allEmployees")
	public Employees findAllEmployees() {		
		EmployeeRatings ratings = restTemplate.getForObject("http://localhost:8888/ratingApi/allRatings", EmployeeRatings.class);
		Employees employees = new Employees();
		List<Employee> list = new ArrayList<Employee>();
		for(Employee employee: employeeService.getAllEmployees().getEmployee()) {
			for(EmployeeRating rating : ratings.getEmployeeRatings()) {
				if(Integer.valueOf(rating.getEmployeeId()).equals(Integer.valueOf(employee.getId()))){					
					employee.setRating(rating);										
				}
			}
			list.add(employee);			
		}
		
		employees.setEmployee(list);
		
		return employees; 		
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		EmployeeRating rating =restTemplate.getForObject("http://localhost:8888/ratingApi/ratingById/{id}", EmployeeRating.class,employeeId);
		Employee employee = employeeService.getEmployeById(employeeId);
		employee.setRating(rating);
		return employee;
		
	}
	
	@DeleteMapping("/deleteEmployee/{employeeId}")
	public Employees DeleteEmployeeById(@PathVariable int employeeId) {
		 restTemplate.delete("http://localhost:8888/ratingApi/deleteById/{id}",Integer.valueOf(employeeId));
		 employeeService.DeleteEmployeeById(employeeId);		 
		 return employeeService.getAllEmployees();		
	}
	
	@PostMapping("/addEmployee")
	public Employees AddEmployee(@RequestBody Employee theEmployee) {
		
		EmployeeRating rating = theEmployee.getRating();
		  restTemplate.getForObject(
		  "http://localhost:8888/ratingApi/addEmployeeRating", EmployeeRatings.class,
		  rating);
		 
		employeeService.AddEmployee(theEmployee);		
		return employeeService.getAllEmployees();		
	}
	
	@PutMapping("/updateEmployee")
	public Employees UpdateEmployee(@RequestBody Employee theEmployee) {
		employeeService.UpdateEmployee(theEmployee);
		return employeeService.getAllEmployees();			
	}
	
	
	


}
