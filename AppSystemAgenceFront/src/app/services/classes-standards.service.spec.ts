import { TestBed } from '@angular/core/testing';

import { ClassesStandardsService } from './classes-standards.service';

describe('ClassesStandardsService', () => {
  let service: ClassesStandardsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClassesStandardsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
