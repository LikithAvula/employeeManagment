package com.employee.management.employeeManagement.employeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.employeeManagement.dao.EmployeeDao;
import com.employee.management.employeeManagement.employeeEntity.Employee;
import com.employee.management.employeeManagement.employeeEntity.Employees;

@Service("employeeService")
public class EmployeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employees getAllEmployees() {
		Employees employees = employeeDao.getAllEmployees();
		return employees;
		
	}

	@Override
	public Employee getEmployeById(int id) {
		
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public int DeleteEmployeeById(int id) {
		
		 return employeeDao.deleteEmployeeById(id);
	}
	
	@Override
	public void AddEmployee(Employee employee) {
		
		Integer status = employeeDao.addEmployee(employee);
		if(status.equals(0)) {
		System.out.println("the status of insert operation is success");
		}
	}

	@Override
	public void UpdateEmployee(Employee employee) {
		
		employeeDao.UpdateEmployee(employee);
	}

	
	
}
