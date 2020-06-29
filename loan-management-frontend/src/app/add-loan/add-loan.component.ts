import { Component, OnInit, Injectable } from '@angular/core';
import { LoanInfo } from '../loan-info.model';


@Component({
  selector: 'app-add-loan',
  templateUrl: './add-loan.component.html',
  styleUrls: ['./add-loan.component.css']
})

@Injectable()
export class AddLoanComponent implements OnInit{

  loanInfoModel: LoanInfo=new LoanInfo();
  constructor(private loanInfo: LoanInfo) { }

  ngOnInit():void{}
  submitted = false;

  onSubmit() { this.submitted = true; }
  

}
