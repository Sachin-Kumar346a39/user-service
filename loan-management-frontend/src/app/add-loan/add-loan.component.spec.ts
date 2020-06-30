import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLoanComponent } from './add-loan.component';
import { RouterTestingModule } from '@angular/router/testing';
import { ToastrModule } from 'ngx-toastr';
import { LoanInfo } from '../loan-info.model';

import { FormsModule } from '@angular/forms';

describe('AddLoanComponent', () => {
  let component: AddLoanComponent;
  let fixture: ComponentFixture<AddLoanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddLoanComponent],
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
    fixture = TestBed.createComponent(AddLoanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
