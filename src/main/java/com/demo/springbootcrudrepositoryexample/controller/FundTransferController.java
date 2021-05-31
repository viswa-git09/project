package com.demo.springbootcrudrepositoryexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springbootcrudrepositoryexample.entity.FundTransferDetails;
import com.demo.springbootcrudrepositoryexample.entity.MainAccounts;
import com.demo.springbootcrudrepositoryexample.entity.RelatedAccount;
import com.demo.springbootcrudrepositoryexample.service.FundTransferService;

@RestController
@RequestMapping("/ transfer")
public class FundTransferController {
	
	@Autowired
	private FundTransferService fundTransferService;
	
	  @PostMapping("/mainAccount")
	public String saveMainAccountDetails(@RequestBody MainAccounts mainAccounts) {
		MainAccounts mainAccountDetails = fundTransferService.saveMainAccountDetails(mainAccounts);
		if(mainAccountDetails != null) {
			return "Main Account saved";
			
		}
		return "Main Account not saved please try again";
		
	}
	
	  @PostMapping("/relatedAccount")
	public String saveRelatedAccountDetails(@RequestBody RelatedAccount relatedAccount) {
		RelatedAccount relatedAccountDetails = fundTransferService.saveRelatedAccountDetails(relatedAccount);
		if(relatedAccountDetails != null) {
			return "Related Account saved";
			
		}
		return "Related Account not saved please try again";
		
	}
	
	  @PostMapping("/fundTransfer")
	public String transferFund(@RequestBody FundTransferDetails fundTransferDetails) {
		String transferFund = fundTransferService.transferFund(fundTransferDetails);
		return transferFund;
	}
	
}
