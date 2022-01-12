package com.progress.volumeadjustment;

public class VolumeAdjustmentDto {
    private Long id;
    private String name;
    private Double sets;
    private String gender;
    private String volumeProperty;
    private Integer volumePropertyNumber;

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

    public Double getSets() {
        return sets;
    }
    public void setSets(Double sets) {
        this.sets = sets;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVolumeProperty() {
        return volumeProperty;
    }
    public void setVolumeProperty(String volumeProperty) {
        this.volumeProperty = volumeProperty;
    }

    public Integer getVolumePropertyNumber() {
        return volumePropertyNumber;
    }
    public void setVolumePropertyNumber(Integer volumePropertyNumber) {
        this.volumePropertyNumber = volumePropertyNumber;
    }
    // endregion
}
