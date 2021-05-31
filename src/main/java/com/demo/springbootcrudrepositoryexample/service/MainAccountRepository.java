package com.demo.springbootcrudrepositoryexample.service;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springbootcrudrepositoryexample.entity.MainAccounts;

public interface MainAccountRepository extends JpaRepository<MainAccounts, Long> {
	
	
	  @Query("select balance from MainAccounts") 
	  public Long checkBalance(Long
	  balance);
	 
	  @Query("select accountNumber from MainAccounts where accountNumber=:mainAccountNumber")
	  public Optional<MainAccounts>findByAccountNumber(@Param("mainAccountNumber")Long mainAccountNumber);
	  @Query("select accountNumber from MainAccounts where accountNumber=:mainAccountNumber")
	  public Long getAccountNumber(@Param("mainAccountNumber")Long mainAccountNumber);
	  
	  @Query("select balance from MainAccounts where accountNumber=:mainAccountNumber")
	  public Long getBalanceMainAccount(@Param("mainAccountNumber")Long mainAccountNumber);
	  
	  @Transactional
	  @Modifying
	  @Query(value = "update MainAccounts set balance= :amount where accountNumber= :mainAccountNumber")
	  public void updateMainAccountBalance(@Param("mainAccountNumber")Long mainAccountNumber, 
			  @Param("amount")Long amount);
	  
}

