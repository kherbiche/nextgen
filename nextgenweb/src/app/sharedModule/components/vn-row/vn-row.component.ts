import {Component, Input, OnInit, ViewContainerRef} from "@angular/core";
import {ModalDialogService} from "@euro-ombudsman/ngx-modal-dialog";
import {NgClass} from "@angular/common";
import {has} from "lodash";
import {VnControlMessageComponent} from "../vn-control-message/vn-control-message.component";
import {VnSafeHtmlPipe} from "../../pipes/vn-safe-html.pipe";
import {VnErrorWrapperComponent} from "../vn-error-wrapper/vn-error-wrapper.component";

@Component({
    selector: 'vn-row',
    templateUrl: './vn-row.component.html',
    imports: [NgClass, VnErrorWrapperComponent, VnControlMessageComponent, VnSafeHtmlPipe]
})
export class VnRowComponent implements OnInit {

    @Input() label: string;
    @Input() labelClass: string;
    @Input() tooltip: string;
    @Input() tooltipModal: any;
    @Input() rowCustomClass: string;
    @Input() formRowClass: string = 'form-row';
    @Input() formRowCustomClass: string;

    private _asterisk;
    private _controls;


    constructor(private readonly modalService: ModalDialogService, private readonly viewRef: ViewContainerRef) {}

    ngOnInit() {
        if (this._asterisk === undefined) {
            let hasRequired = false;
            if (this._controls) {
                for (const ctrl of this._controls) {
                    if (has(ctrl.errors, 'vnRequired') || has(ctrl.errors, 'vnRequiredArray')) {
                        hasRequired = true;
                        break;
                    }
                }
            }

            if (hasRequired) {
                this._asterisk = true;
            }
        }
    }

    @Input()
    get asterisk() { return this._controls; }
    set asterisk(value: any) { this._asterisk = value != null && `${value}` !== 'false'; }
    @Input()
    get controls() {return this._controls; }
    set controls(value: any) {
        if (!value) {
            this._controls = null;
        } else if (value instanceof Array) {
            this._controls = value;
        } else {
            this._controls = [value];
        }
    }

    openDialogFromLink(event, title, content) {
        if (event?.target?.nodeName?.toLowerCase() === 'a') {
            this.openDialog(title, content);
        }
    }

    openDialog(title, content, withCloseBtn = false) {
        const actionButtons = withCloseBtn ? [{text: 'Terminer', buttonClass: 'button green mas right', onAction: () => true}] : null;

        this.modalService.openDialog(this.viewRef, {
            title: title,
            settings: {
                closeButtonClass: 'close theme-icon-close',
                closeButtonTitle: 'fermer'
            },
            actionButtons: actionButtons,
            data: {
                text: content
            },
        });
    }
}