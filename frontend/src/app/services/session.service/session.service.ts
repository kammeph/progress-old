import { JsonpClientBackend } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject, BehaviorSubject, ReplaySubject } from 'rxjs';
import { User } from 'src/app/services/user.service/User';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  authenticatedUser: User | null = null;
  lastUserLogedInSubject = new ReplaySubject<User>(1);
  userLogedOutSubject = new Subject();

  constructor() {

   }

  changeUser(user: User | null) : void {
    console.log('changeUser');
    this.authenticatedUser = user;
    localStorage.setItem('authenticatedUser', JSON.stringify(user));
    if (user != null)
      this.lastUserLogedInSubject.next(user);
    else
      this.userLogedOutSubject.next();
  }
}
