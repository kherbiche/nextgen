import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { CreatePromoterComponent } from './promoter/create-promoter/create-promoter.component';
import { ListPromoterComponent } from './promoter/list-promoter/list-promoter.component';

const routes: Routes = [
	//{path:'', redirectTo: '/login', pathMatch: 'full'},
	{path: 'login', component: LoginComponent},
	{path: 'promoters/create', component: CreatePromoterComponent},
	{path: 'promoters/list', component: ListPromoterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
