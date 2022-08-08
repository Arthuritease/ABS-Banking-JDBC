package com.ncs.controller;


public class TransList {
	int id;
	int amount;
	int uniqueTransID;
	int filterID;
	String type;

	String username;
	
	


	@Override
	public String toString() {
		return "TransList [id=" + id + ", amount=" + amount + ", uniqueTransID=" + uniqueTransID + ", filterID="
				+ filterID + ", type=" + type + ", username=" + username + "]";
	}
	public int getFilterID() {
		return filterID;
	}
	public void setFilterID(int filterID) {
		this.filterID = filterID;
	}
	public int getUniqueTransID() {
		return uniqueTransID;
	}
	public void setUniqueTransID(int uniqueTransID) {
		this.uniqueTransID = uniqueTransID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
