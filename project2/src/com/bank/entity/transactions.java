package com.bank.entity;

import java.sql.Date;

public class transactions {
private int id;
private long accno;
private double balance;
private String type;
private Date trancation_date;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public long getAccno() {
	return accno;
}
public void setAccno(long accno) {
	this.accno = accno;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Date getTrancation_date() {
	return trancation_date;
}
public void setTrancation_date(Date trancation_date) {
	this.trancation_date = trancation_date;
}
public transactions() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "transactions [id=" + id + ", accno=" + accno + ", balance=" + balance + ", type=" + type
			+ ", trancation_date=" + trancation_date + "]";
}
}
