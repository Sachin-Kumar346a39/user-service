import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import{FormsModule} from '@angular/forms';
import { ViewLoanComponent } from './view-loan/view-loan.component';
import { MenuComponent } from './menu/menu.component';
import { ErrorComponent } from './error/error.component';
import { FooterComponent } from './footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { LogoutComponent } from './logout/logout.component';
import { AddLoanComponent } from './add-loan/add-loan.component';
import { LoanInfo } from './loan-info.model';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ViewLoanComponent,
    MenuComponent,
    ErrorComponent,
    FooterComponent,
    LogoutComponent,
    AddLoanComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot()
  ],
  providers: [LoanInfo],
  bootstrap: [AppComponent]
})
export class AppModule { }
