package com.demo.springbootcrudrepositoryexample.entity;


public class FundTransferDetails {

	//private MainAccounts mainAccount;
	private Long mainAccountNumber;
	private Long relatedAccountNumber;
	//private RelatedAccount relatedAccount;
	private Long amount;
	/*
	 * public MainAccounts getMainAccount() { return mainAccount; } public void
	 * setMainAccount(MainAccounts mainAccount) { this.mainAccount = mainAccount; }
	 * public RelatedAccount getRelatedAccount() { return relatedAccount; } public
	 * void setRelatedAccount(RelatedAccount relatedAccount) { this.relatedAccount =
	 * relatedAccount;}
	 */
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getMainAccountNumber() {
		return mainAccountNumber;
	}
	public void setMainAccountNumber(Long mainAccountNumber) {
		this.mainAccountNumber = mainAccountNumber;
	}
	public Long getRelatedAccountNumber() {
		return relatedAccountNumber;
	}
	public void setRelatedAccountNumber(Long relatedAccountNumber) {
		this.relatedAccountNumber = relatedAccountNumber;
	}
	
	
}
