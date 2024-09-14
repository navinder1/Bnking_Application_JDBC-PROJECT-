package com.bank.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utility {
public static String Driver="com.mysql.cj.jdbc.Driver";
public static String url="jdbc:mysql://localhost:3306/bank";
public static String username="root";
public static  String password="Navinder@12";
public static Connection con;
public static Connection fetchConnection() {
	Connection con=null;
	try {
		con = DriverManager.getConnection(url,username,password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	
}
}
