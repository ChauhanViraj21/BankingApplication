package com.example.bank.service.accountservice;

import java.util.List;
import com.example.bank.accountDTO.Accountdto;

public interface AccountService {

	Accountdto createAccount(Accountdto a);

	Accountdto findByIdAccount(int id);

	Accountdto deposit(int id, Accountdto accdto);

	Accountdto withdraw(int id, Accountdto accdto);

	List<Accountdto> getAll();

	String deleteAccount(int id);

	List<Accountdto> findByNameAccount(String name);
}
