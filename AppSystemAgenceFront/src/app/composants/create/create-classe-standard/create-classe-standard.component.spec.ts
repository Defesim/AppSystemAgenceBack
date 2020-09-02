import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateClasseStandardComponent } from './create-classe-standard.component';

describe('CreateClasseStandardComponent', () => {
  let component: CreateClasseStandardComponent;
  let fixture: ComponentFixture<CreateClasseStandardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateClasseStandardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateClasseStandardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
