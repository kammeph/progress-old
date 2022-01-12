package com.progress.volumerecommendation;

import com.progress.loadfactor.MuscleGroup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "volumeRecommendations")
public class VolumeRecommendation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mev")
    private Double mev;

    @Column(name = "mrv")
    private Double mrv;

    @Column(name = "phase")
    @Enumerated(EnumType.STRING)
    private Phase phase;

    @Column(name = "muscleGroup")
    @Enumerated(EnumType.STRING)
    private MuscleGroup muscleGroup;

    // region Getter / Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMev() {
        return mev;
    }

    public void setMev(Double mev) {
        this.mev = mev;
    }

    public Double getMrv() {
        return mrv;
    }

    public void setMrv(Double mrv) {
        this.mrv = mrv;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public MuscleGroup getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(MuscleGroup muscleGroup) {
        this.muscleGroup = muscleGroup;
    }
    // endregion
}
