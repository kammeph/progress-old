import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VolumecalculatorComponent } from './volumecalculator.component';

describe('VolumecalculatorComponent', () => {
  let component: VolumecalculatorComponent;
  let fixture: ComponentFixture<VolumecalculatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VolumecalculatorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VolumecalculatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
