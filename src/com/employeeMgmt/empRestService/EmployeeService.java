package com.employeeMgmt.empRestService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;


@Path("/empServices/")
public interface EmployeeService {

	
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}/")
	@GET
	public Response getEmployeeDetails(@PathParam("id") Long id);
}
