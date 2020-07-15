package com.employee.management.employeeManagement.employeeEntity;


public class Employee {	
	
	private String firstName;
	private String lastName;
	private int id;
	private String email;
	private EmployeeRating rating;
	public EmployeeRating getRating() {
		return rating;
	}
	public void setRating(EmployeeRating rating) {
		this.rating = rating;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", email=" + email + "]";
	}
	



}
