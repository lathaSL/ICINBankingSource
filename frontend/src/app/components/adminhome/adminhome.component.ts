import { Component, OnInit } from '@angular/core';
import { HostListener } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {
 
admin: boolean;
user: boolean;
  constructor(private router: Router,) {
  }

  ngOnInit(): void {
    this.admin=true;
    this.user=false;
    console.log(sessionStorage.getItem("userType"));

    if (sessionStorage.getItem("userType") !='admin'){
      this.admin=false;
      sessionStorage.setItem('loginType', 'adminlogin');

    
  }

  if (sessionStorage.getItem("userType") =='admin'){
    console.log(sessionStorage.getItem("userType"));
    this.admin=true;
  
}


    
    // sessionStorage.removeItem("username");
    // this.router.navigate(["/home"]);//,{ state: { user:this.userForm.value } }

    // console.log (sessionStorage.getItem("username"));

    
  }
  // @HostListener('window:unload', ['$event'])
  //   unloadHandler(event) {
  //       window.sessionStorage.clear();
  //   }
}
