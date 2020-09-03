import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BienImmobilierDetailsComponent } from './bien-immobilier-details.component';

describe('BienImmobilierDetailsComponent', () => {
  let component: BienImmobilierDetailsComponent;
  let fixture: ComponentFixture<BienImmobilierDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BienImmobilierDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BienImmobilierDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
