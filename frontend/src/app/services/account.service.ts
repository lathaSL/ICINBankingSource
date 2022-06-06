import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Account } from '../models/account.module';
import { Transaction } from '../models/transacation.module';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  url = 'http://localhost:8999/account/';

  constructor(private http :HttpClient
    ) { }

  addAccount(acc:Account){

    console.log(acc)
    
    const params = new HttpParams()
    .set('user_id', '1')
		.set('accountNo' , acc.accountNo)
		.set('acctype', acc.type)
		.set('balance', acc.balance)
    .set('chqBkReqStat',acc.chqBkReqStat)
    .set('accessLevel', 'true');
    console.log(params);
    return this.http.post(this.url+'createacc', params , {responseType: 'text'});
    // return this.http.post(this.url+"1", acc);
  }


  getAccountDtls(id:string) {
    return this.http.get<Account[]>(this.url+`${id}`);
  }
  getAccountDtlsByAccNo(accno: string) {
    console.log(this.url+'search/'+`${accno}`);
    return this.http.get<Account[]>(this.url+'search/'+`${accno}`);
  }
  acctransfer(acc_id: string,amt: string, type:string,benAcNo :string){
    const accparam = new HttpParams()
    .set('acc_id', acc_id)
		.set('amount' , amt)
    .set('type', type)
    .set('benac_id', benAcNo);
    console.log(accparam);
    return this.http.post<string>(this.url+'transfer',accparam);
  }
  getTransDtls(id:string){
    console.log('ss');
    return this.http.get<Transaction[]>(this.url+'transaction/'+`${id}`);


  } 
  getPendingChqBkReq(){
    return this.http.get<Account[]>(this.url+'chqreq/');
  }

  reqChequeBook(id){
    return this.http.get<String>(this.url+'chq/'+`${id}`);

  }
  approveChqReq(id){
    return this.http.get<String>(this.url+'chqreq/'+`${id}`);

  }

  getAccountsList() {
    return this.http.get<Account[]>(this.url);
  }
  grantAccess(id){
    const accparam = new HttpParams()
    .set('acc_id', id)
    .set('access','grant');
    return this.http.post<String>(this.url+'access/',accparam);

  }

  blockAccess(id){
    const accparam = new HttpParams()
    .set('acc_id', id)
    .set('access','block');
    return this.http.post<String>(this.url+'access/',accparam);

  }

  // getFoodItembyId(id: string) {
  //   return this.http.get(this.url+`/${id}`);
  // }

  // updateFoodItem(fooditem:Fooditem){
  //   return this.http.put(`${this.url}/${fooditem._id}`, fooditem);
  // }

  // deleteFoodItem(id : string){
  //   return this.http.delete(`${this.url}/${id}`);
  // }

}
