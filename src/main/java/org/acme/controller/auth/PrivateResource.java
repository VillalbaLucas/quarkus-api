package org.acme.controller.auth;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/private")
@Authenticated
public class PrivateResource {

    @GET
    @Path("/user")
    @RolesAllowed({"user"})
    public Response getUser(){
        return Response.ok("Hello User, this endpoint is private!🔐").build();
    }
    
    @GET
    @Path("/admin")
    @RolesAllowed({"admin"})
    public Response getAdmin(){
        return Response.ok("Hello Admin, this endpoint is private!🔐").build();
    }
}
