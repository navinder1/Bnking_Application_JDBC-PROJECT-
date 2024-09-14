package com.bank.service;

import com.bank.view.CustomerOperationsImpl;
import com.bank.view.Customer_afterLoginimpl;

public class CustomerFactory {
private static CustomerOperations ref;
private static Customer_afterLoginimpl ref1;
public static void setOperations(CustomerOperations impl) {
	 ref= impl;
}
public static CustomerOperations getImpl() {
	setOperations(new CustomerOperationsImpl());
return ref;
}
public static void setOperations(Customer_afterLoginimpl impl1) {
	 ref1=impl1;
}
public static Customer_afterLoginimpl getImpl1() {
	setOperations(new Customer_afterLoginimpl());
return ref1;
}
}
