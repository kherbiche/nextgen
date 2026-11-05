import {HttpHandlerFn, HttpRequest, HttpEvent} from "@angular/common/http";
import {Observable} from "rxjs";
import {CsrfUtil} from "../utils/csrf.util";

export function CsrfInterceptor(
    req: HttpRequest<unknown>,
    next: HttpHandlerFn,
): Observable<HttpEvent<unknown>> {
    const csrfToken = CsrfUtil.getToken();
    const csrfHeaderName = CsrfUtil.getHeaderName();
    if (csrfToken) {
        const cloned = req.clone({
            headers : req.headers.set(csrfHeaderName, csrfToken)
        });
        return next(cloned);
    }
    return next(req);
}