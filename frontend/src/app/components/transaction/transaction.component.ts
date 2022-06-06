import { Component, OnInit } from '@angular/core';
import { Transaction } from 'src/app/models/transacation.module';
import { AccountService } from 'src/app/services/account.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {
  transactions: Transaction[];
  
  public id: string;

  constructor(private route: ActivatedRoute,
    private accountservice: AccountService) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.id = params['id'];
      console.log(this.id);});
this.getTransDetails(this.id);

  
}
 
getTransDetails(id: string){
  console.log(id);
  
  this.accountservice.getTransDtls(this.id).subscribe(
    (response: Transaction[]) => {
      console.log(response);
      this.transactions=response

    },
    (err) => { console.log(err) }
  )
}  
}

