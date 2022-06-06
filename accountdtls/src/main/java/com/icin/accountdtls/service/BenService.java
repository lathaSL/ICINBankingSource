package com.icin.accountdtls.service;

import java.util.List;

import com.icin.accountdtls.model.Beneficiary;


public interface BenService {

	Beneficiary addBenef(Beneficiary benef);
	Beneficiary getBenefById(int benefId);
	  void updateBenef(Beneficiary benef);
	  void deleteBenefById(int benefId);
	  List<Beneficiary> getAllBenef();

}