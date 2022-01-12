package com.progress.user;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.progress.strengthvalue.StrengthValue;
import com.progress.strengthvalue.StrengthValueService;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.modelmapper.ModelMapper;

@Path("/user")
@Tag(name = "User")
@ApplicationScoped
public class SignUpController {
    
    @Inject
    private UserService userService;

    @Inject
    private StrengthValueService strengthValueService;

    @Inject
    private ModelMapper mapper;

    @POST
    @Path("signup/{username}/{password}/{gender}")
    @Produces("application/json")
    @Operation(
        summary = "Sign up",
        description = "Sign up a new user")
    @APIResponses(
        {
            @APIResponse(responseCode = "201", description = "User is signed up"),
            @APIResponse(responseCode = "401", description = "User is already signed up")
        }
    )
    public Response signUp(@PathParam("username") String username, @PathParam("password") String password, @PathParam("gender") String gender) {
        User user = userService.getByUsername(username);
        if (user != null)
            return Response.status(Response.Status.CONFLICT).entity("Der Benutzer " + username + " existiert bereits.").build();
        User signedUpUser = userService.signUp(username, password, gender);

        if (signedUpUser == null)
            return Response.status(Response.Status.BAD_REQUEST).entity("Der Benutzer " + username + " konnte nicht erstellt werden.").build();
        
        StrengthValue squatValue = new StrengthValue(signedUpUser.getId(), "Competion Squat", "Kniebeugen", 150.0, 1, 150.0, true, 1);
        strengthValueService.create(squatValue);

        StrengthValue benchValue = new StrengthValue(signedUpUser.getId(), "Competion Bench", "Bankdrücken", 100.0, 1, 100.0, true, 2);
        strengthValueService.create(benchValue);
        
        StrengthValue deadliftValue = new StrengthValue(signedUpUser.getId(), "Competion Deadlift", "Kreuzheben", 200.0, 1, 200.0, true, 3);
        strengthValueService.create(deadliftValue);

        return Response.status(Response.Status.CREATED).entity(mapper.map(signedUpUser, UserDto.class)).build();
    }
}
