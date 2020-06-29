import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-loan',
  templateUrl: './view-loan.component.html',
  styleUrls: ['./view-loan.component.css']
})
export class ViewLoanComponent implements OnInit {

     borrowerFullName=""
     dbBorrowerFullName
     loanNumber=""
     dbLoanNumber
     loanAmount=""
     dbLoanAmount
     flag=false
     found=false
     notfound=false
     deleted=false

     loanDetails: any[] = [
      {
        "borrowerFullName": "Ashwin Kamath",
        "loanNumber": "123",
      "loanAmount": "123"
      },
      {
        "borrowerFullName": "Sachin Kumar",
        "loanNumber": "456",
      "loanAmount": "456"
      },
      {
        "borrowerFullName": "Anjana Shenoy",
        "loanNumber": "789",
      "loanAmount": "789"
      }
    ];
  constructor() { }

  ngOnInit(): void {
    
  }

   searchLoan():void{

    //logig to Search Loan
    this.clearForm();
    if(this.borrowerFullName.toLowerCase().includes("ashwin")||this.loanNumber.includes("1234")||this.loanAmount.includes("678"))
    {
      this.flag=true
      this.found=true
      this.dbBorrowerFullName="Ashwin Kamath"
      this.dbLoanNumber="12345"
      this.dbLoanAmount="67890"
      
      this.notfound=false
    }
    else{
      this.notfound=true
    }

  }


  deleteLoan(): void{

//add logic to deleteLoan
      this.flag=false
      this.deleted=true
      
  }

  clearForm(): void{
    this.flag=false
    this.deleted=false
    this.notfound=false
  }

}
