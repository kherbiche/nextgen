import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {TwoMainData} from "../models/twoMainData";

@Injectable()
export class TwoMainService {

    constructor(private readonly http: HttpClient) {}

    init(prsId: string, codeInter: string): Observable<TwoMainData> {
        let body = new HttpParams();
        body.set('prsId', prsId);
        body.set('codeInter', codeInter);

        // const headers = new HttpHeaders({
        //     'Content-Type': 'application/json',
        //     'Access-Control-Allow-Origin' : '*',
        //     'Access-Control-Allow-Methods' : 'GET, POST, OPTIONS',
        //     'Access-Control-Allow-Headers' : 'Origin, Content-Type, Accept'
        // });
        return this.http.post<TwoMainData>('http://localhost:8080/tst/three/init', body);
    }
}