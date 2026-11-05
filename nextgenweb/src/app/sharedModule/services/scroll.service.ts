import {Injectable, OnDestroy} from "@angular/core";
import {Subscription} from "rxjs";

@Injectable()
export class ScrollService implements OnDestroy {

    private subscription: Subscription;
    ngOnDestroy(){
        if (this.subscription) {
            this.subscription.unsubscribe();
        }
    }

}