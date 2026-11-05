import {VnAbstractComponent} from "../../../../sharedModule/components/vn-abstract.component";
import {ChangeDetectorRef, Component, OnDestroy, OnInit, ViewContainerRef} from "@angular/core";
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {NgClass} from "@angular/common";
import {NgxMaskDirective} from "ngx-mask";
import {VnRowComponent} from "../../../../sharedModule/components/vn-row/vn-row.component";
import {
    VnControlMessageComponent
} from "../../../../sharedModule/components/vn-control-message/vn-control-message.component";
import {VnSafeHtmlPipe} from "../../../../sharedModule/pipes/vn-safe-html.pipe";
import {Subscription} from "rxjs";
import {TwoMainData} from "../../../models/twoMainData";
import {Store} from "@ngxs/store";
import {ActivatedRoute, Router} from "@angular/router";
import {TwoMainService} from "../../../services/two.main.service";
import {SpinnerVisibilityService} from "ng-http-loader";
import {ModalDialogService} from "@euro-ombudsman/ngx-modal-dialog";
import {CustomValidator} from "../../../../sharedModule/services/custom.validator.services";
import {Conditional} from "@angular/compiler";
import {UpdateInfoperso, UpdatePreambule} from "../../two.main.state";

@Component({
    selector: 'infoperso-component',
    templateUrl: './infoperso.component.html',
    imports: [FormsModule, ReactiveFormsModule, NgClass, NgxMaskDirective, VnRowComponent, VnControlMessageComponent, VnSafeHtmlPipe]
})
export class InfopersoComponent extends  VnAbstractComponent implements OnInit, OnDestroy {

    private subscription: Subscription;
    infopersoForm: FormGroup;
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

        this.infopersoForm = this.fb.group({
            civilite: ['', CustomValidator.required()],
            nom: ['', CustomValidator.required()],
            //nomJF: ['', Conditional.required((control) => control.parent?.get('civilite')?.value === '02')],
            nomJF: ['', CustomValidator.conditional('Nom de jeune fille obligatoire', (control) => control.parent?.get('civilite')?.value === '02')],
            //nomJF: ['', Validators.conditional((control) => control.parent?.get('civilite')?.value === '02')],
            prenom: ['', CustomValidator.required()],
            dateDeNaissance: ['', CustomValidator.required()],
            paysDeNaissance: ['', CustomValidator.required()],
            lieuDeNaissance: ['', CustomValidator.required()],
            departementDeNaissance: ['', CustomValidator.required()],
        });
    }

    ngOnInit(): void {
        this.subscription = this.store.subscribe(({TwoMainState}) => {
            if (TwoMainState) {
                this.twoMainData = TwoMainState;
                this.infopersoForm.patchValue(this.twoMainData.infoperso);
            }
        });
    }

    ngOnDestroy() { if (this.subscription) { this.subscription.unsubscribe(); } }

    doNext() {
        this.updateValueAndValidity(this.infopersoForm);
        this.store.dispatch(new UpdateInfoperso(this.infopersoForm.getRawValue())).subscribe(() => {
            this.router.navigate(['../infoperso'], {relativeTo: this.activatedRoute});
        });
    }

    doPrevious() {
        this.router.navigate(['../preambule'], {relativeTo: this.activatedRoute} );
    }
}