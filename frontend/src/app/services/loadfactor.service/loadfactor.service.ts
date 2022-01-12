import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericDataService } from '../GenericHttpService';
import { LoadFactor } from './LoadFactor';

@Injectable({
  providedIn: 'root'
})
export class LoadfactorService extends GenericDataService<LoadFactor> {


  constructor(http: HttpClient, @Inject('API_URL') apiUrl: string) {
    super(http, apiUrl, 'loadfactor');
   }

   getByExercise(exercise: number) : Observable<LoadFactor[]> {
    const url = `${this.apiUrl + this.basePath}/getByExercise/${exercise}`;
    return this.http.get<LoadFactor[]>(url);
   }
}
