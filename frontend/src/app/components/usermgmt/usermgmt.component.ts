import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Account } from 'src/app/models/account.module';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-usermgmt',
  templateUrl: './usermgmt.component.html',
  styleUrls: ['./usermgmt.component.css']
})
export class UsermgmtComponent implements OnInit {
  accounts: Account[];
  constructor(private accountservice : AccountService) { }
  searchForm: FormGroup =new FormGroup({
    name : new FormControl('',Validators.required)
  })
  listForm: FormGroup =new FormGroup({
    id : new FormControl('',Validators.required)
  })
  addForm: FormGroup =new FormGroup({
    name : new FormControl('',Validators.required),
    price:new FormControl('',Validators.required),
    category: new FormControl('',Validators.required),
  })
  get frm(){
    return this.searchForm.controls
  } 
get addfrm(){
    return this.addForm.controls
  } 
  ngOnInit(): void {
    this.getAccountsList() 
    
  }
  getAccountsList() {
    this.accountservice.getAccountsList().subscribe((response: Account[]) => {
      console.log(response);
      this.accounts = response
    })
  }

  ListAccounts(){
    
    this.accountservice.getAccountDtlsByAccNo(this.searchForm.get('name').value).subscribe((response: Account[]) => {
      console.log(response);
      this.accounts = response
    },
    (err) => { console.log(err) }
    )
  }
  onGrantAccess(id:string){
    this.accountservice.grantAccess(id).subscribe((response) => {
      console.log(response);
      this.getAccountsList() 
    })
  }
  onBlockAccess(id:string){
    this.accountservice.blockAccess(id).subscribe((response) => {
      console.log(response);
      this.getAccountsList() 
    })
  }

  }

