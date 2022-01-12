import { TestBed } from '@angular/core/testing';

import { StrengthvalueService } from './strengthvalue.service';

describe('StrengthvalueService', () => {
  let service: StrengthvalueService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StrengthvalueService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
