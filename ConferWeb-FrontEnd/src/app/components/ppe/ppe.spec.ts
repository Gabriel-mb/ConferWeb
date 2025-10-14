import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ppe } from './ppe';

describe('Ppe', () => {
  let component: Ppe;
  let fixture: ComponentFixture<Ppe>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ppe]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ppe);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
