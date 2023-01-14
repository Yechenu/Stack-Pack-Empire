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



public class UserDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//REGISTER: write method that returns a string. This method will pass the Users object)
	public String  Register(User model)
			throws ClassNotFoundException, FileNotFoundException{
		int rowCount = 0;
		
		//Instantiate connection object created in the DBconnect.java file
		Connection conn = DBconnect.getConn();
		
		try {
			//Instantiate PreparedStatement object. Allows you to send statements to MySql
			PreparedStatement pst= 
					conn.prepareStatement("insert into users (EmployeeID, "
							+ "username, password) values (?,?,?,?)");  //<-- the ? are placeholders
			
			// the get methods replace the space holder fields ^^^
			pst.setString(1, model.getEmployeeID());    
			pst.setString(2, model.getEmail());
			pst.setString(3, model.getUsername());
			pst.setString(4, model.getPassword());

			//Execute statement in MySql
			rowCount = pst.executeUpdate();

			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if (rowCount != 0) {
			return "User is registered";
		} else {
			return "Error!!!!";   //if the row is empty (0), there was an error

		}
	}
	//LOGIN: return booelan to validate login info 
	public boolean Login(User model) throws FileNotFoundException, ClassNotFoundException {
		
		
		boolean result = false;
		//instantiate connection to the database
		
		Connection con = null;
		
		
		//store the sql statement inside of String variable "sql"
		String sql = "select * from user where username=? and password=?";
		
		try {
			con = DBconnect.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
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
	
}
