import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccdepositwithdrawlComponent } from './components/accdepositwithdrawl/accdepositwithdrawl.component';
import { AccountComponent } from './components/account/account.component';
import { AccsummaryComponent } from './components/accsummary/accsummary.component';
import { AdminhomeComponent } from './components/adminhome/adminhome.component';
import { BenefmaintainComponent } from './components/benefmaintain/benefmaintain.component';
import { ChangepwdComponent } from './components/changepwd/changepwd.component';
import { ChqbkreqComponent } from './components/chqbkreq/chqbkreq.component';

import { HomeComponent } from './components/home/home.component';
import { TransactionComponent } from './components/transaction/transaction.component';
import { TransferComponent } from './components/transfer/transfer.component';
import { UserhomeComponent } from './components/userhome/userhome.component';
import { UsermgmtComponent } from './components/usermgmt/usermgmt.component';
import { UsersComponent } from './components/users/users.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'user', component:UsersComponent},
  {path: 'account', component:AccountComponent},
  {path: 'transaction', component:TransactionComponent},
  
  {path:'userhome',component:UserhomeComponent},

  {path:'admin',component:AdminhomeComponent},
  {path: 'chgpwd' , component:ChangepwdComponent},
  {path: 'accsummary' , component:AccsummaryComponent},
  {path: 'accdep' , component:AccdepositwithdrawlComponent},
  {path: 'benef', component:BenefmaintainComponent},
  {path: 'trans', component:TransferComponent},
  {path: 'appchqreq', component:ChqbkreqComponent},
  {path: 'usrmgmt', component:UsermgmtComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
