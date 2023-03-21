package com.example.quarkusapi.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.example.quarkusapi.rest.dto.CreateUserRequest;
import org.jboss.resteasy.reactive.ResponseStatus;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.CREATED;

@Path("/users")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class UserResource {

    @POST
    @ResponseStatus(CREATED)
    public CreateUserRequest createUsers(CreateUserRequest createUserRequest) {
        return createUserRequest;
    }

}
