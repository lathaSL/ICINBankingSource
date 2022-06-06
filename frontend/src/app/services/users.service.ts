import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { Userdtls } from '../models/userdtls.module';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  url = 'http://localhost:8999/user';

  constructor(private http :HttpClient) { }

  addUser(user:User, userdtlsid:string){

    const params = new HttpParams()
    .set('username', user.userName)
		.set('password' , user.password)
		.set('role', 'user')
		.set('userdtlsid', userdtlsid);

    return this.http.post(this.url+`/addcredential`, params, {responseType: 'text'});

  }

  addUserDtls(userDtls:Userdtls){

    
    const params = new HttpParams()
    .set('firstname', userDtls.firstname)
		.set('lastname' , userDtls.lastname)
		.set('email', userDtls.email)
		.set('phoneno', userDtls.phoneno)
		.set('zipcode', userDtls.zipcode)
		// .set('user', '')
		.set('primaccno',  userDtls.primaccno)
    .set('secaccno',userDtls.secaccno)
		.set('address', userDtls.address)
    .set('username', userDtls.userName)
    .set('password', userDtls.password)
    .set('role', userDtls.role);
    return this.http.post(this.url+"/register", params,  {responseType: 'text'});
  }
  getUserList() {
    return this.http.get<User[]>(this.url);
  }

  
  getUserbyId(id: string) {
    return this.http.get(this.url+`/${id}`);
  }
  getUserIdbyNameAndPwd(user: string, pwd: string, role: string) {
    const params = new HttpParams()
    .set('userName', user)
    .set('password', pwd)
    .set('role', role);

    return this.http.get(this.url+`/login`+`?${params}`, {responseType: 'text'});
  }

  updateUser(id: string, newpwd: string){
    const params = new HttpParams()
    .set('id', id)
    .set('newpassword', newpwd);
    return this.http.post(this.url+'/upd', params , {responseType: 'text'});
  }

  deleteUser(id : string){
    return this.http.delete(`${this.url}/${id}`);
  }
}
