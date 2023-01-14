package com.conn;
//connect to the database with this class 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBconnect {
	public static Connection getConn() {
		Connection con = null;
		String loadDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/demo";
		String dbUSERNAME = "root";
		String dbPASSWORD = "51099Drb!!";
		
		try {
			Class.forName(loadDriver);
			con = DriverManager.getConnection(dbURL, dbUSERNAME, dbPASSWORD);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
		if(con==null) {
			System.out.println("**WHOOPS, JDBC CONNECTION IS NOT ESTABLISHED**");
		}else
			System.out.println("**CONGRATULATIONS, JDBC CONNECTION IS ESTABLISHED**");
		return con;
	}
}
