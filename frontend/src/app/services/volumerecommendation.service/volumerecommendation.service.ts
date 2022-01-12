import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { GenericDataService } from '../GenericHttpService';
import { VolumeRecommendation } from './VolumeRecommendation';

@Injectable({
  providedIn: 'root'
})
export class VolumerecommendationService extends GenericDataService<VolumeRecommendation> {

  constructor(http: HttpClient, @Inject('API_URL') apiUrl: string) {
    super(http, apiUrl, 'volumerecommendation');
  }
}
