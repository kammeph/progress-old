import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { ExerciseGroup } from 'src/app/services/exercisegroup.service/ExerciseGroup';
import { GenericDataService } from '../GenericHttpService';

@Injectable({
  providedIn: 'root'
})
export class ExercisegroupService extends GenericDataService<ExerciseGroup> {

  constructor(http: HttpClient, @Inject('API_URL') apiUrl: string) {
    super(http, apiUrl, 'exercisegroup');
  }
  
}
