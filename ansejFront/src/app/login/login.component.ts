import { Component, OnInit } from '@angular/core';
import { LoginService } from '../shared/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {}
  
  loginAnsej (): void {
	  let login:any  = (<HTMLInputElement>window.document.getElementById('typeEmailX')).value;
	  let password:any  = (<HTMLInputElement>window.document.getElementById('typePasswordX')).value;
      const postData: Array<string> = [login, password];
      
      this.loginService.login(postData).subscribe(result => {
			console.log('theToken: ', result.token);
		  });
      
  }

}
