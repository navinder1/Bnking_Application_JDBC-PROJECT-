package com.bank.entity;

public class Admin {
private String uname;
private String password;
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Admin(String uname, String password) {
	super();
	this.uname = uname;
	this.password = password;
}
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Admin [uname=" + uname + ", password=" + password + "]";
}

}
