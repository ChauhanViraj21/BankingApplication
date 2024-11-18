package com.example.bank.accountDTO;

public class Accountdto {
	private int id;
	private String name;
	private int age;
	private int balance;

	public int getId() {
		return id;
	}
	
	public Accountdto() {}

	public Accountdto(int id, String name, int age, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setId(int id) {
		this.id = id;
	}


}
