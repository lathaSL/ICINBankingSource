import { HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { Userdtls } from 'src/app/models/userdtls.module';
import { UsersService } from 'src/app/services/users.service';


@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  userType: string='user';
  
  registerForm: FormGroup =new FormGroup({
    name : new FormControl('',Validators.required)
    
  })
  url="/home"

  get frm(){
    return this.registerForm.controls

  } 
  Users:User[]
  UserDetails: Userdtls[]
  userdtlsid: string
  constructor(
    private userservice: UsersService,
    private fb: FormBuilder,
    private router: Router,
    ){

   }

  ngOnInit(): void {

    this.registerForm = this.fb.group({
      _id: [''],
      userName: ['', Validators.required],
      password: ['', Validators.required],
      role: ['user'],
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      email: ['', Validators.required],
      phoneno: ['', Validators.required],
      address: ['', Validators.required],
      zipcode: ['', Validators.required],
      primaccno: ['', Validators.required],
      secaccno: ['', Validators.required],
         }) 
  }
registerUser(){
  console.log(this.registerForm.value);
 

    this.userservice.addUserDtls(this.registerForm.value).subscribe((response) => {
    
      if (response ){

        console.log(response);
        this.userdtlsid= response;

    //     sessionStorage.setItem('userdtlsid', response);
    //  this.url="/fooditem";
    //  console.log(this.userType);
    //  sessionStorage.setItem('username', this.userForm.get('userName').value);
    //  sessionStorage.setItem('role', this.userType);
    //  this.router.navigate([this.url]);//,{ state: { user:this.userForm.value } }

     } 
   else{
    
    console.log(response);


      alert ("Invalid credentials!!")
  }
   })

}
// addCredentials(){

//    this.userservice.addUser(this.userForm.value, this.userdtlsid).subscribe((response) => {
//     if (response ){

//       console.log(response);

//   //     sessionStorage.setItem('userdtlsid', response);
//   //  this.url="/fooditem";
//   //  console.log(this.userType);
//   //  sessionStorage.setItem('username', this.userForm.get('userName').value);
//   //  sessionStorage.setItem('role', this.userType);
//   //  this.router.navigate([this.url]);//,{ state: { user:this.userForm.value } }

//    } 
//  else{
  
//   console.log(response);


//     alert ("Invalid credentials!!")
// }
//  })
// }



}
