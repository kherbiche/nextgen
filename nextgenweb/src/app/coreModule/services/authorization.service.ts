import {Injectable} from "@angular/core";

@Injectable()
export class AuthorizationService {

    constructor() {
    }

    get isCanAccessApp() {
        return true;
    }

    get isCanAccessAffNouv() {
        return true;
    }

    get isCanAccessOutils() {
        return true;
    }

    get isCanAccessTwo() {
        return true;
    }
}