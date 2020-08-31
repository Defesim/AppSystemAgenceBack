import { TestBed } from '@angular/core/testing';

import { AchatSaufTerrainService } from './achat-sauf-terrain.service';

describe('AchatSaufTerrainService', () => {
  let service: AchatSaufTerrainService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AchatSaufTerrainService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
