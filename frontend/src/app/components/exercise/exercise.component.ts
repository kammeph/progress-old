import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { Exercise } from 'src/app/services/exercise.service/Exercise';
import { ExerciseService } from 'src/app/services/exercise.service/exercise.service';
import { take, tap } from 'rxjs/operators';
import { LoadFactor } from 'src/app/services/loadfactor.service/LoadFactor';
import { LoadfactorService } from 'src/app/services/loadfactor.service/loadfactor.service';

@Component({
  selector: 'app-exercise',
  templateUrl: './exercise.component.html',
  styleUrls: ['./exercise.component.scss']
})
export class ExerciseComponent implements OnInit, OnChanges {

  @Input() exercise!: Exercise;
  @Output() onClose = new EventEmitter();
  loadFactors: LoadFactor[] = [];

  constructor(
    private exerciseService: ExerciseService, 
    private loadFactorService: LoadfactorService) {
  }
  
  ngOnChanges(changes: SimpleChanges): void {
    this.fetch();
  }

  ngOnInit(): void {
    this.fetch();
  }

  fetch(): void {
    if (this.exercise !== undefined) {
      this.loadFactorService.getByExercise(this.exercise.id)
        .pipe(take(1), tap(res => res.sort((a,b) => a.muscleGroupNumber < b.muscleGroupNumber ? -1 : 1)))
        .subscribe(res => this.loadFactors = res);
    }
  }

  update(): void {
    this.exerciseService.update(this.exercise.id, this.exercise).subscribe();
    this.loadFactors.forEach(loadFactor => this.loadFactorService.update(loadFactor.id, loadFactor).subscribe());
  }
}
