import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AppRoutesModule } from './app-routes.module';
import { CreatePromoterComponent } from './promoter/create-promoter/create-promoter.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ListPromoterComponent } from './promoter/list-promoter/list-promoter.component';
import { ItemPromoterComponent } from './promoter/item-promoter/item-promoter.component';
import { AnsejAppInterceptor } from './shared/services/ansej-app.interceptor';
import { LoginService } from './shared/services/login.service';
import { PromoterService } from './shared/services/promoter.service';
import { UserStoreService } from './shared/services/user-store.service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CreatePromoterComponent,
    HeaderComponent,
    FooterComponent,
    ListPromoterComponent,
    ItemPromoterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutesModule
  ],
  providers: [
	PromoterService,
	LoginService,
	UserStoreService,
	{
		provide: HTTP_INTERCEPTORS,
		useClass: AnsejAppInterceptor,
		multi: true,
		}
	],
  bootstrap: [AppComponent]
})
export class AppModule { }
