import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StrengthvalueComponent } from './strengthvalue.component';

describe('StrengthvalueComponent', () => {
  let component: StrengthvalueComponent;
  let fixture: ComponentFixture<StrengthvalueComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StrengthvalueComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StrengthvalueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
