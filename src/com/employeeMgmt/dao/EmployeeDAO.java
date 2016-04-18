package com.employeeMgmt.dao;

import org.springframework.stereotype.Service;

import com.employeeMgmt.Model.Employee;


public class EmployeeDAO {
	public Employee getEmployeeDetails(Long employeeId)
	{
		Employee emp = new Employee();
		emp.setDateOfJoining("01-02-2001");
		emp.setDepartment("Sales");
		emp.setEmail("test@example.com");
		emp.setEmployeeId("675436");
		emp.setFirstName("John");
		emp.setLastName("Smith");
		return emp;
	}
}
