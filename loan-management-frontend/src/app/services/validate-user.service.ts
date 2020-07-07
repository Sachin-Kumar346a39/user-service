import { UserInfo } from './../user-info.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ValidateUserService {

  USER_URL: string = 'http://localhost:9090/api/v1/user/validateUser';

  constructor(private httpClient: HttpClient, private userInfo: UserInfo) { }

  validate(userInfo): Observable<any> {

    return this.httpClient.post(this.USER_URL, userInfo);
  }

  isUserLoggedIn() {
    var user: any = sessionStorage.getItem('validUser')
    return !(user === null)
  }

  logout() {
    sessionStorage.removeItem('validUser')
  }

}
