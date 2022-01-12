import { TestBed } from '@angular/core/testing';

import { VolumerecommendationService } from './volumerecommendation.service';

describe('VolumerecommendationService', () => {
  let service: VolumerecommendationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VolumerecommendationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
