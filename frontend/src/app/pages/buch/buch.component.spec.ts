import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BuchComponent } from './buch.component';

describe('BuchComponent', () => {
  let component: BuchComponent;
  let fixture: ComponentFixture<BuchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BuchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BuchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
