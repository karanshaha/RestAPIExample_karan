package com.employeeMgmt.empRestService;

import java.io.Serializable;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.employeeMgmt.Exception.EmployeMgmtAppException;
import com.employeeMgmt.Model.Employee;


public interface EmployeeService extends Serializable{

	public void addEmployee(Employee employee,@Context HttpHeaders httpHeaders) throws EmployeMgmtAppException;
	
	public Response getEmployeeDetails(@PathParam("id") Integer id, @Context HttpHeaders httpHeaders) throws EmployeMgmtAppException;
	
	public Response updateEmployeeDetails(@PathParam("department") String department,@PathParam("id") Integer id,@Context HttpHeaders httpHeaders) throws EmployeMgmtAppException ;
	
	public void deleteEmployeeDetails(@PathParam("id") Integer id,@Context HttpHeaders httpHeaders) throws EmployeMgmtAppException ;

}
