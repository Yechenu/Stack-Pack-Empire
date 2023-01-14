package com.dao;

//import model and conn
import com.model.Document;

import com.conn.DBconnect;
//include sql imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//include javax import (it comes from the dependency added in the pom.xml
import javax.servlet.http.HttpServlet;


import java.io.FileNotFoundException;

/* DocuementDAO.java 
 * This DAO class provides CRUD database operations for 
 * the table document in the database.
 * 
 *  Author: @Diamond Brown
 */
//insert document info into Document table
public class DocumentDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static  final String INSERT_DOCUMENT_SQL = "INSERT INTO document (ListType, "
								+ "DocumentType, IssuingAuthority, ExpirationDate"
								+ "DocumentPdf) values (?,?,?,?,?)";

		/*INPUT DOCUMENT INFO: write method that returns a string. This method will
		 * pass the Document object)
		 */
		public int InputFile (Document model)
				throws ClassNotFoundException, FileNotFoundException{
			int rowCount = 0;
			
			//Instantiate connection object created in the DBconnect.java file
			Connection conn = DBconnect.getConn();
			
			try {
				//Instantiate PreparedStatement object. Allows you to send statements to MySql
				PreparedStatement pst= 
						conn.prepareStatement(INSERT_DOCUMENT_SQL);  //<-- the ???? are placeholders
				
				// the get methods replace the space holder fields ^^^
				pst.setString(1, model.getListType());    
				pst.setString(2, model.getDocumentType());
				pst.setString(3, model.getIssuingAuthority());
				pst.setString(4, model.getExpirationDate());
				
				//if there IS a  file ...
				if (model.getDocumentPdf() != null) { // note: add a delete file feature for the document upload.
					//fetch input stream of the uploaded file and set as a blob data type
					pst.setBlob(5, model.getDocumentPdf());
				}
				//Execute statement in MySql
				rowCount = pst.executeUpdate();
				
			} catch (SQLException e) {
				// 
				e.printStackTrace();
			}
			return rowCount;
			}
}

