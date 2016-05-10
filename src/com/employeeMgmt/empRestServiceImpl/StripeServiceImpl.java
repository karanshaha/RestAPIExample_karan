package com.employeeMgmt.empRestServiceImpl;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.employeeMgmt.empRestService.StripeService;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;

@Component
@Path("/stripService/")
public class StripeServiceImpl implements StripeService{
	
	@Override
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{token}/")
	@GET
	public Response validateCard(@PathParam("token") String token,@Context HttpHeaders httpHeaders) throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException{
		Stripe.apiKey = "sk_test_Nmqu9IrkgLGe3ipmt9eXATwc";

		// Get the credit card details submitted by the form
		//String token = request.getParameter("stripeToken");

		// Create the charge on Stripe's servers - this will charge the user's card
		Charge charge = null;
		try {
		  Map<String, Object> chargeParams = new HashMap<String, Object>();
		  chargeParams.put("amount", 1000); // amount in cents, again
		  chargeParams.put("currency", "gbp");
		  chargeParams.put("source", token);
		  chargeParams.put("description", "Example charge");

		   charge = Charge.create(chargeParams);
		  
		} catch (CardException e) {
		  // The card has been declined
		}
		return Response.ok(charge).build();
		
	}

}
