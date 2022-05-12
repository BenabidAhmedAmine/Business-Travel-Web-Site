import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SendinviComponent } from './sendinvi.component';

describe('SendinviComponent', () => {
  let component: SendinviComponent;
  let fixture: ComponentFixture<SendinviComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SendinviComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SendinviComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
