import { Component, OnInit } from '@angular/core';
import { ValidateUserService } from '../services/validate-user.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private validateUserService : ValidateUserService) { }

  ngOnInit(){
    this.validateUserService.logout();
  }

}
