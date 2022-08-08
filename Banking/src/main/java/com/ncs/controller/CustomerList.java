package com.ncs.controller;

public class CustomerList {
	int id;
	String name;
	String username;
	String password;
	String email;
	int balance;
	String secA;
	int activeLoan;



	@Override
	public String toString() {
		return "CustomerList [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", balance=" + balance + ", secA=" + secA + ", activeLoan=" + activeLoan + "]";
	}
	public int getActiveLoan() {
		return activeLoan;
	}
	public void setActiveLoan(int activeLoan) {
		this.activeLoan = activeLoan;
	}
	public String getSecA() {
		return secA;
	}
	public void setSecA(String secA) {
		this.secA = secA;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
