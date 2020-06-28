import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ValidateUserService {
  regexp1 = new RegExp(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/)
  constructor() { }

  validate(username,password){
    if(this.regexp1.test(username) && password!=''){
      return true
    } 
    return false;
  }
}
