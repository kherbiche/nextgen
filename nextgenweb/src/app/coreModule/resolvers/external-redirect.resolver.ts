import {ActivatedRouteSnapshot, MaybeAsync, Resolve, RouterStateSnapshot} from "@angular/router";
import {Injectable} from "@angular/core";
import {CsrfUtil} from "../utils/csrf.util";

@Injectable()
export class ExternalRedirectResolver implements Resolve<any> {

    constructor() {
    }

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): any {
        const url = route.params['url'];
        const params = route.params['params'];
        const target = route.params['target'];
        const method = route.params['method'];
        const skipCsrf = route.params['skipCsrf'];

        const form = document.createElement('form');
        form.setAttribute('method', method || 'post');
        form.setAttribute('action', url);

        //ouverture d'une nouvelle fen^tre pour soumettre le formulaire à l'intérieur
        if (target === 'popup') {
            form.setAttribute('target', 'WSTAR');
            window.open('', 'WSTAR', 'menubar=no, scrollbars=yes, menubar=no, width=1350, hieght=800');
        } else {
            form.setAttribute('target', target || '_self');
        }

        if (!skipCsrf) {
            const csrfField = document.createElement('input');
            csrfField.setAttribute('name', CsrfUtil.getParameterName());
            csrfField.setAttribute('value', CsrfUtil.getToken());
            csrfField.setAttribute('type', 'hidden');
            form.appendChild(csrfField);
        }

        if (params) {
            const objParams = JSON.parse(params);
            for (const param in objParams) {
                if (param) {
                    const hiddenField = document.createElement('input');
                    hiddenField.setAttribute('name', param);
                    hiddenField.setAttribute('value', objParams[param]);
                    hiddenField.setAttribute('type', 'hidden');
                    form.appendChild(hiddenField);
                }
            }
        }
        document.body.appendChild(form);
        form.submit();
    }
}