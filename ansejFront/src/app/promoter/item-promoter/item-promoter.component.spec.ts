import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemPromoterComponent } from './item-promoter.component';

describe('ItemPromoterComponent', () => {
  let component: ItemPromoterComponent;
  let fixture: ComponentFixture<ItemPromoterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItemPromoterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ItemPromoterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
