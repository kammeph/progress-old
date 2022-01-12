package com.progress.exercise;

import java.util.List;

import com.progress.db.ServiceBase;

public interface ExerciseService extends ServiceBase<Exercise, Long> {
    List<Exercise> getByExerciseGroup(Long exercisegroupid);
    Boolean initExercise(Long exerciseid);
}
