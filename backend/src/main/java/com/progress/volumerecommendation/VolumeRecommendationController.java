package com.progress.volumerecommendation;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;

import com.progress.api.ControllerBase;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/volumerecommendation")
@Tag(name = "Volume recommendation")
@ApplicationScoped
public class VolumeRecommendationController extends ControllerBase<VolumeRecommendation, VolumeRecommendationDto, Long> {
    
    @Inject
    private VolumeRecommendationService volumeRecommendationService;

    @PostConstruct
    private void init() {
        this.serviceBase = volumeRecommendationService;
    }

    public VolumeRecommendationController() {
        super();
        this.persistenceDtoClass = VolumeRecommendationDto.class;
    }
}
