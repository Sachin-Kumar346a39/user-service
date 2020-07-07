import { HttpClient } from '@angular/common/http';
import { LoanInfo } from './../loan-info.model';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddLoanService {

  ADD_LOAN_URL: string = 'http://localhost:9092/api/v1/loan/addLoan';
  constructor(private httpClient: HttpClient, loanInfo: LoanInfo) { }

  addLoan(data: any): Observable<any> {

    return this.httpClient.post(this.ADD_LOAN_URL, data)
  }

}
