import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { NavigationStart, Router, RouterEvent } from '@angular/router';
import { SessionService } from 'src/app/services/session.service/session.service';
import { User } from 'src/app/services/user.service/User';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {

  logedin: boolean = false;
  //userSubscription!: Subscription;

  constructor(
    private sessionService: SessionService, 
    private router: Router) {
      this.sessionService.lastUserLogedInSubject.subscribe(user => {
        this.logedin = true;
        this.router.navigateByUrl('/');
      });

      this.sessionService.userLogedOutSubject.subscribe(() => {
        this.logedin = false;
        this.router.navigateByUrl('/login');
      })

      let jsonUser = localStorage.getItem('authenticatedUser');
      if (jsonUser != null) {
        let user = JSON.parse(jsonUser) as User;
        sessionService.changeUser(user);
      }
  }

  ngOnInit(): void {
  }

  logout() : void {
    console.log('logout');
    this.sessionService.changeUser(null);
  }

}
