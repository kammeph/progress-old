import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StrengthValue } from 'src/app/services/strengthvalue.service/StrengthValue';
import { GenericDataService } from '../GenericHttpService';

@Injectable({
  providedIn: 'root'
})
export class StrengthvalueService extends GenericDataService<StrengthValue> {

  constructor(http:HttpClient, @Inject('API_URL') apiUrl:string) { 
    super(http, apiUrl, 'strengthvalue');
  }

  getByUser(user: number) : Observable<StrengthValue[]> {
    const url = `${this.apiUrl + this.basePath}/getByUser/${user}`;
    return this.http.get<StrengthValue[]>(url);
  }
}
