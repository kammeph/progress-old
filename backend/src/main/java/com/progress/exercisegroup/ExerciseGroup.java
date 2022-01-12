package com.progress.exercisegroup;

import java.util.Set;

import com.progress.exercise.Exercise;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "exerciseGroups")
public class ExerciseGroup {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "exerciseGroup", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<Exercise> exercises;

    // region Getter/Setter
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

    public Set<Exercise> getExercises() {
        return exercises;
    }
    public void setExercises(Set<Exercise> exercises) {
        this.exercises = exercises;
    }
    // endregion
}
