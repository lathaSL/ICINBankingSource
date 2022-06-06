import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BenefmaintainComponent } from './benefmaintain.component';

describe('BenefmaintainComponent', () => {
  let component: BenefmaintainComponent;
  let fixture: ComponentFixture<BenefmaintainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BenefmaintainComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BenefmaintainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
