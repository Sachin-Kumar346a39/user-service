import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NotificationService } from '../services/notification.service';

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
    private notifyService : NotificationService) { }

  ngOnInit(): void {
  }
  handleLogin(){
    this.regexp1 = new RegExp(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/);
    this.regexp2 = new RegExp('/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/');
    console.log(this.regexp1.test(this.username))
    //console.log(this.regexp2.test(this.username))
    //console.log(this.password.length !=0)
    //if(this.regexp.test(this.username) && this.password.length !=0){
    //  console.log(this.regexp1.test(this.username))
    //if(this.regexp1.test(this.username) && this.password.length !=0){
      console.log(this.username)
      if(this.regexp1.test(this.username)){
      console.log(this.regexp1.test(this.username))
      this.route.navigate(['viewloan'])
        this.isInvalidLogin=false
    }
    else{
      this.isInvalidLogin=true
      this.notifyService.showError("Invalid Credentials","Loan Management System: Login Error")
    }
  }

}
