package com.example.bank.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.bank.accountDTO.Accountdto;
import com.example.bank.entity.Account;

@RestControllerAdvice
public class ExceptionHandling {

	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<String> nullPointerexception(AccountNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> arithmeticexception(ArithmeticException e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}

}

class AccountNotFoundException extends RuntimeException {
	public AccountNotFoundException(String message) {
		super(message);
	}
}
