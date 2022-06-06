import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user.model';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-changepwd',
  templateUrl: './changepwd.component.html',
  styleUrls: ['./changepwd.component.css']
})
export class ChangepwdComponent implements OnInit {
  userName;
  chgPwdForm: FormGroup =new FormGroup({
    name : new FormControl('',Validators.required),
    password:new FormControl('',Validators.required),
    // newpassword1: new FormControl('',Validators.required),
    // newpassword2: new FormControl('',Validators.required)
  })

  Users:User[]

  get frm(){
    return this.chgPwdForm.controls
  } 
  constructor(private userservice: UsersService,   private fb: FormBuilder,
    private router: Router,) {
    this.userName=sessionStorage.getItem('username');
    // this.router.getCurrentNavigation().extras.state['user'].name; 
    
  }

  ngOnInit(): void {
    
    this.chgPwdForm = this.fb.group({
      _id: [''],
      name: [this.userName, Validators.required],
      password: ['', Validators.required],
      role:[sessionStorage.getItem('role')],
      newpassword1: ['', Validators.required],
      newpassword2: ['', Validators.required],

    })
    
  }
  changePassword(){ 
    console.log(this.chgPwdForm.value);
    console.log(this.userName);
    this.userservice.getUserIdbyNameAndPwd(this.chgPwdForm.get('name').value, 
              this.chgPwdForm.get('password').value,
              sessionStorage.getItem('role')).subscribe((response) => {
          if (response ){
            this.userservice.updateUser(response,this.chgPwdForm.get('newpassword1').value).subscribe((updresponse) => {
              if (updresponse){
                alert (updresponse);
                // this.showChgPwd=false;
              } 
            else{

                alert ("Error occurred");
            }
            })
          
          }
          else{
            console.log(response);
            alert ("Check entered credentials!!")
        }

        }
    )
  }

}
