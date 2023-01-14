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
	

	// store the sql statement inside of String variableS. Pass them in the preparedstatement() methods in the following code
	private static final String INSERT_USERS_SQL = "INSERT INTO users (EmployeeID, Email Username, Password) VALUES (?,?,?,?)"; //<-- the ? are placeholders
	private static final String SELECT_USER_BY_ID ="SELECT * FROM user WHERE Username=? and Password=?";
	private static final String UPDATE_USERS_BY_PASSWORD = "UPDATE users SET Password = ? where EmployeeID = ?;";

	/* REGISTER: write method that returns a string. This method will pass the Users
	 * object)
	 */
	public void  insertUser(User model)
			throws SQLException{
		System.out.println(INSERT_USERS_SQL);		
		int rowCount = 0;
		//Instantiate connection object created in the DBconnect.java file
		Connection conn = DBconnect.getConn();
		
		try {
			//Instantiate PreparedStatement object. Allows you to send statements to MySql
			PreparedStatement pst= 
					conn.prepareStatement(INSERT_USERS_SQL);  //<-- the ? are placeholders
			
			// the get methods replace the placeholder fields ("?,?,?,?")
			pst.setString(1, model.getEmployeeID());    
			pst.setString(2, model.getEmail());
			pst.setString(3, model.getUsername());
			pst.setString(4, model.getPassword());

			//Execute statement in MySql
			rowCount = pst.executeUpdate();

			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	//LOGIN: return booelan to validate login info 
	public boolean validateUser(User model) throws FileNotFoundException, ClassNotFoundException {
		System.out.println(SELECT_USER_BY_ID);
		boolean result = false;
		//instantiate connection to the database
		
		Connection con = DBconnect.getConn();
	
		try {
		
			PreparedStatement ps = con.prepareStatement(SELECT_USER_BY_ID);
			ps.setString(1, model.getUsername());
			ps.setString(2, model.getPassword());
			
			//instantiate ResultSet class to execute a query
			ResultSet rs=ps.executeQuery();
			result = rs.next(); //check every row of query results
		
		//impoort exception classes 
		}catch (SQLException e){
			
			e.printStackTrace();
		}
		return result;   
		//if results match with query items, login results are 'true' in the db
	}

	/*This method is called when the user modifies the password*/
	public boolean updateUser(User model) throws SQLException{
		System.out.println(UPDATE_USERS_BY_PASSWORD);
		boolean rowUpdated = false;
			//Instantiate connection object created in the DBconnect.java file
		Connection conn = DBconnect.getConn();
		
		try {
			
			//Instantiate PreparedStatement object. Allows you to send statements to MySql
			PreparedStatement pst= 
					conn.prepareStatement(UPDATE_USERS_BY_PASSWORD);  //
	
			pst.setString(1, model.getEmployeeID());    
			pst.setString(4, model.getPassword());

			//Execute statement in MySql
			rowUpdated = pst.executeUpdate() > 0;

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}
	
}
