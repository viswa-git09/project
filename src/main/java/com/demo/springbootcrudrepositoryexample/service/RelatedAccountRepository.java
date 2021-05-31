package com.demo.springbootcrudrepositoryexample.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springbootcrudrepositoryexample.entity.RelatedAccount;

public interface RelatedAccountRepository extends JpaRepository<RelatedAccount, Long> {
	
	
	
	  @Query("select accountNumber from RelatedAccount where accountNumber=:accountNumber") 
	  public
	  Optional<RelatedAccount>findByAccountNumber(@Param("accountNumber")Long accountNumber);
	  @Query("select mainAccountLink from RelatedAccount where accountNumber=:relatedAccountNumber")
	  public Long findByMainAccountLink(@Param("relatedAccountNumber")Long relatedAccountNumber);
	  
	  @Query("select balance from RelatedAccount where accountNumber=:relatedAccountNumber")
	  public Long getBalanceRelatedAccount(@Param("relatedAccountNumber")Long relatedAccountNumber);
	  
	  @Transactional
	  @Modifying
	  @Query(value = "update RelatedAccount set balance=:amount where accountNumber=:relatedAccountNumber")
	  public void updateRelatedAccountBalance(@Param("relatedAccountNumber")Long relatedAccountNumber, 
			  @Param("amount")Long amount);
	 
}

