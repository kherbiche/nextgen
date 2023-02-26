import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListPromoterComponent } from './list-promoter.component';

describe('ListPromoterComponent', () => {
  let component: ListPromoterComponent;
  let fixture: ComponentFixture<ListPromoterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListPromoterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListPromoterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
