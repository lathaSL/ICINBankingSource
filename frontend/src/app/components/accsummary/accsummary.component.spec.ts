import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccsummaryComponent } from './accsummary.component';

describe('AccsummaryComponent', () => {
  let component: AccsummaryComponent;
  let fixture: ComponentFixture<AccsummaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AccsummaryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AccsummaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
