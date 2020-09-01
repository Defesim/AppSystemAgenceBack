import { TestBed } from '@angular/core/testing';

import { VisitesServiceService } from './visites-service.service';

describe('VisitesServiceService', () => {
  let service: VisitesServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VisitesServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
