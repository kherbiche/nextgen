import {
    ActivatedRouteSnapshot,
    CanActivate,
    GuardResult,
    MaybeAsync,
    Router,
    RouterStateSnapshot
} from "@angular/router";
import {Injectable} from "@angular/core";
import {AuthorizationService} from "../services/authorization.service";
import {Observable} from "rxjs";

@Injectable()
export class TwoGuard implements CanActivate {
    constructor(
        private authorizationService: AuthorizationService,
        private router: Router
    ) {}

    canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        // redirect and retuen false
        if (!this.authorizationService.isCanAccessTwo) {
            console.error('User is not authorized : Two module');
            this.router.navigate(['']);
            return false;
        }

        return true;
    }
}