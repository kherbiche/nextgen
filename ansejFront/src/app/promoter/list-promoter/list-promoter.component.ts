import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Promoter } from '../../shared/models/promoter';
import { PromoterService } from '../../shared/services/promoter.service';

@Component({
  selector: 'app-list-promoter',
  templateUrl: './list-promoter.component.html',
  styleUrls: ['./list-promoter.component.css']
})
export class ListPromoterComponent implements OnInit {
	
	public promoters$!: Observable<Promoter[]>;

	constructor(private promoterService: PromoterService) { }

	ngOnInit(): void {
		this.promoters$ = this.promoterService.allPromoter();
		this.promoters$.subscribe(result => {
			if (result) {
				console.log('result', result);
				}
			});
		console.log('list promoters', this.promoters$);
	}
	
}
