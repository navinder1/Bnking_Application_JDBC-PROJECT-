package com.bank.service;

import com.bank.entity.Customer;

public interface CustomerOperations {
	
public void saveCustomer(Customer c);
public void updateCustomerField(String feild,String value,long accno);
public void fetchAllCustomer(long accno);
public void deleteCustomer(long accno);

}
