import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePromoterComponent } from './create-promoter.component';

describe('CreatePromoterComponent', () => {
  let component: CreatePromoterComponent;
  let fixture: ComponentFixture<CreatePromoterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatePromoterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreatePromoterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
