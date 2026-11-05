import {AfterContentChecked, ChangeDetectorRef, Component, OnDestroy, OnInit, ViewContainerRef} from "@angular/core";
import {Store} from "@ngxs/store";
import {TwoMainService} from "../../../services/two.main.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SpinnerVisibilityService} from "ng-http-loader";
import {ModalDialogService} from "@euro-ombudsman/ngx-modal-dialog";
import {Subscription} from "rxjs";
import {TwoMainData} from "../../../models/twoMainData";
import {NgClass} from "@angular/common";
import {NgxMaskDirective} from "ngx-mask";
import {VnAbstractComponent} from "../../../../sharedModule/components/vn-abstract.component";
import {VnRowComponent} from "../../../../sharedModule/components/vn-row/vn-row.component";
import {
    VnControlMessageComponent
} from "../../../../sharedModule/components/vn-control-message/vn-control-message.component";
import {VnSafeHtmlPipe} from "../../../../sharedModule/pipes/vn-safe-html.pipe";
import {TwoMainState, UpdatePreambule} from "../../two.main.state";
import {CustomValidator} from "../../../../sharedModule/services/custom.validator.services";

@Component({
    selector: 'preambule-component',
    templateUrl: './preambule.component.html',
    imports: [FormsModule, ReactiveFormsModule, NgClass, NgxMaskDirective, VnRowComponent, VnControlMessageComponent, VnSafeHtmlPipe]
})
export class PreambuleComponent extends VnAbstractComponent implements OnInit, OnDestroy, AfterContentChecked {

    private subscription: Subscription;
    preambuleForm: FormGroup;
    twoMainData: TwoMainData;

    constructor(private readonly store: Store,
                private readonly router: Router,
                private readonly twoMainService: TwoMainService,
                private readonly activatedRoute: ActivatedRoute,
                private readonly viewRef: ViewContainerRef,
                private readonly fb: FormBuilder,
                private readonly spinner: SpinnerVisibilityService,
                private readonly modalService: ModalDialogService,
                private readonly cdref: ChangeDetectorRef) {
        super();

        this.preambuleForm = this.fb.group({
            nom: ['', CustomValidator.required('Le nom est obligatoire')],
            prenom: ['', CustomValidator.required('Le prénom est obligatoire')],
        });
    }

    ngOnInit() {
        this.subscription = this.store.subscribe(({TwoMainState}) => {
            if (TwoMainState) {
                this.twoMainData = TwoMainState;
                this.preambuleForm.patchValue(this.twoMainData.preambule);
            }
        });
    }
    ngOnDestroy() { if (this.subscription) { this.subscription.unsubscribe(); } }
    ngAfterContentChecked() { this.cdref.detectChanges(); }

    doNext() {
        this.updateValueAndValidity(this.preambuleForm);
        if (this.doValidate(this.preambuleForm)) {
            this.store.dispatch(new UpdatePreambule(this.preambuleForm.getRawValue())).subscribe(() => {
                this.router.navigate(['../infoperso'], {relativeTo: this.activatedRoute});
            });
        }
    }

    doPrevious() {
        this.router.navigate(['../preambule'], {relativeTo: this.activatedRoute});
    }
}