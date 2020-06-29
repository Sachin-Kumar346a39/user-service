export class LoanInfo {
    borrowerName:string;
    addressLine1:string;
    addressLine2:  string;
    city :string;
    state: string;
    zipCode: string;
    loanAmount: string;
    loanTerm: string;
    lienID: string;
    lienType: string;
    legalDescription: string;

    constructor(){
        this.borrowerName = ''
        this.addressLine1 = ''
        this.addressLine2 = ''
        this.city  = ''
        this.state = ''
        this.zipCode = ''
        this.loanAmount = ''
        this.loanTerm = ''
        this.lienID = ''
        this.lienType = ''
        this.legalDescription = ''
    }
}
