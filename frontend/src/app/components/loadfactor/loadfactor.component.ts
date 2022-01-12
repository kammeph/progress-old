import { Component, Input, OnInit } from '@angular/core';
import { LoadFactor } from 'src/app/services/loadfactor.service/LoadFactor';

@Component({
  selector: 'app-loadfactor',
  templateUrl: './loadfactor.component.html',
  styleUrls: ['./loadfactor.component.scss']
})
export class LoadfactorComponent implements OnInit {

  @Input() loadFactor!: LoadFactor;

  constructor() { }

  ngOnInit(): void {
  }

}
