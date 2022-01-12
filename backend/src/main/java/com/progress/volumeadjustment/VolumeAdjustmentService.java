package com.progress.volumeadjustment;

import java.util.List;

import com.progress.db.ServiceBase;

public interface VolumeAdjustmentService extends ServiceBase<VolumeAdjustment, Long> {

    List<VolumeAdjustment> getByProperty(Integer property);

    List<VolumeAdjustment> getByGender(Integer gender);

    List<VolumeAdjustment> getByGenderAndProperty(Integer gender, Integer property);

    List<VolumeAdjustment> getByUser(Long userid);
    
    VolumeAdjustment getByUserAndProperty(Long userid, Integer property);

    void addUser(Long id, Long userid);

    void removeUser(Long id, Long userid);

}
