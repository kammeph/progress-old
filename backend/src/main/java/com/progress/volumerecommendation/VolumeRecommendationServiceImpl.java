package com.progress.volumerecommendation;

import javax.enterprise.context.ApplicationScoped;

import com.progress.db.ServiceBaseImpl;

@ApplicationScoped
public class VolumeRecommendationServiceImpl extends ServiceBaseImpl<VolumeRecommendation, Long> implements VolumeRecommendationService {
    
    public VolumeRecommendationServiceImpl(){
        super();
        this.persistenceClass = VolumeRecommendation.class;
    }
}
