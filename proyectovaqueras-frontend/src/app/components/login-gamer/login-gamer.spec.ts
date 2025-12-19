import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginGamer } from './login-gamer.component';

describe('LoginGamer', () => {
  let component: LoginGamer;
  let fixture: ComponentFixture<LoginGamer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LoginGamer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LoginGamer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
