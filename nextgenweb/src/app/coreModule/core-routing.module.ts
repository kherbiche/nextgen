import {Routes} from "@angular/router";
import {AppGuard} from "./guards/app.guard";
import {TwoGuard} from "./guards/two.guard";
import {TwoMainService} from "../twoModule/services/two.main.service";
import {ExternalRedirectResolver} from "./resolvers/external-redirect.resolver";
import {VnSpinnerComponent} from "./components/vn-spinner/vn-spinner.component";

export const coreRoutes: Routes = [
    {
        path: 'two',
        canActivate: [AppGuard],
        loadChildren: async () => import('../twoModule/twoCoreModule/two.core.routing').then(m => m.routes),
        providers: [TwoGuard, TwoMainService]
    },
    {
        path: 'externalRedirect',
        canActivate: [AppGuard],
        resolve: {
            url: ExternalRedirectResolver,
        },
        component: VnSpinnerComponent,
    }
];