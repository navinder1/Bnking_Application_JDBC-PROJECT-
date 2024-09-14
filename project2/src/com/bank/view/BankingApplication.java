package com.bank.view;

import java.sql.Date;
import java.util.Scanner;

import com.bank.entity.Customer;
import com.bank.service.CustomerFactory;
import com.bank.service.CustomerOperations;

public class BankingApplication {
	public static void Customer() {

		Scanner sc = new Scanner(System.in);
		CustomerOperations op = CustomerFactory.getImpl();
		while (true) {
			System.out.println("1.Create account");
			System.out.println("2.update");
			System.out.println("3.fetch");
			System.out.println("4.delete");
			System.out.println("5.logout");

			System.out.println("choose one option");
			int option = sc.nextInt();
			switch (option) {
			case 1: {

				Customer c1 = new Customer();
				System.out.println("enter name");
				c1.setFullname(sc.next());
				System.out.println("enter account no");
				c1.setAccno(sc.nextLong());
				System.out.println("Address");
				c1.setAaddress(sc.next());
				System.out.println("enter Balance");
				c1.setBalance(sc.nextDouble());
				System.out.println("Enter mobile");
				c1.setMobo(sc.nextLong());
				System.out.println("enter Account type");
				c1.setAcctype(sc.next());
				System.out.println("enter password");
				c1.setPassword(sc.next());
				System.out.println("idproof");
				c1.setIdproof(sc.next());
				System.out.println("enter date of birth");
				c1.setDob(Date.valueOf(sc.next()));
				System.out.println("enter email");
				c1.setEmail(sc.next());
				op.saveCustomer(c1);
				break;
			}
			case 2: {
				Customer c1 = new Customer();
				Scanner sc1 = new Scanner(System.in);

				System.out.println("Enter the account number for update confirmation:");
				long accno = sc1.nextLong();
				System.out.println("Which detail would you like to update?");
				System.out.println("1. Name");
				System.out.println("2. Address");
				System.out.println("3. Mobile Number");
				System.out.println("4. Account Type");
				System.out.println("5. ID Proof");
				System.out.println("6. Date of Birth");
				System.out.println("7. Email");

				int choice = sc1.nextInt();
				sc1.nextLine();

				switch (choice) {
				case 1:
					System.out.println("Enter new name:");
					String name = sc1.nextLine();
					op.updateCustomerField("fullname", name, accno);
					break;

				case 2:
					System.out.println("Enter new address:");
					String address = sc1.nextLine();
					op.updateCustomerField("address", address, accno);
					break;

				case 3:
					System.out.println("Enter new mobile number:");
					long mobile = sc1.nextLong();
					op.updateCustomerField("mobile", String.valueOf(mobile), accno);
					break;

				case 4:
					System.out.println("Enter new account type:");
					String acctype = sc1.nextLine();
					op.updateCustomerField("acctype", acctype, accno);
					break;

				case 5:
					System.out.println("Enter new ID proof:");
					String idproof = sc1.nextLine();
					op.updateCustomerField("idproof", idproof, accno);
					break;

				case 6:
					System.out.println("Enter new date of birth (yyyy-mm-dd):");
					String dob = sc1.nextLine();
					op.updateCustomerField("dob", dob, accno);
					break;

				case 7:
					System.out.println("Enter new email:");
					String email = sc1.nextLine();
					op.updateCustomerField("email", email, accno);
					break;

				default:
					System.out.println("Invalid choice.");
				}

				break;
			}

			case 3: {
				
				System.out.println("enter Accound number");
				long accno = sc.nextLong();
				op.fetchAllCustomer(accno);
			}
			case 4: {
				Customer c1 = new Customer();
				System.out.println("enter account number");
				long accno = sc.nextLong();
				op.deleteCustomer(accno);
				// op.fetchAllCustomer();
				break;

			}
			case 5: {
				System.out.println("Successfully Logout..!");
				return;
			}
			}
		}

	}
}
