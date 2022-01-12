import { TestBed } from '@angular/core/testing';

import { LoadfactorService } from './loadfactor.service';

describe('LoadfactorService', () => {
  let service: LoadfactorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoadfactorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
