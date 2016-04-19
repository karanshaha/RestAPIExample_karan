package com.employeeMgmt.dao;

import com.employeeMgmt.Model.Employee;


public class EmployeeDAO {
	public Employee getEmployeeDetails(Long employeeId)
	{
		Employee emp = new Employee();
		emp.setDateOfJoining("01-02-2001");
		emp.setDepartment("Computer");
		emp.setEmail("test@example.com");
		emp.setEmployeeId("1001");
		emp.setFirstName("John");
		emp.setLastName("Smith");
		return emp;
	}
}
