import {Component, Input} from "@angular/core";
import {NgClass} from "@angular/common";

@Component({
    selector: 'vn-error-wrapper',
    templateUrl: './vn-error-wrapper.component.html',
    imports: [NgClass]
})
export class VnErrorWrapperComponent {

    private _controls;
    @Input() formRowCustomClass: string;

    constructor() {}

    hasErrors() {
        let hasError = false;
        for (const _control of this._controls) {
            if (_control && _control.errors) {
                for (const propertyName in _control.errors) {
                    if (_control.errors.hasOwnProperty(propertyName) && _control.touched) {
                        hasError = true;
                    }
                }
            }
        }
        return hasError;
    }

    @Input()
    get controls() {return this._controls; }
    set controls(value: any) {
        if (!value) {
            this._controls = [];
        } else if (value instanceof Array) {
            this._controls = value;
        } else {
            this._controls = [value];
        }
    }
}