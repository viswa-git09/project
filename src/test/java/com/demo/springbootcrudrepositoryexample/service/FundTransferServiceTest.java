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
@ExtendWith(MockitoExtension.class)
class FundTransferServiceTest {
	@InjectMocks
	FundTransferService fundTransferService;
	
	  @Mock RelatedAccountRepository relatedAccountRepository;
	  
	  @Mock MainAccountRepository mainAccountRepository;
	  
	
	@Test
	@DisplayName("FundTransfer:Positive Scenario")
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
	
	/*
	 * @Test
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
