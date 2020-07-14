import { HttpClient } from '@angular/common/http';
import { LoanInfo } from './../loan-info.model';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ViewLoanService {
  SEARCH_LOAN_URL: string = 'http://localhost:9092/api/v1/loan/searchLoan';
  constructor(private httpClient: HttpClient, loanInfo: LoanInfo) { }

  searchLoan(data: any): Observable<any> {

    return this.httpClient.post(this.SEARCH_LOAN_URL, data)
  }
}
