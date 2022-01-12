import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ComboboxValue } from './ComboboxValue';

@Component({
  selector: 'app-combobox',
  templateUrl: './combobox.component.html',
  styleUrls: ['./combobox.component.scss']
})
export class ComboboxComponent implements OnInit {

  @Input() label = '';
  @Input() items: ComboboxValue[] = [];
  @Input() value = '';
  @Output() valueChange = new EventEmitter<string>();

  constructor() { }

  ngOnInit(): void {
  }

  updateValue(value: string) {
    this.value = value;
    this.valueChange.emit(value);
  }

}
