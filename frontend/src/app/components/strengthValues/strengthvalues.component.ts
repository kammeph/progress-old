import { Component, OnInit } from '@angular/core';
import { Observable, of, Subscription } from 'rxjs';
import { catchError, switchMap, tap } from 'rxjs/operators'
import { StrengthValue } from 'src/app/services/strengthvalue.service/StrengthValue';
import { SessionService } from 'src/app/services/session.service/session.service';
import { StrengthvalueService } from 'src/app/services/strengthvalue.service/strengthvalue.service';

@Component({
  selector: 'app-strengthvalues',
  templateUrl: './strengthvalues.component.html',
  styleUrls: ['./strengthvalues.component.scss']
})
export class StrengthvaluesComponent implements OnInit {

  total: number = 0.0;
  strengthValues: StrengthValue[] = [];

  constructor(
    private strengthValueService: StrengthvalueService,
    private sessionService: SessionService) {
      this.sessionService.lastUserLogedInSubject.pipe(
        switchMap(user => this.strengthValueService.getByUser(user.id)),
        tap(res => res.sort((a, b) => a.orderNumber < b.orderNumber ? -1 : 1)),
        tap(res => this.strengthValues = res),
        tap(res => this.onOneRepMaxChange(res)),
        catchError(err => of(console.log(err))),
      ).subscribe();
  }

  ngOnInit(): void {
  }

  onOneRepMaxChange(strengthValues: StrengthValue[]) {
    this.total = Number(strengthValues
      .filter(value => value.includeInTotal)
      .map(value => value.oneRepMax)
      .reduce((prev, cur) => prev += cur).toFixed(2));
  }

  save() {
    this.strengthValues.forEach(value => this.strengthValueService.update(value.id, value).subscribe());
  }
}
