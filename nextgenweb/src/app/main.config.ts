import { ApplicationConfig, importProvidersFrom, LOCALE_ID, provideZoneChangeDetection } from "@angular/core";
import {environment} from "../environments/environment";
import {provideHttpClient, withInterceptors} from "@angular/common/http";
import {CsrfInterceptor} from "./coreModule/interceptors/csrf.interceptor";
import {provideNgxMask} from "ngx-mask";
import {provideTranslateHttpLoader} from "@ngx-translate/http-loader";
import {provideTranslateService} from "@ngx-translate/core";
import {provideStore, withNgxsPlugin} from "@ngxs/store";
import {StorageOption, withNgxsStoragePlugin} from "@ngxs/storage-plugin";
import {withNgxsLoggerPlugin} from "@ngxs/logger-plugin";
import {withNgxsReduxDevtoolsPlugin} from "@ngxs/devtools-plugin";
import {pendingRequestsInterceptor$} from "ng-http-loader";
import {HttpExceptionService} from "./coreModule/services/http-exception.service";
import {InitializationService} from "./coreModule/services/initialization.service";
import {AuthorizationService} from "./coreModule/services/authorization.service";
import {NoPreloading, provideRouter, withComponentInputBinding, withHashLocation, withPreloading, withRouterConfig} from "@angular/router";
import {coreRoutes} from "./coreModule/core-routing.module";
import {HttpExceptionInterceptor} from "./coreModule/interceptors/http-exception.interceptor";
import {ModalDialogModule} from "@euro-ombudsman/ngx-modal-dialog";
import {AppGuard} from "./coreModule/guards/app.guard";
import {clearStorePlugin} from "./sharedModule/plugins/clear-store.service";
import {ExternalRedirectResolver} from "./coreModule/resolvers/external-redirect.resolver";
import {ScrollService} from "./sharedModule/services/scroll.service";
import {ProgressStepsBuilderService} from "./sharedModule/services/progress.steps.builder.service";

export const mainConfig: ApplicationConfig = {
  providers: [
    {provide: LOCALE_ID, useValue: 'fr-FR'},
    provideZoneChangeDetection(),
    provideRouter(
        coreRoutes,
        withComponentInputBinding(),
        withRouterConfig({ paramsInheritanceStrategy: 'always', onSameUrlNavigation: 'reload' }),
        withPreloading(NoPreloading),
        withHashLocation()
    ),
    provideNgxMask(),
    provideHttpClient(withInterceptors([
      CsrfInterceptor,
      HttpExceptionInterceptor,
      pendingRequestsInterceptor$
    ])),
    provideTranslateService({
      loader: provideTranslateHttpLoader({
        prefix: environment.i18n_path,
        suffix: '.json'
      })
    }),
    provideStore([], {developmentMode: !environment.production}),
    withNgxsPlugin(clearStorePlugin),
    withNgxsStoragePlugin({keys: '*', storage: StorageOption.SessionStorage}),
    withNgxsLoggerPlugin({disabled: environment.production}),
    withNgxsReduxDevtoolsPlugin({disabled: environment.production}),
    importProvidersFrom(ModalDialogModule.forRoot()),
    HttpExceptionService,
    InitializationService,
    AuthorizationService,
    ScrollService,
    // ProgressStepsBuilderService,
    AppGuard,
    ExternalRedirectResolver
  ]
};
