import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ViewLoanComponent } from './view-loan/view-loan.component';
import { ErrorComponent } from './error/error.component';


const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'viewloan',component:ViewLoanComponent},
  {path:'**',component:ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
