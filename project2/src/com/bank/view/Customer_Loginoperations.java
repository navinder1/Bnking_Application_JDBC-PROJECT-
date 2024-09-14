package com.bank.view;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.bank.entity.Customer;
import com.bank.entity.transactions;
import com.bank.service.CustomerFactory;

public class Customer_Loginoperations {
	public static void customerOperations() {
		Scanner sc = new Scanner(System.in);
		Customer_afterLoginimpl op = CustomerFactory.getImpl1();
		while (true) {
			System.out.println("1.Password Reset");
			System.out.println("2.transactions");
			System.out.println("3.fetch transactions");
			System.out.println("choose one option");
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				Customer c = new Customer();
				System.out.println("enter account number:");
				long accno = sc.nextLong();
				sc.nextLine();
				System.out.println("enter new password:");
				c.setPassword(sc.nextLine());
				op.resetPassword(c, accno);
			}

			case 2: {
				transactions t = new transactions();
				System.out.println("Enter transaction ID:");
				t.setId(sc.nextInt());
				sc.nextLine();
				System.out.println("Type of transaction (deposit/withdraw):");
				String transactionType = sc.nextLine().toLowerCase();
				t.setType(transactionType);
				System.out.println("Enter amount:");
				double amount = sc.nextDouble();
				System.out.println("Enter account number:");
				long accno = sc.nextLong();
				op.performTransaction(t, amount, accno, transactionType);
				break;
			}
			case 3:
				System.out.println("enter account number");
				long accno=sc.nextLong();
				op.perform10t_details(accno);
				break;
			}
		}
	}
}
