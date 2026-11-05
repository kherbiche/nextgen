import {Injectable} from "@angular/core";
import {BehaviorSubject, Subject} from "rxjs";

@Injectable()
export class InitializationService {
    private _initializationSubject: Subject<any>;

    constructor() {
        this._initializationSubject = new BehaviorSubject<any>('');
    }

    get initializationSubject() {
        return this._initializationSubject;
    }
}