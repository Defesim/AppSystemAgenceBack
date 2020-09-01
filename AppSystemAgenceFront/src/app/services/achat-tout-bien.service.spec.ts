import { TestBed } from '@angular/core/testing';

import { AchatToutBienService } from './achat-tout-bien.service';

describe('AchatToutBienService', () => {
  let service: AchatToutBienService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AchatToutBienService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
