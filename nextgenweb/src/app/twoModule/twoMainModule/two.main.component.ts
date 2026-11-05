import {Component} from "@angular/core";
import {RouterOutlet} from "@angular/router";
import {TranslateService} from "@ngx-translate/core";
import {InitializationService} from "../../coreModule/services/initialization.service";
import {Store} from "@ngxs/store";
import {Init} from "./two.main.state";
import {VnExceptionComponent} from "../../sharedModule/components/vn-exception/vn-exception.component";

@Component({
    selector: 'two-main-module',
    template: `<div class='main' id='main' role='main'>
                    <vn-exception>
                        <router-outlet></router-outlet>
                    </vn-exception>
                </div>`,
    imports: [VnExceptionComponent, RouterOutlet]
})
export class TwoMainComponent {

    constructor(translate: TranslateService, initializationService: InitializationService, private store: Store) {
        translate.use('');
        initializationService.initializationSubject.subscribe((data) => {
            // on fait appel au store
            store.dispatch(new Init(data.prsId, data.codeInter));
        });
    }
}