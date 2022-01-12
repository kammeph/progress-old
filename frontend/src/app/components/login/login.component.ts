import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { SessionService } from 'src/app/services/session.service/session.service';
import { UserService } from 'src/app/services/user.service/user.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username = '';
  password = '';
  hide = true;
  error = '';
  loginFailed = false;

  constructor(
    private userService: UserService, 
    private sessionService: SessionService) { }

  ngOnInit(): void {
  }

  authenticate() {
    this.userService.authenticate(this.username, this.password).subscribe(
      user => {
        this.sessionService.changeUser(user);
        console.log('Login: ' + user.userName);
      }, 
      (error : HttpErrorResponse) => {
        this.error = error.error;
        this.loginFailed = true;
      });
  }
}
