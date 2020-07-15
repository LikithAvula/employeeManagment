package com.employee.management.employeeManagement.employeeService;

import com.employee.management.employeeManagement.employeeEntity.Employee;
import com.employee.management.employeeManagement.employeeEntity.Employees;

public interface EmployeeService {
	
	public Employees getAllEmployees();
	
	public Employee getEmployeById(int id);
	
	public int DeleteEmployeeById(int id);
	
	public void AddEmployee(Employee employee);
	
	public void UpdateEmployee(Employee employee);
	
	
	

}
