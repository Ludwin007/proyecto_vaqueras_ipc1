import { TestBed } from '@angular/core/testing';

import { Gamer } from './gamer.service';

describe('Gamer', () => {
  let service: Gamer;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Gamer);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
