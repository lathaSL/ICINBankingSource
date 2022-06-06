import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class Account { 

    accountId: string;
    accountNo: string;
    type: string;
    balance: string;
    chqBkReqStat: string;
    accessLevel:string

}
