package com.example.bank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.accountDTO.Accountdto;
import com.example.bank.entity.Account;
import com.example.bank.repository.AccountRepository;
import com.example.bank.service.accountservice.AccountService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("account")
public class AccountController {



	@Autowired
	AccountService accountservice;

	@PostMapping("/save")
	public ResponseEntity<Accountdto> saveAccount(@RequestBody Accountdto ac) {
		return new ResponseEntity<>(accountservice.createAccount(ac), HttpStatus.CREATED);
	}

	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Accountdto> getAccountById(@PathVariable int id) {
		return new ResponseEntity<>(accountservice.findByIdAccount(id), HttpStatus.ACCEPTED);
	}
	
	//	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/allacc")
	public ResponseEntity<List<Accountdto>> getMethodName() {
		return new ResponseEntity<>(accountservice.getAll(), HttpStatus.ACCEPTED);
	}

	@PutMapping("deposit/{id}")
	public ResponseEntity<Accountdto> deposit(@PathVariable int id, @RequestBody Accountdto accdto) {
		return new ResponseEntity<Accountdto>(accountservice.deposit(id, accdto), HttpStatus.ACCEPTED);
	}

	@PutMapping("withdraw/{id}")
	public ResponseEntity<Accountdto> withdraw(@PathVariable int id, @RequestBody Accountdto accdto) {
		return new ResponseEntity<Accountdto>(accountservice.withdraw(id, accdto), HttpStatus.ACCEPTED);
	}

	@GetMapping("/findbyname/{name}")
	public ResponseEntity<List<Accountdto>> getMethodName(@PathVariable String name) {
		return new ResponseEntity<>(accountservice.findByNameAccount(name), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable int id) {
		try {
			String message = accountservice.deleteAccount(id);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
