package com.example.bank.mapper;

import com.example.bank.accountDTO.Accountdto;
import com.example.bank.entity.Account;

public class AccountMapper {

	public static Account mapToAccount(Accountdto accountdto) {
		Account acc = new Account(accountdto.getId(), accountdto.getName(), accountdto.getAge(),
				accountdto.getBalance());
		return acc;
	}
	
	
	public static Accountdto mapToAccountdto(Account account)
	{
		Accountdto acc = new Accountdto(account.getId(), account.getName(), account.getAge(), account.getBalance());
		return acc;
	}
}
