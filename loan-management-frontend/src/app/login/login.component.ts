import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NotificationService } from '../services/notification.service';
import { ValidateUserService } from '../services/validate-user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username=''
  password=''
  errorMessage='Invalid Credentials'
  validMessage='valid credentials'
  isInvalidLogin=false
  regexp1
  regexp2
  constructor(private route:Router,
    private notifyService : NotificationService,
    private validateUser : ValidateUserService) { }

  ngOnInit(): void {
  }
  handleLogin(){
      console.log(this.username)
      if(this.validateUser.validate(this.username,this.password)){
      this.route.navigate(['viewloan'])
        this.isInvalidLogin=false
    }
    else{
      this.isInvalidLogin=true
      this.notifyService.showError("Invalid Credentials","Loan Management System: Login Error")
    }
  }

}
