package com.employeeMgmt.empRestServiceImpl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employeeMgmt.dao.EmployeeDAO;
import com.employeeMgmt.empRestService.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeDAO empDao;

	public Response getEmployeeDetails(Long id) {
		if(id == null)
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}		
		return Response.ok(empDao.getEmployeeDetails(id)).build();
		}
	}

