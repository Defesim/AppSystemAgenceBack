import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAdresseComponent } from './create-adresse.component';

describe('CreateAdresseComponent', () => {
  let component: CreateAdresseComponent;
  let fixture: ComponentFixture<CreateAdresseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateAdresseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateAdresseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
