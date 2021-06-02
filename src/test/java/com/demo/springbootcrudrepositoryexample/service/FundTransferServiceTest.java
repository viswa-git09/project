package com.demo.springbootcrudrepositoryexample.service;


import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.springbootcrudrepositoryexample.entity.FundTransferDetails;
import com.demo.springbootcrudrepositoryexample.entity.MainAccounts;
import com.demo.springbootcrudrepositoryexample.entity.RelatedAccount;
@ExtendWith(MockitoExtension.class)
class FundTransferServiceTest {
	@InjectMocks
	FundTransferService fundTransferService;
	
	  @Mock RelatedAccountRepository relatedAccountRepository;
	  
	  @Mock MainAccountRepository mainAccountRepository;
	  
	
	@Test
	@DisplayName("FundTransfer:MainAccNotExist")
	void testTransferFund() {
		
		 FundTransferDetails fundTransferDetails = new FundTransferDetails();
		 fundTransferDetails.setAmount(3000L);
		 fundTransferDetails.setMainAccountNumber(123L);
		 fundTransferDetails.setRelatedAccountNumber(111L);
		 Mockito.when(relatedAccountRepository.findByMainAccountLink(Mockito.anyLong())).thenReturn(123L);
		 Optional<MainAccounts> val = Optional.empty();
		Mockito.when(mainAccountRepository
					.findByAccountNumber(Mockito.anyLong())).thenReturn(val );
		 String transferFund = fundTransferService.transferFund(fundTransferDetails );
		Assertions.assertThat(transferFund).isEqualTo("Invalid Main Account");
	}
	
	@Test
	void testTransferFund_Success() {
		
		 FundTransferDetails fundTransferDetails = new FundTransferDetails();
		 fundTransferDetails.setAmount(3000L);
		 fundTransferDetails.setMainAccountNumber(123L);
		 fundTransferDetails.setRelatedAccountNumber(111L);
		 Mockito.when(relatedAccountRepository.findByMainAccountLink(Mockito.anyLong())).thenReturn(123L);
		 MainAccounts val = new MainAccounts();
		 val.setAccountNumber(123L);
		 val.setName("VISHH");
		 val.setBalance(565465L);
		 RelatedAccount val1 = new RelatedAccount();
		 val.setAccountNumber(111L);
		 val.setName("VISHH");
		 val.setBalance(565465L);
		Mockito.when(mainAccountRepository
					.findByAccountNumber(Mockito.anyLong())).thenReturn(Optional.of(val) );
		Mockito.when(relatedAccountRepository.findByAccountNumber(Mockito.anyLong())).thenReturn(Optional.of(val1) );
		Mockito.when(mainAccountRepository.getBalanceMainAccount(Mockito.anyLong())).thenReturn(6000L);
		Mockito.when(relatedAccountRepository.getBalanceRelatedAccount(Mockito.anyLong())).thenReturn(111L);
		Mockito.doNothing()
		.when(mainAccountRepository)
		.updateMainAccountBalance(Mockito.anyLong(),Mockito.anyLong()); 
		Mockito.doNothing()
		.when(relatedAccountRepository).updateRelatedAccountBalance(Mockito.anyLong(),Mockito.anyLong()); 
		String transferFund = fundTransferService.transferFund(fundTransferDetails );
		Assertions.assertThat(transferFund).isEqualTo("Updated the balance in Related Account");
	}
	
	@Test
	void testTransferFund_RelatedAccNotExist() {
		
		 FundTransferDetails fundTransferDetails = new FundTransferDetails();
		 fundTransferDetails.setAmount(3000L);
		 fundTransferDetails.setMainAccountNumber(123L);
		 fundTransferDetails.setRelatedAccountNumber(111L);
		 Mockito.when(relatedAccountRepository.findByMainAccountLink(Mockito.anyLong())).thenReturn(123L);
		 MainAccounts val = new MainAccounts();
		 val.setAccountNumber(123L);
		 val.setName("VISHH");
		 val.setBalance(565465L);
		 Optional<RelatedAccount> val1 = Optional.empty();
		 Mockito.when(relatedAccountRepository.findByAccountNumber(Mockito.anyLong())).thenReturn(val1);
		
		 String transferFund = fundTransferService.transferFund(fundTransferDetails );
		 Assertions.assertThat(transferFund).isEqualTo("Invalid Related Account");
	}
	
	
	/*
	 * @Test8
	 * 
	 * @DisplayName("Save MainAccount") void testsaveMainAccountDetails() {
	 * 
	 * // context
	 * when(relatedAccountRepository.save(any(MainAccounts.class))).thenAnswer(i ->
	 * { MainAccounts mainAccounts = i.getArgument(0); mainAccounts.setId(1L);
	 * mainAccounts = mainAccounts; return mainAccounts; });
	 * 
	 * // event MainAccounts result =
	 * MainAccountRepository.addBeneficiary(beneficiaryDto);
	 * 
	 * verify(beneficiaryRepository).save(beneficiary);
	 * 
	 * // outcome assertEquals(beneficiary, result); }
	 */

}
