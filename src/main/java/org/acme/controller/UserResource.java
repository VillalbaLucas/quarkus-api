package org.acme.controller;

import java.security.Principal;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

@Path("/users")
public class UserResource {

    @GET
    @Path("/me")
    @RolesAllowed("user")
    public Response getContext(@Context SecurityContext context){
        Principal principal = context.getUserPrincipal();
        return Response.ok(principal).build();
    }
}
