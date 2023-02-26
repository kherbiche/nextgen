import { Component, OnInit } from '@angular/core';
import { LoginService } from '../shared/services/login.service';
import { Router } from '@angular/router';
import { UserStoreService } from '../shared/services/user-store.service';
import { TokenModel } from '../shared/models/token.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
	public email!: string;
	public password!: string;
	//private tokenModel!: TokenModel;

	constructor(private loginService: LoginService, private router: Router, private user: UserStoreService) {
	}

  ngOnInit(): void {}
  
  loginAnsej(): void {
	console.log('this.email=', this.email);
	console.log('this.pwd=', this.password);
	const postData: Array<string> = [this.email, this.password];
	
	this.loginService.login(postData).subscribe((result) => {
		this.router.navigate(['promoters', 'create']);
		//this.tokenModel = {token: result.token};
		this.user.setTokenModel(result.token);
		}, (err) => {
			console.error('Error login', err);
		}
		);
	}
	
	isLoggedIn(): boolean {
		//return this.tokenModel !== undefined;
		return this.user.isLoggedIn()
	}
}
