import { Component, OnInit } from '@angular/core';
import { LoanInfo } from '../loan-info.model';
import { NotificationService } from '../services/notification.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-edit-loan',
  templateUrl: './edit-loan.component.html',
  styleUrls: ['./edit-loan.component.css']
})
export class EditLoanComponent implements OnInit {

  loanInfoModel: LoanInfo=new LoanInfo();
  updatedLoanInfo: LoanInfo;
  constructor(private loanInfo: LoanInfo,  private notifyService : NotificationService, private _location: Location) { }

  ngOnInit():void{}

  updateLoan() {
    if(confirm("Are you sure to Update Loan? ")) {
    //message needs to be updated
      this.notifyService.showSuccess("Loan Updated Successfully for Loan#: "+this.loanInfoModel.loanNumber,"");
      this.updatedLoanInfo=this.loanInfoModel;
      this.loanInfoModel = new LoanInfo();
    }
  }

  doCancel() {
    this._location.back();
  }
}

