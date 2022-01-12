import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StrengthvaluesComponent } from './strengthvalues.component';

describe('StrengthvaluesComponent', () => {
  let component: StrengthvaluesComponent;
  let fixture: ComponentFixture<StrengthvaluesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StrengthvaluesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StrengthvaluesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
