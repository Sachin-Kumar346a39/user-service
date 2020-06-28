import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ValidateUserService {
  regexp = new RegExp(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)
  constructor() { }

  validate(username,password){
    if(this.regexp.test(username) && password!=''){
      sessionStorage.setItem('validUser',username)
      return true
    } 
    return false;
  }

  isUserLoggedIn(){
    var user:any=sessionStorage.getItem('validUser')
    return !(user===null)
  }

  logout(){
    sessionStorage.removeItem('validUser')
  }
}
