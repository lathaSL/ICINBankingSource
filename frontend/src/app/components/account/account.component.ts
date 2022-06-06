import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  constructor(    private accountservice: AccountService,
                private fb: FormBuilder,
                
    ) { }
    
  addForm: FormGroup =new FormGroup({
    name : new FormControl('',Validators.required),
    })
   
get addfrm(){
    return this.addForm.controls
  } 

  ngOnInit(): void {
    
    this.addForm = this.fb.group({
      _id: ['1'],
      accountNo: ['', Validators.required],
      balance: ['', Validators.required],
      userid: ['1', Validators.required],
      type: ['', Validators.required],
      chqBkReqStat: ['false', Validators.required],
      accessLevel: ['true', Validators.required],

    })
  }
  submit(){


    console.log(this.addForm.value);

    this.accountservice.addAccount(this.addForm.value).subscribe(
     (response) => {
       console.log(response);

     },
     (err) => { console.log(err) }
   )
   }
}
