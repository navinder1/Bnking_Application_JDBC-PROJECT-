package com.bank.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Formatter;

import com.bank.entity.Customer;
import com.bank.service.CustomerOperations;
import com.bank.service.Utility;
import com.mysql.cj.jdbc.PreparedStatementWrapper;

public class CustomerOperationsImpl implements CustomerOperations {

	@Override
	public void saveCustomer(Customer c) {
		if (c.getBalance() == 1000) {
			// TODO Auto-generated method stub
			try {
				Class.forName(Utility.Driver);
				Connection con = Utility.fetchConnection();
				String query = "insert into customer values(?,?,?,?,?,?,?,?,?,?);";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, c.getFullname());
				ps.setLong(2, c.getAccno());
				ps.setString(3, c.getEmail());
				ps.setDouble(4, c.getBalance());
				ps.setDate(5, c.getDob());
				ps.setString(6, c.getAaddress());
				ps.setLong(7, c.getMobo());
				ps.setString(8, c.getEmail());
				ps.setString(9, c.getIdproof());
				ps.setString(10, c.getPassword());
				int res = ps.executeUpdate();
				if (res > 0) {
					System.out.println("Customer created!");
				} else {
					System.out.println("Not created");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("add min amount 1000 to create a account");
		}

	}

	@Override
	public void updateCustomerField(String field, String value, long accno) {
		try {
			Class.forName(Utility.Driver);
			Connection C = Utility.fetchConnection();
			String query1 = "Select balance from customer where accno=?";
			PreparedStatement ps1 = C.prepareStatement(query1);
			ps1.setLong(1, accno);
			ResultSet k1 = ps1.executeQuery();
			if (!k1.next()) {
				System.out.println("Record not in database");
			} else {
				try {
					Class.forName(Utility.Driver);
					Connection con = Utility.fetchConnection();

					String query = "UPDATE customer SET " + field + " = ? WHERE accno = ?";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, value);
					ps.setLong(2, accno);

					int k = ps.executeUpdate();
					if (k > 0) {
						System.out.println("Updated " + field + " successfully!");
					} else {
						System.out.println("Update failed.");
					}

				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fetchAllCustomer(long accno) {
		try {
			Class.forName(Utility.Driver);
			Connection con1 = Utility.fetchConnection();
			String query1 = "Select balance from customer where accno=?";
			PreparedStatement ps1 = con1.prepareStatement(query1);
			ps1.setLong(1, accno);
			ResultSet rs1 = ps1.executeQuery();
			if (!rs1.next()) {
				System.out.println("The CustomerRecord Not Prasent");
			} else {
				try {
					Class.forName(Utility.Driver);
					Connection con = Utility.fetchConnection();
					Statement st = con.createStatement();
					String query = "Select * from customer;";
					ResultSet rs = st.executeQuery(query);
					Formatter headerFmt = new Formatter();
					headerFmt.format("%-15s %-13s %-15s %-20s %-15s %-25s %-20s\n", "Fullname", "Accounttype",
							"Date of Birth", "Address", "Mobile No", "Email", "IdProof");

					System.out.print(headerFmt);
					System.out.println(
							"-----------------------------------------------------------------------------------------------------------------------------------------------------------");
					while (rs.next()) {
						String row = String.format("%-15s %-13s %-15s %-20s %-15d %-25s %-20s\n",
								rs.getString("fullname"), rs.getString("acctype"), rs.getDate("dob").toString(),
								rs.getString("address"), rs.getLong("mbno"), rs.getString("email"),
								rs.getString("idproof"));

						System.out.print(row);
						System.out.println(
								"------------------------------------------------------------------------------------------------------------------------------------------------------------");
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCustomer(long accno) {
		try {
			Class.forName(Utility.Driver);
			Connection con = Utility.fetchConnection();
			String query = "DELETE from customer where accno=? ";
			PreparedStatement st = con.prepareStatement(query);
			st.setLong(1, accno);
			int k = st.executeUpdate();
			if (k > 0) {
				System.out.println("Customer deleted successfully!");
			} else {
				System.out.println("No customer found with the given account number.");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// ctrl+shift+f

}
