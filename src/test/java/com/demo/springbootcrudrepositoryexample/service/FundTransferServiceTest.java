package com.demo.springbootcrudrepositoryexample.service;


import java.util.Optional;

import org.assertj.core.api.Assertions;
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
	void testTransferFund() {
		
		 FundTransferDetails FundTransferDetails = new FundTransferDetails();
		 FundTransferDetails.setAmount(3000L);
		 FundTransferDetails.setMainAccountNumber(123L);
		 FundTransferDetails.setRelatedAccountNumber(111L);
		 Mockito.when(relatedAccountRepository.findByMainAccountLink(Mockito.anyLong())).thenReturn(123L);
		 Optional<MainAccounts> val = Optional.empty();
		Mockito.when(mainAccountRepository
					.findByAccountNumber(Mockito.anyLong())).thenReturn(val );
		 String transferFund = fundTransferService.transferFund(FundTransferDetails );
		Assertions.assertThat(transferFund).isEqualTo("Invalid Main Account");
	}

}
