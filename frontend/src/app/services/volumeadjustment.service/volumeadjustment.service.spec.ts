import { TestBed } from '@angular/core/testing';

import { VolumeadjustmentService } from './volumeadjustment.service';

describe('VolumeadjustmentService', () => {
  let service: VolumeadjustmentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VolumeadjustmentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
