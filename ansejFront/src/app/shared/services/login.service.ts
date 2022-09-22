import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenModel } from '../models/token.model';

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  
  constructor(private http: HttpClient) { }
  
  public login(data: Array<string>): Observable<TokenModel> {
	  const url = environment.baseUrl + '/rest/auth';
	  const headers = new HttpHeaders().set('Authorization','Yugarten ');
	  const options = { headers: headers };

      return this.http.post<TokenModel>(url, data, options);
  }
}
