package com.bank.entity;

import java.sql.Date;

public class Customer {
private String fullname;
private long accno;
private String acctype;
private  double balance;
private Date dob;
private String Aaddress;
private long mobo;
private String email;
private String idproof;
private String password;
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Customer(int id) {
	super();
	this.id = id;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public long getAccno() {
	return accno;
}
public void setAccno(long accno) {
	this.accno = accno;
}
public String getAcctype() {
	return acctype;
}
public void setAcctype(String acctype) {
	this.acctype = acctype;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getAaddress() {
	return Aaddress;
}
public void setAaddress(String aaddress) {
	Aaddress = aaddress;
}
public long getMobo() {
	return mobo;
}
public void setMobo(long mobo) {
	this.mobo = mobo;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getIdproof() {
	return idproof;
}
public void setIdproof(String idproof) {
	this.idproof = idproof;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Customer(String fullname, long accno, String acctype, double balance, Date dob, String aaddress, long mobo,
		String email, String idproof, String password) {
	super();
	this.fullname = fullname;
	this.accno = accno;
	this.acctype = acctype;
	this.balance = balance;
	this.dob = dob;
	Aaddress = aaddress;
	this.mobo = mobo;
	this.email = email;
	this.idproof = idproof;
	this.password = password;
}
public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Customer [fullname=" + fullname + ", accno=" + accno + ", acctype=" + acctype + ", balance=" + balance
			+ ", dob=" + dob + ", Aaddress=" + Aaddress + ", mobo=" + mobo + ", email=" + email + ", idproof=" + idproof
			+ ", password=" + password + "]";
}

}
