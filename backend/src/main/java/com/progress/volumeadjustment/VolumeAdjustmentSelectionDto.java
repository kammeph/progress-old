package com.progress.volumeadjustment;

import java.util.List;

public class VolumeAdjustmentSelectionDto {

    private String volumeProperty;
    private List<VolumeAdjustmentDto> volumeAdjustments;
    private VolumeAdjustmentDto selectedVolumeAdjustment;

    public String getVolumeProperty() {
        return volumeProperty;
    }

    public void setVolumeProperty(String volumeProperty) {
        this.volumeProperty = volumeProperty;
    }

    public List<VolumeAdjustmentDto> getVolumeAdjustments() {
        return volumeAdjustments;
    }

    public void setVolumeAdjustments(List<VolumeAdjustmentDto> volumeAdjustments) {
        this.volumeAdjustments = volumeAdjustments;
    }

    public VolumeAdjustmentDto getSelectedVolumeAdjustment() {
        return selectedVolumeAdjustment;
    }
    
    public void setSelectedVolumeAdjustment(VolumeAdjustmentDto selectedVolumeAdjustment) {
        this.selectedVolumeAdjustment = selectedVolumeAdjustment;
    }
}
