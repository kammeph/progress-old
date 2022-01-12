import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Inject } from '@angular/core';
import { Observable } from 'rxjs';

export class GenericDataService<T> {

    protected httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin':'*'
      })
    }


    constructor(protected http:HttpClient, @Inject('API_URL') protected apiUrl:string, protected basePath:string) {
     }
  
    getAll(): Observable<T[]> {
      return this.http.get<T[]>(this.apiUrl + this.basePath);
    }

    get(id:number): Observable<T> {
        const url = `${this.apiUrl + this.basePath}/${id}`;
        return this.http.get<T>(url);
    }

    delete(id:number): Observable<T> {
      const url = `${this.apiUrl + this.basePath}/${id}`;
      return this.http.delete<T>(url);
    }
  
    update(id:number, dto:T): Observable<T> {
      const url = `${this.apiUrl + this.basePath}/${id}`;
      return this.http.put<T>(url, dto, this.httpOptions);
    }
  
    add(dto:T): Observable<T> {
      const url = `${this.apiUrl + this.basePath}`;
      return this.http.post<T>(url, dto, this.httpOptions);
    }
}