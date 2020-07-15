package com.employee.management.employeeManagement.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.employee.management.employeeManagement.employeeEntity.Employee;
import com.employee.management.employeeManagement.employeeEntity.Employees;

@Repository("employeeDao")
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao{
	
	@Autowired
	private DataSource dataSource;
	 
	private String extract = "select * from employee";
	
	private String deleteById = "DELETE from employee where id = ?";
	
	@PostConstruct
	void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public Employees getAllEmployees() {
		
		
		List<Map<String,Object>> list = Extract(extract);
		Employees employees = new Employees();
		
		List<Employee> employeeList = new ArrayList<Employee>(); 
		
		for(Map<String,Object> map : list) {
			Employee employee = new Employee();
			employee.setId(map.get("id").hashCode());
			employee.setFirstName(map.get("first_name").toString());
			employee.setLastName(map.get("last_name").toString());
			employee.setEmail(map.get("email").toString());
			employeeList.add(employee);
			employees.setEmployee(employeeList);
		}
		
		
		return employees;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employees employees = getAllEmployees();
		Map<Integer,Employee> map = new HashMap<Integer,Employee>();		
		for(Employee employee: employees.getEmployee()) {
			map.put(employee.getId(), employee);
		}
		return map.get(id);
	}

	@Override
	public int addEmployee(Employee employee) {
		return insertEmployee(employee);
		
		
	}

	@Override
	public int deleteEmployeeById(int id) {
		int status = DeleteById(deleteById,id);
		
		System.out.println("delete operation for id" +id+ "is" +status);
		
		return status;
		
	}
	
	@Override
	public void UpdateEmployee(Employee employee) {
		updateEmployee(employee);
		
	}
	
	
	public List<Map<String,Object>> Extract(String sql) {
		return getJdbcTemplate().queryForList(sql);		
	}
	
	public int DeleteById(String sql , int id) {
		return getJdbcTemplate().update(sql,new Object[] {Integer.valueOf(id)}	);
	}
	
	public int insertEmployee(Employee employee) {
		return getJdbcTemplate().update("insert into employee values(?,?,?,?)", employee.getId(), employee.getFirstName(), employee.getLastName(),employee.getEmail());
	}

	public void updateEmployee(Employee employee) {
		getJdbcTemplate().update("UPDATE employee SET first_name =?, last_name=?,email=? WHERE id=?", new Object[] {employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getId()});
	}
	

}
