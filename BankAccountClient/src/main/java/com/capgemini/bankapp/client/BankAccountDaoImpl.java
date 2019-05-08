package com.capgemini.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.bankapp.dao.BankAccountDao;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.banapp.exception.BankAccountNotFoundException;
import javax.sql.DataSource;
import com.capgemini.bankapp.client.BankAccountClient ;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.capgemini.bankapp.rowmap.*;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class BankAccountDaoImpl implements BankAccountDao 
{
	public JdbcTemplate jdbcTemplate ;
	
	public BankAccountDaoImpl(JdbcTemplate jdbcTemplate)
	{	
		this.jdbcTemplate=jdbcTemplate;
		
	}
        @Override
	public boolean addNewBankAccount(BankAccount account) {
		int result=jdbcTemplate.update("INSERT INTO bankaccounts (customer_name,account_type,account_balance) VALUES(?,?,?)",new Object[]{account.getAccountHolderName(),account. getAccountType(),account.getAccountBalance()}); 
		if(result==1)
                  return true;
              else
                 return false;
	}
         @Override
	public boolean updateAccountDetails(long accountId, String accountHolderName, String accountType) {
		
		String query = "UPDATE bankaccounts SET customer_name='"+accountHolderName+"',account_type='"+accountType+"'WHERE account_id="+accountId;
		int result = jdbcTemplate.update(query);
               if(result==1)
                  return true;
              else
                 return false;
	}
		@Override
	public boolean deleteBankAccount(long accountId) {
		String query = "DELETE FROM bankaccounts WHERE account_id=" + accountId;
		int result = jdbcTemplate.update(query);
		if(result==1)
                  return true;
              else
                 return false;
            
        }

	@Override
	public void updateBalance(long accountId, double newBalance) {
 		 
		
                    jdbcTemplate.update("UPDATE bankaccounts SET account_balance=? WHERE account_id=?",new Object[]{newBalance,accountId});
		
	}

	@Override
	public double getBalance(long accountId) {
		
		
		
		 double balance =jdbcTemplate.queryForObject("select account_balance from bankaccounts where account_id=?",new Object[]{accountId},Double.class);
                 return balance;
		
	}
     
	@Override
	public List<BankAccount> findAllBankAccounts() {
		 List <BankAccount> account = jdbcTemplate.query("SELECT * FROM bankaccounts",new Object[] {},new BankAccountMapper());
		
		return account;
	}

	@Override
	public BankAccount searchAccount(long accountId)  {
		BankAccount account = jdbcTemplate.queryForObject("SELECT * FROM bankaccounts WHERE account_id=?",new Object[]{accountId},new BankAccountMapper());
		
		//throws BankAccountNotFoundException
		return account;
	}

	
}
