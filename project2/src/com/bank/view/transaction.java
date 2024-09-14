package com.bank.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bank.service.Utility;

public class transaction {

	/*public static void Deposite(double balance, long accno) {
	    try {
	       
	        Class.forName(Utility.Driver);
	        Connection con = Utility.fetchConnection();
	        String query = "UPDATE customer SET balance = balance + ? WHERE accno = ?";
	        PreparedStatement st = con.prepareStatement(query);
	        st.setDouble(1,balance); 
	        st.setLong(2, accno); 
            int k = st.executeUpdate();
            if (k > 0) {
            	
	            System.out.println("Deposit successful.");
	        } else {
	            System.out.println("Deposit failed. Account not found.");
	        }
	        st.close();
	        con.close();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void Withdraw(double balance, long accno) {
	    try {
	       
	        Class.forName(Utility.Driver);
	        Connection con = Utility.fetchConnection();
	        String query = "UPDATE customer SET balance = balance - ? WHERE accno = ?";
	        PreparedStatement st = con.prepareStatement(query);
	        st.setDouble(1, balance); 
	        st.setLong(2, accno); 
            int k = st.executeUpdate();
            if (k > 0) {
            	
	            System.out.println("Withdraw successful.");
	        } else {
	            System.out.println("Withdraw failed. Account not found.");
	        }
	        st.close();
	        con.close();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}*/
	public static void updateBalance(double balance, long accno, String type, Connection con) throws SQLException {
	    String query = null;

	    if (type.equals("deposit")) {
	        query = "UPDATE customer SET balance = balance + ? WHERE accno = ?";
	    } else if (type.equals("withdraw")) {
	        query = "UPDATE customer SET balance = balance - ? WHERE accno = ?";
	    }

	    PreparedStatement st = con.prepareStatement(query);
	    st.setDouble(1, balance);
	    st.setLong(2, accno);
	    int k = st.executeUpdate();
	    if (k > 0) {
	        System.out.println(type.substring(0, 1).toUpperCase() + type.substring(1) + " successful.");
	    } else {
	        System.out.println(type.substring(0, 1).toUpperCase() + type.substring(1) + " failed.");
	    }
	    st.close();
	}


}
