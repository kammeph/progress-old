package com.progress.exercisegroup;

import javax.enterprise.context.ApplicationScoped;

import com.progress.db.ServiceBaseImpl;

@ApplicationScoped
public class ExerciseGroupServiceImpl extends ServiceBaseImpl<ExerciseGroup, Long> implements ExerciseGroupService {

    public ExerciseGroupServiceImpl() {
        super();
        this.persistenceClass = ExerciseGroup.class;
    }
    
}
