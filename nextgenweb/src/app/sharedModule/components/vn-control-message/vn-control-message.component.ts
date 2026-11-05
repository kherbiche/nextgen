import {FormControl} from "@angular/forms";
import {TranslateService} from "@ngx-translate/core";
import {Component, Input} from "@angular/core";
import {CustomValidator} from "../../services/custom.validator.services";
import {VnSafeHtmlPipe} from "../../pipes/vn-safe-html.pipe";

@Component({
    selector: 'vn-control-message',
    templateUrl: './vn-control-message.component.html',
    imports: [VnSafeHtmlPipe]
})
export class VnControlMessageComponent {

    private _control: FormControl;
    private _validateAll = false;
    private _customClass = '';

    constructor(private translate: TranslateService) {}

    get errorMessages() {
        const errorMessages = [];
        if (this._control && this._control.errors) {
            for (const propertyName in this._control.errors) {
                if (this._control.errors.hasOwnProperty(propertyName) && this._control.touched) {
                    const validatorErrorMessage = CustomValidator.getValidatorErrorMessage(propertyName, this._control.errors[propertyName]);
                    if (validatorErrorMessage.key !== undefined) {
                        const errorMessage = this.translate.instant(validatorErrorMessage.key, validatorErrorMessage.params);

                        if (!this.validateAll) {
                            return [errorMessage];
                        }

                        errorMessages.push(errorMessage);
                    }
                }
            }
        }
        return errorMessages;
    }

    @Input()
    get control() {return this._control; }
    set control(value: any) { this._control = value; }

    @Input()
    get validateAll() { return this._validateAll; }
    set validateAll(value: any) {this._validateAll = value !=null && `${value}` !== 'false'; }

    @Input()
    get customClass() {return this._customClass; }
    set customClass(value: any) { this._customClass = value; }
}