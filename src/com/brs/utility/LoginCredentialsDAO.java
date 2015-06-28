/**
 * ALL WORKS © SHIVAJI VARMA<contact@shivajivarma.com>
 * 
 * LoginCredentialsDAO.java
 * 
 * This file Contains LoginCredentialsDAO class when helps in accessing LoginCredentials table in database 
 * and validates administrator login credentials.
 * 
 * Version 1.0
 * 
 * Created on 3 SEP 2012
 * 
 * <Modification History>
 */

package com.brs.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.brs.utility.exceptions.EmptyResultSetException;

/**
 * The following class provides way to Login and to modify LoginCredentials
 * table in Database
 * 
 * @version 1.0
 */
public class LoginCredentialsDAO {

	// Holds connection object
	Connection conn;

	/**
	 * Following constructor gets the connection object from DBConnection class
	 * and holds the connection.
	 */
	public LoginCredentialsDAO() {
		conn = DBConnection.getConnection();
	}

	/**
	 * Following function retrieves Login Credentials from database.
	 * 
	 * @param username: username of passenger.
	 * 
	 * @return '0'- if password is not valid, '1'- if login credentials are valid.
	 * @throws EmptyResultSetException 
	 * 
	 */
	public String fetchPassword(String username) throws EmptyResultSetException {

		try {
			PreparedStatement pst = conn.prepareStatement("SELECT PASSWORD from PASSENGER where username=?");
			pst.setString(1, username);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getString("PASSWORD"); 
			} else{
				throw new EmptyResultSetException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}