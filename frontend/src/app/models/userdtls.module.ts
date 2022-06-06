import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class Userdtls {
  _id : string;
  userName: string;
  password: string;
  role:string;
  firstname: string;
  lastname: string;
  email: string;
  phoneno: string;
  address: string;
  zipcode:string;
  primaccno: string;
  secaccno: string;
}
