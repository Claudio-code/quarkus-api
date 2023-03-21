package com.example.quarkusapi.rest;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.example.quarkusapi.rest.dto.CreateUserRequest;
import com.example.quarkusapi.rest.entity.User;
import com.example.quarkusapi.rest.entity.UserRepository;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.resteasy.reactive.ResponseStatus;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.jboss.resteasy.reactive.RestResponse.StatusCode.CREATED;

@Path("/users")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class UserResource {

    @Inject
    private UserRepository userRepository;
    @Inject
    KafkaExactlyOnceProcessor kafkaExactlyOnceProcessor;


    @POST
    @ResponseStatus(CREATED)
    @Transactional
    public CreateUserRequest createUsers(CreateUserRequest createUserRequest) {
        final var userPers = new User();
        userPers.setAge(createUserRequest.age());
        userPers.setName(createUserRequest.name());
        kafkaExactlyOnceProcessor.send();
        return createUserRequest;
    }

}
