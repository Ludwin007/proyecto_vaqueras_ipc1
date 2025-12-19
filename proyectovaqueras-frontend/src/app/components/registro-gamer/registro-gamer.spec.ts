import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistroGamer } from './registro-gamer';

describe('RegistroGamer', () => {
  let component: RegistroGamer;
  let fixture: ComponentFixture<RegistroGamer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistroGamer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistroGamer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
