import { VolumeAdjustment } from "src/app/services/volumeadjustment.service/VolumeAdjustment";

export interface VolumeAdjustmentSelection {
    volumeProperty: string,
    volumeAdjustments: VolumeAdjustment[],
    selectedVolumeAdjustment: VolumeAdjustment,
}