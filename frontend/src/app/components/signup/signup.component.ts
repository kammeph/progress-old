import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { SessionService } from 'src/app/services/session.service/session.service';
import { UserService } from '../../services/user.service/user.service';
import { ComboboxValue } from '../combobox/ComboboxValue';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  username = '';
  gender = '';
  password = '';
  passwordRepeat = '';
  signupFailed = false;
  error : String = '';
  signupSucceeded = false;
  genders: ComboboxValue[] = [{value: 'male', description: 'männlich'}, {value: 'female', description: 'weiblich'}];

  constructor(private userService:UserService, private sessionService: SessionService) { }

  ngOnInit(): void {
  }

  signup() {
    if (this.password !== this.passwordRepeat) {
      this.error = 'Passwörter sind nicht identisch.';
      this.signupFailed = true;
      return;
    }

    if (this.gender !== 'male' && this.gender !== 'female') {
      this.error = 'Geschlecht ist ungültig.';
      this.signupFailed = true;
      return;
    }

    this.userService.signup(this.username, this.password, this.gender).subscribe(
      res => {
        console.log('Sign up succeeded');
        this.signupSucceeded = true;
        this.sessionService.changeUser(res);
      },
      (error : HttpErrorResponse) => {
        console.log(error);
        this.error = error.error;
        this.signupFailed = true;
      }
    );
  }
}
