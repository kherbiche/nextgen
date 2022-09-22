import { environment } from '../../environments/environment';

import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }
  
  loginAnsej (): void {
	  let login:any  = (<HTMLInputElement>window.document.getElementById('typeEmailX')).value;
	  let password:any  = (<HTMLInputElement>window.document.getElementById('typePasswordX')).value;
	  const url = environment.baseUrl + '/rest/auth';
	  //const url = 'http://192.168.1.101:8089/rest/auth';
      //let formData: FormData = new FormData();
      //formData.append('login', login);
      //formData.append('password', password);
      const postData  = [login, password];

      // //let headers = new HttpHeaders().set('access-control-allow-origin',"http://192.168.1.109:8089");
      //let headers = new HttpHeaders();
      //headers.append('access-control-allow-origin',"*");
      //headers.append('Authorization', "Yugarten ");
      //let options = {headers: headers}
	    
	  /*const headers = new HttpHeaders({
        'content-type': 'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': 'Yugarten '
      });*/
      
      
      const headers = new HttpHeaders().set('Authorization','Yugarten ');
      
	  const options = { headers: headers };
      
      
      this.http.post(url, postData, options).subscribe();

  }

}
