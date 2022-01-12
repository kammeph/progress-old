import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoadfactorComponent } from './loadfactor.component';

describe('LoadfactorComponent', () => {
  let component: LoadfactorComponent;
  let fixture: ComponentFixture<LoadfactorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoadfactorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoadfactorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
