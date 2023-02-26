import { Component, OnInit, Input } from '@angular/core';

import { Promoter } from '../../shared/models/promoter';

@Component({
  selector: 'app-item-promoter',
  templateUrl: './item-promoter.component.html',
  styleUrls: ['./item-promoter.component.css']
})
export class ItemPromoterComponent implements OnInit {
	
	@Input() public promoter!: Promoter;

  constructor() { }

  ngOnInit(): void {
  }

}
