import {Routes} from "@angular/router";
import {TwoMainComponent} from "./two.main.component";
import {TwoMainState} from "./two.main.state";
import {TwoMainService} from "../services/two.main.service";
import {provideStates} from "@ngxs/store";
import {PreambuleComponent} from "./components/preambule/preambule.component";
import {InfopersoComponent} from "./components/infoperso/infoperso.component";

export const routes: Routes = [
    {
        path: '',
        component: TwoMainComponent,
        children: [
            {path: '', redirectTo: 'preambule', pathMatch: 'full'},
            {path: 'preambule', component: PreambuleComponent, data: {}, resolve: {}},
            {path: 'infoperso', component: InfopersoComponent, data: {}, resolve: {}}
        ],
        providers: [
            provideStates([TwoMainState]),
            TwoMainService
        ]
    }
];