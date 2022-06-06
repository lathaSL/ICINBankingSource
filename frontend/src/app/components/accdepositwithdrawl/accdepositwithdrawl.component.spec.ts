import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AccdepositwithdrawlComponent } from './accdepositwithdrawl.component';

describe('AccdepositwithdrawlComponent', () => {
  let component: AccdepositwithdrawlComponent;
  let fixture: ComponentFixture<AccdepositwithdrawlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AccdepositwithdrawlComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AccdepositwithdrawlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
