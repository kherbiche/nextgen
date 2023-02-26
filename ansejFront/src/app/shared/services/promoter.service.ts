import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Promoter } from '../models/promoter';

@Injectable({
  providedIn: 'root'
})
export class PromoterService {

	constructor(private http: HttpClient) { }
  
	public savePromoter(p: Promoter): Observable<any> {
		const url = environment.baseUrl + '/rest/savepromoter';
		//const headers = new HttpHeaders().set('Authorization','Yugarten eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJhZmU1ZWIzNy1mNjQ2LTQyZDEtYjAyNy1mZDQ5ZWM4YTFiMGYiLCJhdWQiOiJodHRwOi8vZXhhbXBsZS5vcmciLCJzdWIiOiJraGVyIiwiaWF0IjoxNjc3NDM0MDg5LCJleHAiOjE2Nzc0NzAwODksImF1dGhvcml0aWVzIjpbIlJPTEVfQ09VTlNFTE9SIl0sInJlZnJlc2hDb3VudCI6MCwicmVmcmVzaExpbWl0IjoxfQ.rKUXQs0HHJeC4BQJDr9UFQHY8JsCo8kiSgGus01a02g');
		//const options = { headers: headers };
		var data: Array<string> = this.promoterToArray(p);
		//return this.http.post<any>(url, data, options);
		return this.http.post<any>(url, data);
	}
	
	public allPromoter(): Observable<Promoter[]> {
		const url = environment.baseUrl + '/rest/allpromoters';
		return this.http.get<Promoter[]>(url);
	}
  
	private promoterToArray(p: Promoter): Array<string> {
		var mapped: Array<string> = [];
		Object.keys(p).forEach(key => {
			mapped.push(p[key as keyof Promoter]);
		});
		console.log('mapped=', mapped);
		return mapped
	}
}
