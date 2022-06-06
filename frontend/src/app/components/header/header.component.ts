import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  admin:boolean;
  user:boolean;

  constructor() { 
  
  }

  ngOnInit(): void {
    this.admin=false;
    this.user=false;
    // sessionStorage.setItem('userType','user');
    if (sessionStorage.getItem("userType") == 'user'){
      this.user=true;
    }
    if (sessionStorage.getItem("userType") == 'admin'){
      this.admin=true;
    } 
  }
logout(){
  this.admin=false;
  this.user=false;
  sessionStorage.setItem("userType",'');
  sessionStorage.setItem('username', '');
  sessionStorage.setItem('userid', '');
  location.reload();

}
}
