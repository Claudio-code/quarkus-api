package com.example.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.example.rest.dto.CreateUserRequest;

@Path("/users")
public class UserResource {

    @POST
    public Response createUsers(CreateUserRequest createUserRequest) {
        return Response.ok().build();
    }

}
