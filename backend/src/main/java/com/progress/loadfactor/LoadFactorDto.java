package com.progress.loadfactor;

public class LoadFactorDto {
    private Long id;
    private Double value;
    private String muscleGroup;
    private Integer muscleGroupNumber;
    private Long exerciseId;
    
    // region Getter Setter
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

    public String getMuscleGroup() {
        return muscleGroup;
    }
    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public Integer getMuscleGroupNumber() {
        return muscleGroupNumber;
    }
    public void setMuscleGroupNumber(Integer muscleGroupNumber) {
        this.muscleGroupNumber = muscleGroupNumber;
    }

    public Long getExerciseId() {
        return exerciseId;
    }
    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }
    // endregion
}
