package com.employeeMgmt.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

public class EmpMgmtApplicationExceptionHandler  implements ExceptionMapper<EmployeMgmtAppException> {

	@Override
	public Response toResponse(EmployeMgmtAppException exception) {
		 return Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build(); 
	}

	
}


