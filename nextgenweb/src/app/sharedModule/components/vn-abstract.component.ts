import {Subject} from "rxjs";
import {FormArray, FormControl, FormGroup} from "@angular/forms";

export abstract class VnAbstractComponent {
    protected  unsubscribeStore$ = new Subject();

    doScrollTo(className: string, interval: number = 400) {
        if (!className) { return; }

        setTimeout(() => {
            const elements = document.getElementsByClassName(className);
            if (elements.length === 0) {
                return;
            }
            window.scroll({
                top: this.getOffset(elements[0]).top - interval,
                left: 0,
                behavior: 'smooth'
            });
        }, 100);
    }

    getOffset(el) {
        el = el.getBoundingClientRect();
        return {
            left: el.left + window.scrollX,
            top: el.top + window.scrollY
        }
    }

    doValidate(form): boolean {
        this.updateValueAndValidity(form);
        form.updateValueAndValidity();
        if (!form.valid) {
            this.doScrollTo('errorList');
        }
        return form.valid;
    }

    public updateValueAndValidity(form) {
        for (const field in form.controls) {
            if (field) {
                const control = form.controls[field];
                if (control.enabled && (control instanceof FormControl || control instanceof FormArray || control instanceof FormGroup)) {
                    control.markAsTouched({onlySelf: true});
                    this.updateValueAndValidity(control);
                } else {
                    control.markAsTouched({onlySelf: true});
                    control.updateValueAndValidity({onlySelf: true, emitEvent: false});
                }
            }
        }
    }
}