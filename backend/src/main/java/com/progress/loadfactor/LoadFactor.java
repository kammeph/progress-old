package com.progress.loadfactor;

import com.progress.exercise.Exercise;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loadFactors")
public class LoadFactor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private Double value;

    @Column(name = "muscleGroup")
    @Enumerated(EnumType.STRING)
    private MuscleGroup muscleGroup;

    private Long exerciseId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "exerciseId", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private Exercise exercise;

    public LoadFactor() { }

    public LoadFactor(Long exerciseId, MuscleGroup muscleGroup) {
        this.exerciseId = exerciseId;
        this.muscleGroup = muscleGroup;
        this.value = 0.0;
    }

    // region Getter & Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }

    public MuscleGroup getMuscleGroup() {
        return muscleGroup;
    }
    public void setMuscleGroup(MuscleGroup muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public Integer getMuscleGroupNumber() {
        return muscleGroup.ordinal();
    }

    public Long getExerciseId() {
        return exerciseId;
    }
    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }
    // endregion
}
