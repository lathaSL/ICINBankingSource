package com.icin.accountdtls.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.icin.accountdtls.DAO.BenRepo;
import com.icin.accountdtls.model.Beneficiary;

@Service
public class BenServiceImpl implements BenService {
	  @Autowired
	  private BenRepo repository;
	  @Override
	  public Beneficiary addBenef(Beneficiary benef) {
	    return repository.save(benef);
	  }
	  @Override
	  public Beneficiary getBenefById(int benefId) {
	    return repository.findById(benefId).get();
	  }
	  @Override
	  public List<Beneficiary> getAllBenef(){
	    return repository.findAll();
	  }
	  
	  @Override
	  public void updateBenef(Beneficiary benef) {
	    // check if the benef with the passed id exists or not
	    Beneficiary benefDB = repository.findById(benef.getBenId()).orElseThrow(null);
	    // If benef exists then updated
	    repository.save(benef);
	  }
	  
	  @Override
	  public void deleteBenefById(int benefId) {
	    try {
	      repository.deleteById(benefId);  
	    }catch(DataAccessException ex){
	      throw new RuntimeException(ex.getMessage());
	    }
	  }
	}