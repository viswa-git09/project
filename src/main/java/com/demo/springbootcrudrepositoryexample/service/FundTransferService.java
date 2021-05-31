package com.demo.springbootcrudrepositoryexample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.springbootcrudrepositoryexample.entity.FundTransferDetails;
import com.demo.springbootcrudrepositoryexample.entity.MainAccounts;
import com.demo.springbootcrudrepositoryexample.entity.RelatedAccount;

@Service
public class FundTransferService {
	
	@Autowired
	private MainAccountRepository mainAccountRepository;
	
	@Autowired
	private RelatedAccountRepository relatedAccountRepository;

	public MainAccounts saveMainAccountDetails(MainAccounts mainAccounts) {
		return mainAccountRepository.save(mainAccounts);
	}

	public RelatedAccount saveRelatedAccountDetails(RelatedAccount relatedAccount) {
		return relatedAccountRepository.save(relatedAccount);
	}

	  public String transferFund(FundTransferDetails fundTransferDetails) {
		  Long mainAccountLink = relatedAccountRepository.findByMainAccountLink(fundTransferDetails.getRelatedAccountNumber());
		  if(mainAccountLink.equals(fundTransferDetails.getMainAccountNumber())) {
			  String debitMainAccount = debitMainAccount(fundTransferDetails.getMainAccountNumber(), fundTransferDetails.getAmount());
			  if("Updated the balance in Main Account".equals(debitMainAccount)) {
				  return  creditRealtedAccount(fundTransferDetails.getRelatedAccountNumber(), fundTransferDetails.getAmount());
			  }else {
				  return debitMainAccount;
			  }
		  }else {
			  return "Related Account is not linked MainAccount";
		  }
	  }
	  
	public String creditRealtedAccount(Long toAccount, Long amount)  {

		if (isRelatedAccountExists(toAccount)) {
			Long relatedAccountBalance = getRelatedAccountBalance(toAccount);
				Long updatedAmount = relatedAccountBalance + amount;
				relatedAccountRepository.updateRelatedAccountBalance(toAccount, updatedAmount);
				return "Updated the balance in Related Account";
			} else {
				return "Invalid Related Account";
			}
	}
	
	public Long getRelatedAccountBalance(Long fromAccount) {
		return relatedAccountRepository.getBalanceRelatedAccount(fromAccount);
	}
	
	private boolean isRelatedAccountExists(Long toAccount) {
		Optional<RelatedAccount> findByAccountNumber = relatedAccountRepository.findByAccountNumber(toAccount);
		if (findByAccountNumber.isPresent()) {
			return true;
		}
		return false;

	}

	public String debitMainAccount(Long fromAccount, Long amount) {
		if (isMainAccountExists(fromAccount)) {
			Long mainAccountBalanceCheck = getMainAccountBalance(fromAccount);
			if (mainAccountBalanceCheck == amount || mainAccountBalanceCheck >= amount) {
				Long updatedAmount = mainAccountBalanceCheck - amount;
				mainAccountRepository.updateMainAccountBalance(fromAccount, updatedAmount);
				return "Updated the balance in Main Account";
			} else {
				return "Insufficient Funds in Main Account";
			}
		} else {
			return "Invalid Main Account";
		}
	} 

		public Long getMainAccountBalance(Long fromAccount) {
			return mainAccountRepository.getBalanceMainAccount(fromAccount);
		}

		public boolean isMainAccountExists(Long fromAccount) {
			Optional<MainAccounts> findByAccountNumber = mainAccountRepository
					.findByAccountNumber(fromAccount);
			if (findByAccountNumber.isPresent()) {
				return true;
			}
			return false;
		}
}
