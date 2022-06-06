import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Account } from './account.module';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class Transaction { 
    transId: number;
    account: Account;
    type: string;
    transDate: Date
    fromAC: string;
    toAC: string;
    details: string;
    amount: string;
    balance: string;


    
}
``