import {Component, ElementRef} from "@angular/core";
import {NgHttpLoaderComponent} from "ng-http-loader";
import {RouterOutlet} from "@angular/router";
import {VnSpinnerComponent} from "./_coreModule/components/vn-spinner/vn-spinner.component";
import {InitializationService} from "./_coreModule/services/initialization.service";

@Component({
  selector: 'main-module',
  imports: [
    NgHttpLoaderComponent,
    RouterOutlet
  ],
  template: `
    <router-outlet></router-outlet>
    <ng-http-loader [entryComponent]='vnSpinnerComponent'></ng-http-loader>`

})
export class MainComponent {
  public vnSpinnerComponent =VnSpinnerComponent;

  constructor(elm: ElementRef, initializationService: InitializationService) {
    const codeInter = elm.nativeElement.getAttribute('codeInter');
    const prsId = elm.nativeElement.getAttribute('prsId');

    initializationService.initializationSubject.next({
      codeInter: codeInter,
      prsId: prsId
    });
  }
}
