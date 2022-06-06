import { Component, OnInit } from '@angular/core';
import { Account } from 'src/app/models/account.module';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-chqbkreq',
  templateUrl: './chqbkreq.component.html',
  styleUrls: ['./chqbkreq.component.css']
})
export class ChqbkreqComponent implements OnInit {
accounts: Account[];
  constructor(private accountservice: AccountService,
    ) { }

  ngOnInit(): void {
    this.accountservice.getPendingChqBkReq().subscribe(
      (response) => {
        console.log(response);
        this.accounts=response;
 
      },
      (err) => { console.log(err) }
    )

  }
approve(id:string){
  this.accountservice.approveChqReq(id).subscribe(
    (response) => {
      console.log(response);

    },
    (err) => { console.log(err) }
  )
}
}
