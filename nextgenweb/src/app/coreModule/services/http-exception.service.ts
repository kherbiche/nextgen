import {Injectable} from "@angular/core";
import {BehaviorSubject, Subject} from "rxjs";

@Injectable()
export class HttpExceptionService {

    private _httpExceptionSubject: Subject<String>;

    constructor() {
        this._httpExceptionSubject = new BehaviorSubject<String>('');
    }

    get httpExceptionSubject() {
        return this._httpExceptionSubject;
    }

}