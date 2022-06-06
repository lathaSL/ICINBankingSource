import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Account } from 'src/app/models/account.module';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-accsummary',
  templateUrl: './accsummary.component.html',
  styleUrls: ['./accsummary.component.css']
})
export class AccsummaryComponent implements OnInit {
  Accounts: Account[]

  constructor(    private accountservice: AccountService,
    private fb: FormBuilder,){};

  ngOnInit(): void {
    console.log(sessionStorage.getItem('userid'));
    this.accountservice.getAccountDtls(sessionStorage.getItem('userid')).subscribe(
      (response) => {
        console.log(response);
        this.Accounts=response;
 
      },
      (err) => { console.log(err) }
    )

  }

  

}
