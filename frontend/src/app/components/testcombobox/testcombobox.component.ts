import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-testcombobox',
  templateUrl: './testcombobox.component.html',
  styleUrls: ['./testcombobox.component.scss']
})
export class TestcomboboxComponent implements OnInit {

  @Input() label = '';
  @Input() items: any[] = [];
  @Input() value!: any;
  @Input() displayValuePath!: string;
  @Output() valueChange = new EventEmitter();


  constructor() { }

  ngOnInit(): void {
  }

  updateValue(value: any) {
    this.value = value;
    this.valueChange.emit(value);
  }
}
