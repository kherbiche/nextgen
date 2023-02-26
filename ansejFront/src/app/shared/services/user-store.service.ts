import { Injectable } from '@angular/core';

import { TokenModel } from '../models/token.model';

@Injectable({
  providedIn: 'root'
})
export class UserStoreService {
	
	private tokenModel!: TokenModel;

	constructor() {}
	
	setTokenModel(t: string) {
		this.tokenModel = {token: t};
		console.log('the Token= ', this.tokenModel.token);
	}
	getToken(): string {
		return this.tokenModel.token;
	}
	
	isLoggedIn(): boolean {
		return this.tokenModel !== undefined;
	}
}
