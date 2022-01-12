import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExercisegroupsComponent } from './exercisegroups.component';

describe('ExercisegroupsComponent', () => {
  let component: ExercisegroupsComponent;
  let fixture: ComponentFixture<ExercisegroupsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExercisegroupsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExercisegroupsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
