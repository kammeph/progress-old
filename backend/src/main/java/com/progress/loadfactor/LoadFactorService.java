package com.progress.loadfactor;

import java.util.List;

import com.progress.db.ServiceBase;

public interface LoadFactorService extends ServiceBase<LoadFactor, Long> {
    List<LoadFactor> getByExercise(Long exerciseid);
}
