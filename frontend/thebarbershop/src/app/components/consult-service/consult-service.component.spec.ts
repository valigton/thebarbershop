import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultServiceComponent } from './consult-service.component';

describe('ConsultServiceComponent', () => {
  let component: ConsultServiceComponent;
  let fixture: ComponentFixture<ConsultServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConsultServiceComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ConsultServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
