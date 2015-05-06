/**
 * <Copyright information>
 * 
 * ALL WORKS © SHIVAJI VARMA[contact@shivajivarma.com]
 * 
 * DBConnection.java
 * 
 * This file contains DBConnection class with helps in connecting to database.
 * 
 * Version 1.0
 * 
 * Created on 31 AUG 2012
 * 
 * <Modification History>
 */

package com.brs.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.brs.utility.exceptions.DBConnectException;

/**
 * Following class tries to establish connection with database, And holds the
 * connection until the DBconnect object is been disposed.
 * 
 * @version 1.0
 * @author Shivaji Varma[contact@shivajivarma.com]
 */
public class DBConnection {

	// 'conn' holds reference to database connection object.
	static Connection conn;

	/**
	 * The following Constructor tries to establish connection with database when a Object is created 
	 * and closes the connection when it is destroyed.
	 * 
	 * Handles ClassNotFoundException when Oracle driver files are missing in
	 * library.
	 * 
	 * Handles SQLException when database is not running (or) when there is no
	 * access to database (or) when database login credentials specified are incorrect.
	 * 
	 * @throws DBConnectException 
	 */
	public DBConnection() throws DBConnectException{
		BufferedReader dbConfig = null;
		try {
			dbConfig = new BufferedReader(new FileReader("db.config"));
			
			Class.forName(dbConfig.readLine());
			if(conn==null){
				conn = DriverManager.getConnection(
						dbConfig.readLine(), dbConfig.readLine(), dbConfig.readLine());
				System.out.println("Database connected");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException cnfe) {
			throw new DBConnectException("Oracle Driver Not Found");
		} catch (SQLException sqle) {
			throw new DBConnectException("Unable to establish connection. Contact support.");
		} finally{
			if(dbConfig != null)
				try {
					dbConfig.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/**
	 * The following function returns database connection object, which is used
	 * through out the application to communicate with database.
	 * 
	 * @return database Connection object.
	 */
	public static Connection getConnection() {
		return conn;
	}

	
	/**
	 * The following function releases the database connection when Object of DBConnect 
	 * class is destroyed.
	 */
	protected void finalize() {
		try {
			System.out.println("Database disconnected");
			conn.close();
			conn=null;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
