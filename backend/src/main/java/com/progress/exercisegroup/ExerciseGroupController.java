package com.progress.exercisegroup;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

import com.progress.api.ControllerBase;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/exercisegroup")
@Tag(name = "Exercise group")
@ApplicationScoped
public class ExerciseGroupController extends ControllerBase<ExerciseGroup, ExerciseGroupDto, Long> {
    
    @Inject
    private ExerciseGroupService exerciseGroupSerivce;

    @PostConstruct
    private void init() {
        this.serviceBase = exerciseGroupSerivce;
    }

    public ExerciseGroupController() {
        this.persistenceDtoClass = ExerciseGroupDto.class;
    }
}
