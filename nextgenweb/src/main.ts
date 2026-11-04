import {enableProdMode} from '@angular/core';

import {environment} from './environments/environment';
import {registerLocaleData} from '@angular/common';
import localeFr from '@angular/common/locales/fr';
import {mainConfig} from './app/main.config';
import {MainComponent} from "./app/main.component";
import {bootstrapApplication} from "@angular/platform-browser";


if (environment.production) { enableProdMode(); }

registerLocaleData(localeFr);

bootstrapApplication(MainComponent, mainConfig)
    .catch(err => console.log(err));
