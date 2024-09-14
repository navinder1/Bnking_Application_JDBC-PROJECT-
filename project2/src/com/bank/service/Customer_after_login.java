package com.bank.service;

import com.bank.entity.Customer;
import com.bank.entity.transactions;

public interface Customer_after_login {
public void resetPassword(Customer c,long accno);
public void performTransaction(transactions t, double amount, long accno, String operation);
public void perform10t_details(long accno);
}
