import { Component, OnInit } from '@angular/core';
import { LoanInfo } from '../loan-info.model';
import { NotificationService } from '../services/notification.service';

@Component({
  selector: 'app-edit-loan',
  templateUrl: './edit-loan.component.html',
  styleUrls: ['./edit-loan.component.css']
})
export class EditLoanComponent implements OnInit {

  loanInfoModel: LoanInfo=new LoanInfo();
updatedLoanInfo: LoanInfo;
  constructor(private loanInfo: LoanInfo,  private notifyService : NotificationService) { }

  ngOnInit():void{}

  addLoan() {
    if(confirm("Are you sure to Update Loan? ")) {
    //message needs to be updated
      this.notifyService.showSuccess("Loan Updated Successfully for: "+this.loanInfoModel.addressLine1,"");
      this.updatedLoanInfo=this.loanInfoModel;
      this.loanInfoModel = new LoanInfo();
    }
  }
}

