import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Exercise } from 'src/app/services/exercise.service/Exercise';
import { GenericDataService } from '../GenericHttpService';

@Injectable({
  providedIn: 'root'
})
export class ExerciseService extends GenericDataService<Exercise> {

  constructor(http: HttpClient, @Inject('API_URL') apiUrl: string) {
    super(http, apiUrl, 'exercise')
   }

   getByExerciseGroup(exercisegroup: number) : Observable<Exercise[]> {
     const url = `${this.apiUrl + this.basePath}/getByExerciseGroup/${exercisegroup}`;
     return this.http.get<Exercise[]>(url);
   }

   initialize(exercisegroup: number) : Observable<Exercise> {
    const url = `${this.apiUrl + this.basePath}/initialize/${exercisegroup}`;
    return this.http.post<Exercise>(url, {}, this.httpOptions);
   }
}
