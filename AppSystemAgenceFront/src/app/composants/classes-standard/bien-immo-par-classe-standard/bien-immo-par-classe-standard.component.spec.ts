import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BienImmoParClasseStandardComponent } from './bien-immo-par-classe-standard.component';

describe('BienImmoParClasseStandardComponent', () => {
  let component: BienImmoParClasseStandardComponent;
  let fixture: ComponentFixture<BienImmoParClasseStandardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BienImmoParClasseStandardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BienImmoParClasseStandardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
