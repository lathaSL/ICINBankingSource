import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit {
  accountservice : AccountService;
  user: boolean;
  admin:boolean;

  constructor() { }

  ngOnInit(): void {

    this.admin=false;
    this.user=true;
    console.log(sessionStorage.getItem("userType"));

    if (sessionStorage.getItem("userType") !='user'){
      this.user=false;
      sessionStorage.setItem('loginType', 'userlogin');

    
  }

  if (sessionStorage.getItem("userType") =='user'){
    console.log(sessionStorage.getItem("userType"));
    this.user=true;
  
}

  }
reqChqBk(){
  if (confirm('Do you want to request Cheque Book?')) {
    this.accountservice.reqChequeBook(sessionStorage.getItem('user_id')).subscribe((response)=>{
        
        alert('Cheque Book request submitted.');
       },
      (err) => { console.log(err) }
    

      )
}    
}

}
