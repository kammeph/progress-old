package com.progress.volumerecommendation;

public class VolumeRecommendationDto {
    private Long id;
    private Double mev;
    private Double mrv;
    private String phase;
    private String muscleGroup;

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

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }
    // endregion

}
