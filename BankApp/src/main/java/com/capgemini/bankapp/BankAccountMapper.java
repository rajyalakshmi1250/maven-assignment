package com.capgemini.bankapp.rowmap;

import com.capgemini.bankapp.client.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.capgemini.bankapp.model.BankAccount;

public class BankAccountMapper implements RowMapper<BankAccount>{

		
	public BankAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
		BankAccount account=new BankAccount();
		account.setAccountId(rs.getLong("account_id"));
		account.setAccountHolderName(rs.getString("customer_name"));
		account.setAccountType(rs.getString("account_type"));
		account.setAccountBalance(rs.getDouble("account_balance"));
			return account;
		}
		
	}