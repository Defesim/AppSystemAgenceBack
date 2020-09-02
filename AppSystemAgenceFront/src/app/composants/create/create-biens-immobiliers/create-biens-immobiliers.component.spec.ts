import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBiensImmobiliersComponent } from './create-biens-immobiliers.component';

describe('CreateBiensImmobiliersComponent', () => {
  let component: CreateBiensImmobiliersComponent;
  let fixture: ComponentFixture<CreateBiensImmobiliersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateBiensImmobiliersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateBiensImmobiliersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
