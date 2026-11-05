import {FormControl} from "@angular/forms";

export class CustomValidator {

    static getValidatorErrorMessage(validatorName: string, validatorValue?: any) {
        const config = {
            'vnrequired' : 'vienet.validators.required',
            'vnRequiredArray': 'vienet.validators.requiredArray',
        };

        return { 'key': validatorValue.message ? validatorValue.message : config[validatorName], 'params': validatorValue.params };
    }

    static required(message?) {
        return (control: FormControl) => {
            return isEmptyValue(control)? {'vnRequired': {'message': message} } : null;
        };
    }

    static conditional(message?, condition?) {
        return (control: FormControl) => {
            if (condition) {
                return isEmptyValue(control)? {'vnRequired': {'message': message} } : null;
            }
            return null;
        };
    }
}

function isEmptyValue(obj: any): boolean {
    return obj.value === undefined || obj.value === null || obj.value.length === 0;
}