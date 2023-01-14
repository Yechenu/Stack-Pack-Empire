package com.dao;

//import model and conn
import com.model.User;
import com.conn.DBconnect;

import java.io.FileNotFoundException;
//include sql imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//include javax import (it comes from the dependency added in the pom.xml
import javax.servlet.http.HttpServlet;

/* UserDAO.java 
 * This DAO class provides CRUD database operations for 
 * the table users in the database.
 * 
 *  Author: @Diamond Brown
 */

public class UserDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// store the sql statement inside of String variableS. Pass them in the
	// preparedstatement() methods in the following code
	private static final String INSERT_USERS_SQL = "INSERT INTO users (EmployeeID, Email, Username, Password) VALUES (?,?,?,?)"; // <-- the ???? are placeholders
	private static final String SELECT_USER_BY_USERNAME_PASSWORD = "SELECT EmployeeID, Email, Username, Password FROM users WHERE Username=? and Password=?";
	private static final String UPDATE_USERS_BY_PASSWORD = "UPDATE users SET Password = ? where EmployeeID = ?;";

	/*
	 * REGISTER: write method that returns a string. This method will pass the Users
	 * object)
	 */
	public void registerUserDB(User model)
			throws SQLException {
	
		int rowCount = 0;
		try {
			// Instantiate connection object created in the DBconnect.java file
			Connection conn = DBconnect.getConn();
			
			// Instantiate PreparedStatement object. Allows you to send statements to MySql
			PreparedStatement pst = conn.prepareStatement(INSERT_USERS_SQL); // <-- the ? are placeholders
			System.out.println(INSERT_USERS_SQL);
			
			// the get methods replace the placeholder fields ("?,?,?,?")
			pst.setInt(1, model.getEmployeeID()); int empID= model.getEmployeeID();
			pst.setString(2, model.getEmail()); String email= model.getEmail();
			pst.setString(3, model.getUsername()); String uName= model.getUsername();
			pst.setString(4, model.getPassword()); String password= model.getPassword();

			// Execute statement in MySql
			rowCount = pst.executeUpdate();
			//Prints to console
			System.out.println("NEW USER STORED IN DATABASE: "
					+ "\n\t EMPLOYEE ID: " + empID 
					+ "\n\t EMAIL: " + email
					+ "\n\t USERNAME: " + uName
					+ "\n\t PASSWORD: " + password);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/* LOGIN VALIDATION : return boolean to validate login info*/
	public boolean validateUser(User model) throws FileNotFoundException, ClassNotFoundException {
		
		boolean result = false;
		try {
			// instantiate connection to the database
			Connection con = DBconnect.getConn();
			
			// Instantiate PreparedStatement object. Allows you to send statements to MySql
			PreparedStatement ps = con.prepareStatement(SELECT_USER_BY_USERNAME_PASSWORD);
			System.out.println(SELECT_USER_BY_USERNAME_PASSWORD);
			ps.setString(1, model.getUsername());
			ps.setString(2, model.getPassword());

			// instantiate ResultSet class to execute a query
			ResultSet rs = ps.executeQuery();
			result = rs.next(); // check every row of query results
			
			while (rs.next()) {
				String uName = rs.getString("Username");
				String password = rs.getString("Password");
				//Prints to console
				System.out.println("USERNAME AND PASSWORD MATCH FOUND: \n\t " 
						+ uName + "\n\t" + password );
			}
			// import exception classes
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
		// if results match with query items, login results are 'true' in the db
	}

	/*UPDATE USER PASSWORD: This method is called when the user modifies the password */
	public boolean updateUser(User model) throws SQLException {
		System.out.println(UPDATE_USERS_BY_PASSWORD);
		boolean rowUpdated = false;
		

		try {
			// Instantiate connection object created in the DBconnect.java file
			Connection conn = DBconnect.getConn();

			// Instantiate PreparedStatement object. Allows you to send statements to MySql
			PreparedStatement pst = conn.prepareStatement(UPDATE_USERS_BY_PASSWORD); //

			pst.setInt(1, model.getEmployeeID());
			pst.setString(4, model.getPassword());

			// Execute statement in MySql
			rowUpdated = pst.executeUpdate() > 0;
			System.out.println(model.getEmployeeID() + "\n UPDATED PASSWORD: " 
			+ model.getPassword());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}
}
