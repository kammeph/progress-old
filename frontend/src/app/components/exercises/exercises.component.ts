import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { of } from 'rxjs';
import { catchError, take, tap } from 'rxjs/operators';
import { Exercise } from 'src/app/services/exercise.service/Exercise';
import { ExerciseService } from 'src/app/services/exercise.service/exercise.service';
import { ExerciseGroup } from 'src/app/services/exercisegroup.service/ExerciseGroup';
import { ExercisegroupService } from 'src/app/services/exercisegroup.service/exercisegroup.service';

@Component({
  selector: 'app-exercises',
  templateUrl: './exercises.component.html',
  styleUrls: ['./exercises.component.scss']
})
export class ExercisesComponent implements OnInit {

  @Input() exerciseGroup!: ExerciseGroup;
  @Output() exerciseSelected = new EventEmitter<Exercise>();
  @Output() exerciseDeleted = new EventEmitter();
  @Output() onUpdateExerciseGroup = new EventEmitter<ExerciseGroup>();
  @Output() onDeleteExerciseGroup = new EventEmitter<ExerciseGroup>();
  exercises: Exercise[] = [];
  edit: boolean = false;

  constructor(private exerciseService: ExerciseService) {
  }

  ngOnInit(): void {
    this.exerciseService.getByExerciseGroup(this.exerciseGroup.id).pipe(
      tap(res => this.exercises = res),
      take(1),
      catchError(err => of(console.log(err)))
    ).subscribe();
  }

  add(): void {
    this.exerciseService.initialize(this.exerciseGroup.id).pipe(
      tap(res => this.exercises.push(res)),
      take(1),
      catchError(err => of(console.log(err)))
    ).subscribe();
  }

  delete(exercise: Exercise) {
    this.exerciseService.delete(exercise.id).pipe(
      take(1),
      catchError(err => of(console.log(err)))
    ).subscribe();
    this.exercises = this.exercises.filter(e => e.id !== exercise.id);
    this.exerciseDeleted.emit();
  }
}
