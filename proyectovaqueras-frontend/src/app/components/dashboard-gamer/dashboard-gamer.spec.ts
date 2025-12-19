import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardGamer } from './dashboard-gamer.component';

describe('DashboardGamer', () => {
  let component: DashboardGamer;
  let fixture: ComponentFixture<DashboardGamer>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DashboardGamer]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DashboardGamer);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
