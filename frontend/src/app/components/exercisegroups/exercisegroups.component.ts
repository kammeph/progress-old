import { Component, OnInit } from '@angular/core';
import { ReplaySubject, Subject } from 'rxjs';
import { subscribeOn, take, tap } from 'rxjs/operators';
import { Exercise } from 'src/app/services/exercise.service/Exercise';
import { ExerciseGroup } from 'src/app/services/exercisegroup.service/ExerciseGroup';
import { ExercisegroupService } from 'src/app/services/exercisegroup.service/exercisegroup.service';

@Component({
  selector: 'app-exercisegroups',
  templateUrl: './exercisegroups.component.html',
  styleUrls: ['./exercisegroups.component.scss']
})
export class ExercisegroupsComponent implements OnInit {

  exerciseGroups: ExerciseGroup[] = [];
  selectedExercise!: Exercise;
  edit: boolean = false;

  constructor(private exerciseGroupService: ExercisegroupService) {
  }

  ngOnInit(): void {
    this.exerciseGroupService.getAll().pipe(take(1)).subscribe(res => this.exerciseGroups = res);
  }

  add(): void {
    var group: ExerciseGroup = { id: 0, name: 'Neue Gruppe', descdription: '' };
    this.exerciseGroupService.add(group).subscribe(res => this.exerciseGroups.push(res));
  }

  update(event: any): void {
    console.log('update')
    console.log(event)
    let exerciseGroup = event as ExerciseGroup;
    this.exerciseGroupService.update(exerciseGroup.id, exerciseGroup).subscribe();
  }

  delete(event: any): void {
    let exerciseGroup = event as ExerciseGroup;
    this.exerciseGroupService.delete(exerciseGroup.id).subscribe();
    this.exerciseGroups = this.exerciseGroups.filter(group => group.id !== exerciseGroup.id);
  }

  onExerciseSelected(event: any) {
    this.selectedExercise = event as Exercise;
  }

}