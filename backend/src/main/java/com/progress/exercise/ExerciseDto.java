package com.progress.exercise;

public class ExerciseDto {
    private Long id;
    private String name;
    private String description;
    private Double conversion;
    private Long exerciseGroupId;

    // region Getter Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Double getConversion() {
        return conversion;
    }
    public void setConversion(Double conversion) {
        this.conversion = conversion;
    }
    
    public Long getExerciseGroupId() {
        return exerciseGroupId;
    }
    public void setExerciseGroupId(Long exerciseGroupId) {
        this.exerciseGroupId = exerciseGroupId;
    }
    // endregion
}
