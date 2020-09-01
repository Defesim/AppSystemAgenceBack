import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientsProprioComponent } from './clients-proprio.component';

describe('ClientsProprioComponent', () => {
  let component: ClientsProprioComponent;
  let fixture: ComponentFixture<ClientsProprioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientsProprioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientsProprioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
