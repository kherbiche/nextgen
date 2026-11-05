import {Routes} from "@angular/router";
import {TwoGuard} from "../../coreModule/guards/two.guard";

export const routes: Routes = [
    {
        path: 'main',
        canActivate: [TwoGuard],
        loadChildren: async () => import('../twoMainModule/two.main.routing.module').then(m => m.routes),
    }
];