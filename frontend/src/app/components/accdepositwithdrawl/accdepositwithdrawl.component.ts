import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Account } from 'src/app/models/account.module';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-accdepositwithdrawl',
  templateUrl: './accdepositwithdrawl.component.html',
  styleUrls: ['./accdepositwithdrawl.component.css']
})

export class AccdepositwithdrawlComponent implements OnInit {
  Accounts: Account[]
  ctrlName: String
  addForm: FormGroup =new FormGroup({
    amount : new FormControl('',Validators.required),
  })
  constructor( private accountservice: AccountService,
    private fb: FormBuilder,) {}  
    

  ngOnInit(): void {
    this.addForm = this.fb.group({
      _id: [''],
      amount1: ['', Validators.required],
      amount2: ['', Validators.required],
      
    })
    this.getAccountDtls() ;
  }
  getAccountDtls(){
    {

      this.accountservice.getAccountDtls(sessionStorage.getItem('userid')).subscribe(
        (response) => {
          console.log(response);
          this.Accounts=response;
   
        },
        (err) => { console.log(err) }
      )

    }
  }
  deposit(id, seq) {

    if (confirm('Do you want to deposit amount?')) {
      this.ctrlName='amount1';
      if (seq==2){
        this.ctrlName='amount2';
      }

      alert(this.addForm.get(this.ctrlName.toString()).value);
        this.accountservice.acctransfer(id,this.addForm.get(this.ctrlName.toString()).value,'deposit','').subscribe((response)=>{
            alert('Deposited');
           },
          (err) => { console.log(err) }
        

          )
    }    
  }

  withdrawl(id, seq) {
    if (confirm('Do you want to Withdraw?')) {
      this.ctrlName='amount1';
      if (seq==2){
        this.ctrlName='amount2';
      }
      alert(this.addForm.get(this.ctrlName.toString()).value);

        this.accountservice.acctransfer(id,this.addForm.get(this.ctrlName.toString()).value,'withdraw','').subscribe((response)=>{
            alert('Withdrawn');
           },
          (err) => { console.log(err) }
        

          )
    }    
  }

}
