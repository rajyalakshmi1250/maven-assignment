package com.capgemini.bankapp.service;

import java.util.List;

import com.capgemini.banapp.exception.BankAccountNotFoundException;
import com.capgemini.banapp.exception.LowBalanceException;
import com.capgemini.bankapp.model.BankAccount;

public interface BankAccountService {
        public boolean addNewBankAccount(BankAccount account);

	public boolean updateAccount(long accountId, String accountHolderName, String accountType);

	
	public boolean deleteBankAccount(long accountId) throws BankAccountNotFoundException;

	public double withdraw(long accountId, double amount) throws LowBalanceException, BankAccountNotFoundException;

	public double deposit(long accountId, double amount) throws BankAccountNotFoundException;
	 
	 public double checkBalance(long accountId) throws BankAccountNotFoundException;


	

	
	public double fundTransfer(long fromAccount, long toAccount, double amount)
			throws LowBalanceException, BankAccountNotFoundException;

	

	public List<BankAccount> findAllBankAccounts();

	public BankAccount searchAccount(long accountId) throws BankAccountNotFoundException;

	

}
