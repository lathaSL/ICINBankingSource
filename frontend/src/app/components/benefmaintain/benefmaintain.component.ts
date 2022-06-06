import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Beneficiary } from 'src/app/models/beneficiary.model';
import { BeneficiaryService } from 'src/app/services/beneficiary.service';

@Component({
  selector: 'app-benefmaintain',
  templateUrl: './benefmaintain.component.html',
  styleUrls: ['./benefmaintain.component.css']
})
export class BenefmaintainComponent implements OnInit {
  addmode:boolean;
  displayList:boolean;
  listForm: FormGroup =new FormGroup({
    id : new FormControl('',Validators.required)
  })
  addForm: FormGroup =new FormGroup({
    benName : new FormControl('',Validators.required),
    benAcNo:new FormControl('',Validators.required),
    benIFSCCode: new FormControl('',Validators.required),
  })
  // get frm(){
  //   return this.searchForm.controls
  // } 
get addfrm(){
    return this.addForm.controls
  } 
  Beneficiaries: Beneficiary[]
  constructor(
    private beneficiaryservice: BeneficiaryService,
    private fb: FormBuilder,

  ) { }

  ngOnInit(): void {
    this.addmode=false;
    this.displayList=true;

    this.listForm = this.fb.group({
      _id: [''],
      name: ['', Validators.required],
      price: ['', Validators.required],
      category: ['', Validators.required]
    })
    this.getBeneficiaryList();

    
  }
  getBeneficiaryList() {
    this.beneficiaryservice.getBeneficiaryList().subscribe((response: Beneficiary[]) => {
      console.log(response);
      this.Beneficiaries = response
    })
  }

  onDeleteBeneficiary(id) {
    if (confirm('Do you want to delete this beneficiary?')) {
        this.beneficiaryservice.deleteBeneficiary(id).subscribe((response)=>{
            this.getBeneficiaryList();
            alert('Deleted successfully');
            location.reload();
           },
          (err) => { console.log(err) }
        

          )
    }    
  }
  callAddBeneficiary() {
    this.addmode=true;
    this.displayList=false;
  }

  submit(){
    this.beneficiaryservice.addBeneficiary(this.addForm.value).subscribe(
     (response) => {
       console.log(response);
       this.getBeneficiaryList();
       this.addmode=false;
       this.displayList=true;
     },
     (err) => { console.log(err) }
   )
   }


}
