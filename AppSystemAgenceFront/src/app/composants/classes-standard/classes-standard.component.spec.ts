import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassesStandardComponent } from './classes-standard.component';

describe('ClassesStandardComponent', () => {
  let component: ClassesStandardComponent;
  let fixture: ComponentFixture<ClassesStandardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClassesStandardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClassesStandardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
