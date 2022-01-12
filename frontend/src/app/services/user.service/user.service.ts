import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/services/user.service/User';
import { GenericDataService } from '../GenericHttpService';

@Injectable({
  providedIn: 'root'
})
export class UserService extends GenericDataService<User> {

  constructor(http: HttpClient, @Inject('API_URL') apiUrl: string) {
    super(http, apiUrl, 'user');
  }

  authenticate(username: string, password: string): Observable<User> {
    const url = `${this.apiUrl + this.basePath}/authenticate/${username}/${password}`;
    return this.http.get<User>(url);
  }

  signup(username: string, password: string, gender: string): Observable<User> {
    const url = `${this.apiUrl + this.basePath}/signup/${username}/${password}/${gender}`;
    return this.http.post<User>(url, this.httpOptions);
  }
}
