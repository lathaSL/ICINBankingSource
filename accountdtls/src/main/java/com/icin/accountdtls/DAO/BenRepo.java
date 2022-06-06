package com.icin.accountdtls.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icin.accountdtls.model.Beneficiary;

public interface BenRepo extends JpaRepository<Beneficiary, Integer>{ 

}
