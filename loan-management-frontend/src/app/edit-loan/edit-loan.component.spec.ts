import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditLoanComponent } from './edit-loan.component';
import { RouterTestingModule } from '@angular/router/testing';
import { ToastrModule } from 'ngx-toastr';
import { LoanInfo } from '../loan-info.model';

import { FormsModule } from '@angular/forms';

describe('EditLoanComponent', () => {
  let component: EditLoanComponent;
  let fixture: ComponentFixture<EditLoanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditLoanComponent],
      providers: [LoanInfo],
      imports: [
        RouterTestingModule.withRoutes([]),
        ToastrModule.forRoot(),
        FormsModule  
      ],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditLoanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
