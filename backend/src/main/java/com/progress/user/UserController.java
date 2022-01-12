package com.progress.user;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.progress.api.ControllerBase;
import com.progress.security.JwtSecurity;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/user")
@Tag(name = "User")
@ApplicationScoped
@SecurityScheme(securitySchemeName = "Authentication",
    description = "JWT token",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT")
public class UserController extends ControllerBase<User, UserDto, Long> {

    @Inject
    private UserService userService;

    @Inject
    private JwtSecurity jwtSecurity;

    @PostConstruct
    private void init() {
        this.serviceBase = userService;
    }

    public UserController() {
        super();
        this.persistenceDtoClass = UserDto.class;
    }

    @GET
    @Path("getbyusername/{username}")
    @Produces("application/json")
    @Operation(
        summary = "Get by user name",
        description = "Get a specific user by name")
    @APIResponses(
        {
            @APIResponse(responseCode = "200", description = "User is returned", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "204", description = "User does not exist")
        }
    )
    @RolesAllowed("protected")
    @SecurityRequirement(name = "Authentication")
    public Response getByUsername(@PathParam("username") String username) {
        User user = userService.getByUsername(username);
        if (user != null)
            return Response.ok(mapper.map(user, persistenceDtoClass)).build();
        else
            return Response.noContent().build();
    }

    @GET
    @Path("authenticate/{username}/{password}")
    @Produces("application/json")
    @Operation(
        summary = "Authenticate",
        description = "Authentication of a user")
    @APIResponses(
        {
            @APIResponse(responseCode = "200", description = "User is authorized", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "401", description = "User is unauthorized")
        }
    )
    public Response authenticate(@PathParam("username") String username, @PathParam("password") String password) {
        User user = userService.authenticate(username, password);
        if (user != null) {
            UserDto dto = mapper.map(user, persistenceDtoClass);
            dto.setToken(jwtSecurity.generateJWT());
            return Response.ok(dto).build();
        }
        else
            return Response.status(Response.Status.UNAUTHORIZED).entity("Login fehlgeschlagen. Benutzername oder Passwort falsch.").build();
    }
}