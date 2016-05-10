package com.employeeMgmt.empRestService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.InvalidRequestException;

/*@Path("/stripService/")*/
public interface StripeService {
	
	/*@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{token}/")
	@GET*/
	public Response validateCard(@PathParam("token") String token,@Context HttpHeaders httpHeaders) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException;

}
