package org.acme.controller.auth;

import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;


@Path("/public")
@PermitAll
public class PublicResource {
    
    @GET
    public Response permitAll(){
        return Response.ok("Hello, this endpoint is public! 😊").build();
    }
}
