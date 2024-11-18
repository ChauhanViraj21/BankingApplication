package com.example.bank.service.accountimplimantation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.accountDTO.Accountdto;
import com.example.bank.entity.Account;
import com.example.bank.mapper.AccountMapper;
import com.example.bank.repository.AccountRepository;
import com.example.bank.service.accountservice.AccountService;

@Service
public class AccountServiceImplemantation implements AccountService {

	@Autowired
	AccountRepository accountrepository;

	@Override
	public Accountdto createAccount(Accountdto accountdto) {
		Account account = AccountMapper.mapToAccount(accountdto);
		Account save = accountrepository.save(account);
		return AccountMapper.mapToAccountdto(save);
	}

	@Override
	public List<Accountdto> getAll() {
		List<Account> all = accountrepository.findAll();

		if (!all.isEmpty()) {
			return all.stream().map((account) -> AccountMapper.mapToAccountdto(account)).collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public Accountdto findByIdAccount(int id) {
		Optional<Account> byId = accountrepository.findById(id);
		byId.orElseThrow(() -> new RuntimeException("No account found with this id " + id));
		Account account = byId.get();
		return AccountMapper.mapToAccountdto(account);

	}

	@Override
	public Accountdto deposit(int id, Accountdto accdto) {
		Optional<Account> byId = accountrepository.findById(id);
		Account acc = byId.orElseThrow(() -> new RuntimeException("No account found with this id " + id));
		
		int accbal = acc.getBalance();
		int newBal = accbal + accdto.getBalance();
		acc.setBalance(newBal);
		accountrepository.save(acc);
		return AccountMapper.mapToAccountdto(acc);
	}

	@Override
	public Accountdto withdraw(int id,Accountdto accdto) {
		Optional<Account> byId = accountrepository.findById(id);
		Account acc = byId.orElseThrow(() -> new RuntimeException("No account found with this id " + id));
		
		int accbal = acc.getBalance();
		if (accbal >= accdto.getBalance()) {
			int newbal = accbal - accdto.getBalance();
			acc.setBalance(newbal);
			accountrepository.save(acc);
		}
		else
		{
			return null;
		}
		return AccountMapper.mapToAccountdto(acc);
	}

	@Override
	public String deleteAccount(int id) {
		Optional<Account> byId = accountrepository.findById(id);
		Account acc = byId.orElseThrow(() -> new RuntimeException("No account found with this id " + id));
		accountrepository.deleteById(id);
		return "account deleted successfully";
	}

	@Override
	public List<Accountdto> findByNameAccount(String name) {
		List<Account> accbyname = accountrepository.findByName(name);
		if (accbyname!=null) {
			return accbyname.stream().map((account) -> AccountMapper.mapToAccountdto(account)).collect(Collectors.toList());
		}
		else
		{
			return null;
		}
	}

}
