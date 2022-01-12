import { AfterViewInit, Component, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { debounceTime, distinctUntilChanged, tap } from 'rxjs/operators';
import { StrengthValue } from 'src/app/services/strengthvalue.service/StrengthValue';
import { rpeChart } from '../../../assets/rpeChart'
import { TextboxComponent } from '../textbox/textbox.component';

@Component({
  selector: 'app-strengthvalue',
  templateUrl: './strengthvalue.component.html',
  styleUrls: ['./strengthvalue.component.scss']
})

export class StrengthvalueComponent implements AfterViewInit, OnInit {

  @Input() strengthValue!: StrengthValue;
  @ViewChild('weightInput', {static: false}) weightInput!: TextboxComponent;
  @ViewChild('repsInput', {static: false}) repsInput!: TextboxComponent;
  @Output() oneRepMaxChange = new EventEmitter();

  constructor() { 

  }
  
  ngAfterViewInit(): void {
    this.weightInput.keyup.pipe(
      debounceTime(150),
      distinctUntilChanged(),
      tap(() => this.calcOneRepMax())
    ).subscribe();
    this.repsInput.keyup.pipe(
      debounceTime(150),
      distinctUntilChanged(),
      tap(() => this.calcOneRepMax())
    ).subscribe();
  }

  ngOnInit(): void {
  }

  calcOneRepMax() {
    if (this.strengthValue.weight.toString() !== '' && this.strengthValue.reps.toString() !== '') {
      this.strengthValue.oneRepMax = Number((this.strengthValue.weight / rpeChart["10"][this.strengthValue.reps.toString()]).toFixed(2));
      this.oneRepMaxChange.emit();
    }
  }

}
