import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserStoreService } from './user-store.service';

@Injectable()
export class AnsejAppInterceptor implements HttpInterceptor {

	constructor(private user: UserStoreService) {}

	intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
		console.log('INTERCEPTING');
		if(this.user.isLoggedIn()) {
			console.log('INTERCEPTING, HAS TOKEN');
			const authReq = request.clone({
			headers: request.headers.set('Authorization', 'Yugarten '+this.user.getToken())
			});
			console.log('Making an authorized request');
			request = authReq;
		}
		return next.handle(request);
	}
}
