package com.bank.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.entity.Admin;
import com.bank.entity.Customer;
import com.bank.service.Admin_Operations;
import com.bank.service.Utility;

public class AdminOperationimpl implements Admin_Operations {

	public boolean admin_login(Admin a) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			Class.forName(Utility.Driver);
			con = Utility.fetchConnection();

			String query = "SELECT * FROM admin1 WHERE uname = ? AND password = ?;";
			ps = con.prepareStatement(query);
			ps.setString(1, a.getUname());
			ps.setString(2, a.getPassword());
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					rs.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean customer_Login(Customer c) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			Class.forName(Utility.Driver);
			con = Utility.fetchConnection();

			String query = "SELECT * FROM customer WHERE accno = ? AND password = ?;";
			ps = con.prepareStatement(query);
			ps.setLong(1, c.getAccno());
			ps.setString(2, c.getPassword());
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					rs.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
