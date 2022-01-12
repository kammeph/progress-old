package com.progress.exercise;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.progress.loadfactor.LoadFactor;
import com.progress.loadfactor.LoadFactorService;
import com.progress.loadfactor.MuscleGroup;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.modelmapper.ModelMapper;


@Path("/exercise")
@Tag(name = "Exercise")
@ApplicationScoped
public class InitilizeExerciseController {

    @Inject
    private ModelMapper mapper;

    @Inject
    private ExerciseService exerciseService;

    @Inject
    private LoadFactorService loadFactorService;

    @POST
    @Path("/initialize/{exercisegroupid}")
    @Produces("application/json")
    @Operation(
        summary = "Initialize a new Exercise",
        description = "Get a list of exercises by exercise group id")
    @APIResponses(
        {
            @APIResponse(responseCode = "200", description = "exercises are returned", content = @Content(mediaType = "application/json")),
            @APIResponse(responseCode = "404", description = "exercises not found")
        }
    )
    public ExerciseDto InitilizeExercise(@PathParam("exercisegroupid") Long exercisegroupid) {
        Exercise exercise = exerciseService.create(new Exercise(exercisegroupid, "Neue Übung"));

        for (var muscleGroup : MuscleGroup.class.getEnumConstants()) {
            loadFactorService.create(new LoadFactor(exercise.getId(), muscleGroup));
        } 
        return mapper.map(exercise, ExerciseDto.class);
    }
    
}
