import {Component, OnDestroy, OnInit} from "@angular/core";
import {Subscription} from "rxjs";
import {HttpExceptionService} from "../../../coreModule/services/http-exception.service";
import {VnInfoMessageComponent} from "../vn-info-message/vn-info-message.component";

@Component({
    selector: 'vn-exception',
    templateUrl: './vn-exception.component.html',
    imports: [VnInfoMessageComponent]
})
export class VnExceptionComponent implements OnInit, OnDestroy {

    private subscription: Subscription;
    exceptionInfo = {catched: false, number: '', datetime: '', messages: []};

    constructor(private httpExceptionService: HttpExceptionService) {
    }

    ngOnInit() {
        this.subscription = this.httpExceptionService
            .httpExceptionSubject
            .subscribe((data: any) => {
                if (data) {
                    if (data instanceof Array) {
                        this.exceptionInfo.catched = true;
                        this.exceptionInfo.messages = data;
                    } else if (typeof data === 'string') {
                        this.exceptionInfo.catched = true;
                        const nIncidentArray = data.match(/<N_INCIDENT>(.*?)<N_INCIDENT>/);
                        if (nIncidentArray && nIncidentArray.length > 0) {
                            this.exceptionInfo.number = nIncidentArray[1];
                        }

                        const dateTimeArray = data.match(/<DATETIME>(.*?)<DATETIME>/);
                        if (dateTimeArray && dateTimeArray.length > 0) {
                            this.exceptionInfo.datetime = dateTimeArray[1];
                        }
                    }
                } else {
                    this.exceptionInfo.catched = false;
                }
            });
    }

    ngOnDestroy() {
        if (this.subscription) {
            this.subscription.unsubscribe();
        }
    }
}