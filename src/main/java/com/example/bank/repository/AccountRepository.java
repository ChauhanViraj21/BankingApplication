package com.example.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank.accountDTO.Accountdto;
import com.example.bank.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
 
	List<Account> findByName(String name);
}
