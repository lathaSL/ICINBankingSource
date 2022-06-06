import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  userType: string='user';
  userForm: FormGroup =new FormGroup({
    name : new FormControl('',Validators.required)
    
  })
  url="/home"

  get frm(){
    return this.userForm.controls
  } 
  Users:User[]
  constructor(
    private userservice: UsersService,
    private fb: FormBuilder,
    private router: Router,
    ){

   }

  ngOnInit(): void {
    this.userForm = this.fb.group({
      _id: [''],
      userName: ['', Validators.required],
      password: ['', Validators.required],
      role: ['']
    })

   
  }
login(){
  console.log(this.userForm.value);
  if (sessionStorage.getItem('loginType')=='adminlogin'){
    this.userType='admin';
  }
  if (sessionStorage.getItem('loginType')=='userlogin'){
    this.userType='user';
  }
  console.log(sessionStorage.getItem('loginType'));



    this.userservice.getUserIdbyNameAndPwd(this.userForm.get('userName').value, this.userForm.get('password').value,this.userType).subscribe((response) => {
    
      if (response ){
        sessionStorage.setItem('userid', response);
     console.log(this.userType);
     sessionStorage.setItem('username', this.userForm.get('userName').value);
     sessionStorage.setItem('userType', this.userType);
     console.log(sessionStorage.getItem("userType"));

     if (this.userType=='admin'){
      this.router.navigate(['/admin']);
     }
     else{
      this.router.navigate(['/userhome']);
     }
     location.reload();//,{ state: { user:this.userForm.value } }

     } 
   else{
    
    console.log(response);

      alert ("Invalid credentials!!")
  }
   })

}


}


 