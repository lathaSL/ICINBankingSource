import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Beneficiary } from '../models/beneficiary.model';


@Injectable({
  providedIn: 'root'
})
export class BeneficiaryService {
  url = 'http://localhost:8999/account/beneficiary';

  constructor(private http :HttpClient) { }

  addBeneficiary(beneficiary:Beneficiary){
    console.log("addbeneficiary");
    const benefparam = new HttpParams()
    .set('user_id', sessionStorage.getItem('userid'))
		.set('name' , beneficiary.benName)
    .set('accountno', beneficiary.benAcNo)
    .set('ifsc', beneficiary.benIFSCCode)
    ;
    console.log(benefparam);

    return this.http.post(this.url+'/add', benefparam);
  }
  getBeneficiaryByName(name:string) {
    return this.http.get<Beneficiary[]>(this.url+`${name}`);
  }

  getBeneficiaryList() {
    console.log(this.url)
    return this.http.get<Beneficiary[]>(this.url+'/list');
  }

  getBeneficiarybyId(id: string) {
    return this.http.get(this.url+`/${id}`);
  }

  updateBeneficiary(beneficiary:Beneficiary){
    return this.http.put(`${this.url}/${beneficiary.benId}`, beneficiary);
  }

  deleteBeneficiary(id : string){
    return this.http.delete(`${this.url}/${id}`);
  }
}
