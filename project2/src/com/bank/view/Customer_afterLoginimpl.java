package com.bank.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.bank.entity.Customer;
import com.bank.entity.transactions;
import com.bank.service.Customer_after_login;
import com.bank.service.Utility;


public class Customer_afterLoginimpl implements Customer_after_login {

	@Override
	public void resetPassword(Customer c, long accno) {
		// TODO Auto-generated method stub
		try {
			Class.forName(Utility.Driver);
			Connection con = Utility.fetchConnection();
			String query = "UPDATE customer SET password = ? WHERE accno = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, c.getPassword());
			st.setLong(2, accno);
			int k = st.executeUpdate();
			if (k > 0) {
				System.out.println("password reset successfully..");
			} else {
				System.out.println("password not reset try again.....!");
			}
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override

	public void performTransaction(transactions t, double amount, long accno, String operation) {
		try {

			Class.forName(Utility.Driver);
			Connection con = Utility.fetchConnection();
			String balanceQuery = "SELECT balance FROM customer WHERE accno = ?";
			PreparedStatement checkBalanceStmt = con.prepareStatement(balanceQuery);
			checkBalanceStmt.setLong(1, accno);
			ResultSet rs = checkBalanceStmt.executeQuery();
			if (rs.next()) {
				double currentBalance = rs.getDouble("balance");

				switch (operation.toLowerCase()) {
				case "deposit":

					String depositQuery = "INSERT INTO transaction (id, accno, type, balance, date_tra) VALUES (?, ?, ?, ?, ?)";
					PreparedStatement depositStmt = con.prepareStatement(depositQuery);
					depositStmt.setInt(1, t.getId());
					depositStmt.setLong(2, accno);
					depositStmt.setString(3, "deposit");
					depositStmt.setDouble(4, amount);
					Timestamp currentDateTime = Timestamp.valueOf(LocalDateTime.now());
					depositStmt.setTimestamp(5, currentDateTime);

					int depositResult = depositStmt.executeUpdate();
					if (depositResult > 0) {
						System.out.println("Deposit transaction inserted.");
						transaction.updateBalance(amount, accno, "deposit", con);
					} else {
						System.out.println("Failed to insert deposit transaction.");
					}
					depositStmt.close();
					break;

				case "withdraw":
					if (currentBalance >= amount) {
						String withdrawQuery = "INSERT INTO transaction (id, accno, type, balance, date_tra) VALUES (?, ?, ?, ?, ?)";
						PreparedStatement withdrawStmt = con.prepareStatement(withdrawQuery);
						withdrawStmt.setInt(1, t.getId());
						withdrawStmt.setLong(2, accno);
						withdrawStmt.setString(3, "withdraw");
						withdrawStmt.setDouble(4, amount);
						Timestamp currentDateTime1 = Timestamp.valueOf(LocalDateTime.now());
						withdrawStmt.setTimestamp(5, currentDateTime1);					
						int withdrawResult = withdrawStmt.executeUpdate();
						if (withdrawResult > 0) {
							System.out.println("Withdrawal transaction inserted.");
							transaction.updateBalance(amount, accno, "withdraw", con);
						} else {
							System.out.println("Failed to insert withdrawal transaction.");
						}
						withdrawStmt.close();
					} else {
						System.out.println("Insufficient balance for withdrawal.");
					}
					break;

				default:
					System.out.println("Invalid operation. Please choose 'deposit' or 'withdraw'.");
					break;
				}
			} else {
				System.out.println("Account not found.");
			}

			checkBalanceStmt.close();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void perform10t_details(long accno) {
		// TODO Auto-generated method stub
		try {
			Class.forName(Utility.Driver);
			Connection con = Utility.fetchConnection();
			String query = "SELECT * FROM transaction WHERE accno = ? LIMIT 10";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, accno); 
			ResultSet rs = ps.executeQuery(); 
			 System.out.printf("%-5s %-15s %-10s %-15s %-15s%n", "ID", "Account No", "Type", "Balance", "Transaction Date");
		        System.out.println("----------------------------------------------------------------------------");
		        while (rs.next()) {
		            System.out.printf("%-5d %-15d %-10s %-15.2f %-15s%n", 
		                rs.getInt("id"), 
		                rs.getLong("accno"), 
		                rs.getString("type"), 
		                rs.getDouble("balance"), 
		                rs.getDate("date_tra").toString()
		            );
		            System.out.println("--------------------------------------------------------------------------");
		        }
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

	}

}
