import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestedManufacturerComponent } from './requested-manufacturer.component';

describe('RequestedManufacturerComponent', () => {
  let component: RequestedManufacturerComponent;
  let fixture: ComponentFixture<RequestedManufacturerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestedManufacturerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestedManufacturerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
