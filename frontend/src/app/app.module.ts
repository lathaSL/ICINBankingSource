import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsersComponent } from './components/users/users.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { AdminhomeComponent } from './components/adminhome/adminhome.component';
import { ChangepwdComponent } from './components/changepwd/changepwd.component';
import { TransactionComponent } from './components/transaction/transaction.component';
import { AccountComponent } from './components/account/account.component';
import { UserhomeComponent } from './components/userhome/userhome.component';
import { RouterModule, Routes } from '@angular/router';
import { AccsummaryComponent } from './components/accsummary/accsummary.component';
import { AccdepositwithdrawlComponent } from './components/accdepositwithdrawl/accdepositwithdrawl.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BenefmaintainComponent } from './components/benefmaintain/benefmaintain.component';
import { TransferComponent } from './components/transfer/transfer.component';
import { ChqbkreqComponent } from './components/chqbkreq/chqbkreq.component';
import { UsermgmtComponent } from './components/usermgmt/usermgmt.component';
export const routes: Routes = [];

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    HeaderComponent,
    HomeComponent,
    AdminhomeComponent,
    ChangepwdComponent,
    AccountComponent,
    TransactionComponent,
    UserhomeComponent,
    AccsummaryComponent,
    AccdepositwithdrawlComponent,
    BenefmaintainComponent,
    TransferComponent,
    ChqbkreqComponent,
    UsermgmtComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes,{
      anchorScrolling: 'enabled'
    }),
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent,UsersComponent]
})
export class AppModule { }
