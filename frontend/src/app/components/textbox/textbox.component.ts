import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-textbox',
  templateUrl: './textbox.component.html',
  styleUrls: ['./textbox.component.scss']
})
export class TextboxComponent implements OnInit {

  @Input() type = 'text'
  @Input() label = '';
  @Input() text: any;
  @Output() textChange = new EventEmitter<any>();
  @Output() keyup = new EventEmitter<any>();
  constructor() { }

  ngOnInit(): void {
  }

  updateValue(value: any){
    this.text = value;
    this.textChange.emit(value);
  }

  onKeyup(event: any) {
    this.keyup.emit(event);
  }

}
