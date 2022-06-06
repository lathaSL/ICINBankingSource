import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChqbkreqComponent } from './chqbkreq.component';

describe('ChqbkreqComponent', () => {
  let component: ChqbkreqComponent;
  let fixture: ComponentFixture<ChqbkreqComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChqbkreqComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChqbkreqComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
