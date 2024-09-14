package com.bank.view;

import java.util.Scanner;

import com.bank.entity.Admin;
import com.bank.entity.Customer;
import com.bank.service.AdminFactory;
import com.bank.service.Admin_Operations;

public class Admin_register {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Admin_Operations op=AdminFactory.getImpl();
	while(true) {
		System.out.println("Welcom");
		
		System.out.println("1.Admin_Login");
		System.out.println("2.Login_Customer");
		System.out.println("3.Exit Application");
		System.out.println("Choose any one option");
		int option=sc.nextInt();
		
		   if(option==1) {
			Admin a= new Admin();
			System.out.println("Enter user id:");
	        String username = sc.next();
	        System.out.println("Enter password:");
	        String password = sc.next();
	        a.setUname(username);
            a.setPassword(password);
            
            boolean loginSuccess = op.admin_login(a);
            
            if (loginSuccess) {
               BankingApplication.Customer();
               break;
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
            break;
        }
		   if(option==2) {
				Customer c= new Customer();
				System.out.println("Enter Account number:");
		        Long accno = sc.nextLong();
		        System.out.println("Enter password:");
		        String password = sc.next();
		        c.setAccno(accno);
	            c.setPassword(password);
	            
	            boolean loginSuccess = op.customer_Login(c);
	            
	            if (loginSuccess) {
	               Customer_Loginoperations.customerOperations();
	               break;
	            } else {
	                System.out.println("Invalid credentials. Please try again.");
	            }
	            break;
	        }
		   if(option==3) {
			   System.out.println("Exited from Application");
			   return;
		   }
		}
		}
	}


