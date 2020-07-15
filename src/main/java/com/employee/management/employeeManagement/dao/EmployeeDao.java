package com.employee.management.employeeManagement.dao;

import com.employee.management.employeeManagement.employeeEntity.Employee;
import com.employee.management.employeeManagement.employeeEntity.Employees;

public interface EmployeeDao {
	
	public Employees getAllEmployees();
	
	public Employee getEmployeeById(int id);
	
	public int addEmployee(Employee employee);
	
	public int deleteEmployeeById(int id);
	
	public void UpdateEmployee(Employee employee);

}
