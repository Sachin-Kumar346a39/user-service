import { Component, OnInit } from '@angular/core';
import { LoanInfo } from '../loan-info.model';
import { NotificationService } from '../services/notification.service';
import {Location} from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-loan',
  templateUrl: './add-loan.component.html',
  styleUrls: ['./add-loan.component.css']
})

//@Injectable()
export class AddLoanComponent implements OnInit{

  loanInfoModel: LoanInfo=new LoanInfo();

  constructor(private loanInfo: LoanInfo,  private notifyService : NotificationService, private _location: Location,private router:Router) { }

  ngOnInit():void{}

  addLoan() {
    if(confirm("Are you sure to Add Loan? ")) {
      this.notifyService.showSuccess("Loan Added Successfully for Loan#: "+this.loanInfoModel.loanNumber,"");
      this.loanInfoModel = new LoanInfo();
    }
  }

  doCancel() {
    this.router.navigate(['viewloan'])
  }
}
