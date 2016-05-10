package com.employeeMgmt.empRestServiceImpl;

import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employeeMgmt.Exception.EmployeMgmtAppException;
import com.employeeMgmt.Model.Employee;
import com.employeeMgmt.dao.EmployeeDAO;
import com.employeeMgmt.empRestService.EmployeeService;

@Component
@Path("/empServices/")
public class EmployeeServiceImpl implements EmployeeService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1928867427054776814L;
	/**
	 * 
	 */
	
	private final static Logger log = Logger
			.getLogger(EmployeeServiceImpl.class.getName());
	@Autowired
	EmployeeDAO empDao;

	@Override
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/")
	@GET
	public Response getEmployeeDetails(@PathParam("id") Integer id,
			@Context HttpHeaders httpHeaders)throws EmployeMgmtAppException {
		if (id == null) {
			 throw new EmployeMgmtAppException("Not valid ID");
			
		}
		return Response.ok(empDao.getEmployeeDetails(id)).build();
	}

	@Override
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateEmpDetails/{id}/{department}")
	public Response updateEmployeeDetails(@PathParam("department") String department,@PathParam("id") Integer id,
			@Context HttpHeaders httpHeaders)throws EmployeMgmtAppException {
		if (id == null) {
			 throw new EmployeMgmtAppException("Not valid ID");
			
		}
		return Response.ok(empDao.updateEmployeeDetails(id, department)).build(); 
	}

	@Override
	
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteEmpDetails/{id}")
	@DELETE
	public void deleteEmployeeDetails(@PathParam("id") Integer id,@Context HttpHeaders httpHeaders)
			throws EmployeMgmtAppException {
		if (id == null) {
			 throw new EmployeMgmtAppException("Not valid ID");
			
		}
		empDao.deleteEmployeeDetails(id);
		
	}

	@Override
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addEmployee/")
	@POST
	public void addEmployee(Employee employee,@Context HttpHeaders httpHeaders)
			throws EmployeMgmtAppException {
		if (employee == null) {
			 throw new EmployeMgmtAppException("Employee is null cannot add");
			
		}
		empDao.addEmployee(employee);
	}
}
