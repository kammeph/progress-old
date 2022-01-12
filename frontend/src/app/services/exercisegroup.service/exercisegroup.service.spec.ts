import { TestBed } from '@angular/core/testing';

import { ExercisegroupService } from './exercisegroup.service';

describe('ExercisegroupService', () => {
  let service: ExercisegroupService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExercisegroupService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
