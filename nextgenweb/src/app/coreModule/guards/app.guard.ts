import {
    ActivatedRouteSnapshot,
    CanActivate,
    GuardResult,
    MaybeAsync,
    Router,
    RouterStateSnapshot
} from "@angular/router";
import {AuthorizationService} from "../services/authorization.service";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";
@Injectable()
export class AppGuard implements CanActivate {

    constructor(
        private authorizationService: AuthorizationService,
        private router: Router
    ) {}

    canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        //redirect and return false
        if (!this.authorizationService.isCanAccessApp) {
            console.error('user not auth : app');
            this.router.navigate(['']);
            return false;
        }
        return true;
    }
}