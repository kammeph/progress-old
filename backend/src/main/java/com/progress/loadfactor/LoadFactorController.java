package com.progress.loadfactor;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.progress.api.ControllerBase;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/loadfactor")
@Tag(name = "Load factor")
@ApplicationScoped
public class LoadFactorController extends ControllerBase<LoadFactor, LoadFactorDto, Long> {
    
    @Inject
    private LoadFactorService loadFactorService;

    @PostConstruct
    private void init() {
        this.serviceBase = loadFactorService;
    }

    public LoadFactorController() {
        this.persistenceDtoClass = LoadFactorDto.class;
    }
    
    @GET
    @Path("getByExercise/{exerciseid}")
    @Produces("application/json")
    @Operation(
        summary = "Get by exercise id",
        description = "Get a list of load factors by exercise id")
    @APIResponses(
        {
            @APIResponse(responseCode = "200", description = "Load factors are returned", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "404", description = "Load factors not found")
        }
    )
    public Response getByExercise(@PathParam("exerciseid") Long exerciseid) {
        var entities = loadFactorService.getByExercise(exerciseid);
        if (entities != null && entities.size() > 0)
            return Response.ok(mapList(entities, persistenceDtoClass)).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
