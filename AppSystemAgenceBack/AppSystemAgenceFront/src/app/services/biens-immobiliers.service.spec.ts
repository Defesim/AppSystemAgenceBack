import { TestBed } from '@angular/core/testing';

import { BiensImmobiliersService } from './biens-immobiliers.service';

describe('BiensImmobiliersService', () => {
  let service: BiensImmobiliersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BiensImmobiliersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
