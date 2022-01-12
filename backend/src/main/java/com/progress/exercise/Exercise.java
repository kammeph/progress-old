package com.progress.exercise;

import java.util.Set;

import com.progress.exercisegroup.ExerciseGroup;
import com.progress.loadfactor.LoadFactor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "conversion")
    private Double conversion;

    private Long exerciseGroupId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "exerciseGroupId", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
    private ExerciseGroup exerciseGroup;

    @OneToMany(mappedBy = "exercise", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Set<LoadFactor> loadFactors;

    public Exercise() { }

    public Exercise(Long exerciseGroupId, String name) {
        this.exerciseGroupId = exerciseGroupId;
        this.name = name;
        this.conversion = 100.0;
    }

    public Exercise(Long exerciseGroupId) {
        this.exerciseGroupId = exerciseGroupId;
        this.conversion = 100.0;
    }

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

    public Set<LoadFactor> getLoadFactorss() {
        return loadFactors;
    }
    public void setLoadFactors(Set<LoadFactor> loadFactors) {
        this.loadFactors = loadFactors;
    }
    // endregion
}
