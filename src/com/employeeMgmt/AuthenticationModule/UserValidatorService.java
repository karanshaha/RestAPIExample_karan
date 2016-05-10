package com.employeeMgmt.AuthenticationModule;

import java.io.Serializable;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;


public interface UserValidatorService extends Serializable {

    /*@POST
    @Path( "login" )
    @Produces( MediaType.APPLICATION_JSON )*/
    public Response login(
        @Context HttpHeaders httpHeaders,
        @PathParam( "username" ) String username,
        @PathParam( "password" ) String password );


    /*@POST
    @Path( "logout" )*/
    public Response logout(
        @Context HttpHeaders httpHeaders
    );
}
