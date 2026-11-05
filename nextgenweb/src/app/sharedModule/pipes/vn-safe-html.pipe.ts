import {Pipe, PipeTransform} from "@angular/core";
import {DomSanitizer} from "@angular/platform-browser";

@Pipe({ name: 'vnsafehtml' })
export class VnSafeHtmlPipe implements  PipeTransform {
    constructor(private sanitizer: DomSanitizer) {
    }

    transform(value: any) {
        return this.sanitizer.bypassSecurityTrustHtml(value);
    }
}