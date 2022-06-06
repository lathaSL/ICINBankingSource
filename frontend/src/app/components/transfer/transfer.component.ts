import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Account } from 'src/app/models/account.module';
import { Beneficiary } from 'src/app/models/beneficiary.model';
import { AccountService } from 'src/app/services/account.service';
import { BeneficiaryService } from 'src/app/services/beneficiary.service';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.css']
})
export class TransferComponent implements OnInit {
  Accounts: Account[]
  Beneficiaries: Beneficiary[]

  addForm: FormGroup =new FormGroup({
    accountNo : new FormControl('',Validators.required),
    benAcNo:new FormControl('',Validators.required),
    amount: new FormControl('',Validators.required),
  })
  // get frm(){
  //   return this.searchForm.controls
  // } 
get addfrm(){
    return this.addForm.controls
  } 

  constructor(private accountservice: AccountService,
    private beneficiaryservice: BeneficiaryService,
    private fb: FormBuilder,) { }

  ngOnInit(): void {

    this.accountservice.getAccountDtls(sessionStorage.getItem('userid')).subscribe(
      (response) => {
        console.log(response);
        this.Accounts=response;
 
      },
      (err) => { console.log(err) }
    )

    this.beneficiaryservice.getBeneficiaryList().subscribe((response: Beneficiary[]) => {
      console.log(response);
      this.Beneficiaries = response
    })
  }
submit(){

  this.accountservice.acctransfer(this.addForm.get('accountNo').value,
  this.addForm.get('amount').value,'transfer',this.addForm.get('benAcNo').value).subscribe((response)=>{
    alert('Transferred');
   },
  (err) => { console.log(err) }


  )
}    
}

