import {HttpErrorResponse, HttpEvent, HttpHandlerFn, HttpRequest, HttpResponse} from "@angular/common/http";
import {catchError, map, Observable, throwError} from "rxjs";
import {HttpExceptionService} from "../services/http-exception.service";
import {inject} from "@angular/core";

export function HttpExceptionInterceptor(
    req: HttpRequest<unknown>,
    next: HttpHandlerFn,
): Observable<HttpEvent<unknown>> {
    let httpExceptionService = inject(HttpExceptionService);

    //Bypasser l'interceptor si le header est présent
    if (req.headers.has('X-skip-Interceptor')) {
        const clonedReq = req.clone({
            headers: req.headers.delete('X-skip-Interceptor')
        });
        return next(clonedReq);
    }

    return next(req).pipe(
        map((event: HttpEvent<any>) =>{
            if (event instanceof HttpResponse) {
                if (event.status === 200 && event.body && event.body.errorList) {
                    httpExceptionService.httpExceptionSubject.next(<any> event.body.errorList);
                }
            }
            return event;
        }),
        catchError(err => {
            if (err instanceof HttpErrorResponse) {
                if (err.status === 500) {
                    httpExceptionService.httpExceptionSubject.next(<string> err.error);
                    return throwError(() => err);
                } else {
                    return throwError(() => err);
                }
            }
        })
    );
}