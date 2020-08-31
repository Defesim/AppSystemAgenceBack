import { TestBed } from '@angular/core/testing';

import { ModeOffreService } from './mode-offre.service';

describe('ModeOffreService', () => {
  let service: ModeOffreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModeOffreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
