package com.progress.exercise;

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

@Path("/exercise")
@Tag(name = "Exercise")
@ApplicationScoped
public class ExerciseController extends ControllerBase<Exercise, ExerciseDto, Long> {
    
    @Inject
    private ExerciseService exerciseService;

    @PostConstruct
    private void init() {
        this.serviceBase = exerciseService;
    }

    public ExerciseController() {
        this.persistenceDtoClass = ExerciseDto.class;
    }

    @GET
    @Path("getByExerciseGroup/{exercisegroupid}")
    @Produces("application/json")
    @Operation(
        summary = "Get by exercise group id",
        description = "Get a list of exercises by exercise group id")
    @APIResponses(
        {
            @APIResponse(responseCode = "200", description = "exercises are returned", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "404", description = "exercises not found")
        }
    )
    public Response getByExerciseGroup(@PathParam("exercisegroupid") Long exercisegroupid) {
        var entities = exerciseService.getByExerciseGroup(exercisegroupid);
        if (entities != null && entities.size() > 0)
            return Response.ok(mapList(entities, persistenceDtoClass)).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}