package com.employeeMgmt.AuthenticationModule;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.employeeMgmt.constants.HTTPHeaderNames;

@Path("/authenticationService/")
public class UserValidatorServiceImpl implements UserValidatorService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2613153303056941461L;

	@Override
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("login/{username}/{password}")
	@POST
	public Response login(@Context HttpHeaders httpHeaders,  @PathParam( "username" ) String username,
	        @PathParam( "password" ) String password) {
		APIUserAuthenticator apiUserAuthenticator = APIUserAuthenticator.getInstance();
		String serviceKey = httpHeaders.getHeaderString(HTTPHeaderNames.SERVICE_KEY);
		try{
			String authToken = apiUserAuthenticator.login(serviceKey, username, password);
			JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
			jsonObjectBuilder.add(HTTPHeaderNames.AUTH_TOKEN, authToken);
			JsonObject jsonObj = jsonObjectBuilder.build();
			 return getNoCacheResponseBuilder( Response.Status.OK ).entity( jsonObj.toString() ).build();
		}catch(Exception e){
			 return getNoCacheResponseBuilder( Response.Status.UNAUTHORIZED ).build();
		}
		
	}

	@Override
	@Path("/logout/")
	@POST
	public Response logout(@Context HttpHeaders httpHeaders) {
		APIUserAuthenticator apiUserAuthenticator = APIUserAuthenticator.getInstance();
		String serviceKey = httpHeaders.getHeaderString(HTTPHeaderNames.SERVICE_KEY);
		String authToken = httpHeaders.getHeaderString(HTTPHeaderNames.AUTH_TOKEN);
		try{
			 apiUserAuthenticator.logout(serviceKey, authToken);
			 return getNoCacheResponseBuilder( Response.Status.NO_CONTENT ).build();
		}catch(Exception e){
			return getNoCacheResponseBuilder( Response.Status.INTERNAL_SERVER_ERROR ).build();
		}
	}

	private Response.ResponseBuilder getNoCacheResponseBuilder( Response.Status status ) {
        CacheControl cc = new CacheControl();
        cc.setNoCache( true );
        cc.setMaxAge( -1 );
        cc.setMustRevalidate( true );
 
        return Response.status( status ).cacheControl( cc );
    }
	
}
