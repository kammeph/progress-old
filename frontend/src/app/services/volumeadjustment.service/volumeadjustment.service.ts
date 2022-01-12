import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenericDataService } from '../GenericHttpService';
import { VolumeAdjustment } from './VolumeAdjustment';
import { VolumeAdjustmentSelection } from './VolumeAdjustmentSelection';

@Injectable({
  providedIn: 'root'
})
export class VolumeadjustmentService extends GenericDataService<VolumeAdjustment> {

  constructor(http: HttpClient, @Inject('API_URL') apiUrl: string) {
    super(http, apiUrl, 'volumeadjustment');
  }

  getByProperty(property: number): Observable<VolumeAdjustment[]> {
    const url = `${this.apiUrl + this.basePath}/getByProperty/${property}`;
    return this.http.get<VolumeAdjustment[]>(url);
  }

  getByGender(gender: number): Observable<VolumeAdjustment[]> {
    const url = `${this.apiUrl + this.basePath}/getByGender/${gender}`;
    return this.http.get<VolumeAdjustment[]>(url);
  }

  getByUser(user: number): Observable<VolumeAdjustment[]> {
    const url = `${this.apiUrl + this.basePath}/getByUser/${user}`;
    return this.http.get<VolumeAdjustment[]>(url);
  }

  addUser(id: number, userid: number): Observable<any> {
    const url = `${this.apiUrl + this.basePath}/addUser/${id}/${userid}`;
    return this.http.post<VolumeAdjustment>(url, this.httpOptions);
  }

  removeUser(id: number, userid: number): Observable<any> {
    const url = `${this.apiUrl + this.basePath}/removeUser/${id}/${userid}`;
    return this.http.post<VolumeAdjustment>(url, this.httpOptions);
  }

  getVolumeAdjustmentSelections(userid: number, gender: number): Observable<VolumeAdjustmentSelection[]> {
    const url = `${this.apiUrl + this.basePath}/getVolumeAdjustmentSelections/${userid}/${gender}`;
    return this.http.get<VolumeAdjustmentSelection[]>(url);
  }
}
