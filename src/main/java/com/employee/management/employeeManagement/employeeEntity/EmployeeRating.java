package com.employee.management.employeeManagement.employeeEntity;

public class EmployeeRating {

	private String location;
	
	private int employeeId;
	
	private int rating;
	
	private int id;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "EmployeeRating [location=" + location + ", employeeId=" + employeeId + ", rating=" + rating + ", id="
				+ id + "]";
	}
	
}
