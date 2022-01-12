import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { TextboxComponent } from '../textbox/textbox.component';

@Component({
  selector: 'app-passwordbox',
  templateUrl: './passwordbox.component.html',
  styleUrls: ['./passwordbox.component.scss']
})
export class PasswordboxComponent extends TextboxComponent implements OnInit {

  hide = true;

  constructor() {
    super();
   }

  ngOnInit(): void {
  }
}
