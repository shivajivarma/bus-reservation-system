/**
 * ALL WORKS © SHIVAJI VARMA<contact@shivajivarma.com>
 * 
 * PassengerDAO.java
 * 
 * This file contains PassengerDAO class which helps in accessing and
 * modifying Passenger table in database.
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
import java.sql.Statement;

import com.brs.entity.PassengerBean;
import com.brs.utility.exceptions.EmptyResultSetException;

/**
 * Following class tries to access and modify AccountDetails table in database.
 * 
 * @version 1.0
 */
public class PassengerDAO {

	// Holds database connection object.
	Connection conn;

	/**
	 * Following constructor gets the connection object from DBConnection class
	 * and holds the connection.
	 */
	public PassengerDAO() {
		conn = DBConnection.getConnection();
	}

	/**
	 * Following function inserts new passenger tuple into passenger table.
	 * @param acc Account number
	 * @return '1' if insertion is carried out successfully, else returns '0'
	 */
	public int create(PassengerBean pb) {
		try {
			PreparedStatement pst = conn.prepareStatement("INSERT INTO passenger VALUES(pid_auto.NEXTVAL,?,?,?,?,?)");
			
				pst.setString(1, pb.getUsername());
				pst.setString(2, pb.getPassword());
				pst.setString(3, pb.getName());
				pst.setString(4, pb.getEmail());
				pst.setLong(5,pb.getMobile());
				pst.executeQuery();
			
				return 1;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return 0;
	}

	/**
	 * Following function updates account in AccountDetails table.
	 * 
	 * @param acc :Account number
	 * 
	 */
	public void edit(PassengerBean p) {
		try {
			PreparedStatement pst = conn.prepareStatement("UPDATE accountdetails SET"
					+ " customerid=?" 
					+", account_type=?"
					+", opening_balance=?" 
					+", balance_amount=?" 
					+", cardno=?"
					+", pin=?"
					+", checkbook=?"
					+ ", branchid=?"
					+ " where accno=?");

			pst.setString(1, p.getUsername());
			pst.setString(2, p.getPassword());
			pst.setString(3, p.getName());
			pst.setString(4, p.getEmail());
			pst.setLong(5,p.getMobile());
			pst.executeQuery();
		
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	/**
	 * Following function deletes account in AccountDetails table for given
	 * account number.
	 * 
	 * @param accno Account number
	 * @return '1'- if removal of account is successful, else returns 0.
	 */
	public int remove(long accno) {
		try {
			Statement st = conn.createStatement();
			int noOfRowsDeleted = st.executeUpdate("DELETE FROM accountdetails WHERE accno="+ accno);

			if (noOfRowsDeleted == 1) {
				return 1;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return 0;
	}

	/**
	 * Following function retrieves account in AccountDetails table for given
	 * account number.
	 * @param accno Account number
	 * @return AccountDetails object.
	 * @throws EmptyResultSetException 
	 */
	public PassengerBean findByUsername(String username)
			throws EmptyResultSetException {
		
		PassengerBean pb = null;
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM passenger WHERE username=?");
			pst.setString(1, username);
			
			ResultSet rs = pst.executeQuery(); 
			
			if (rs.next()) {
				pb = new PassengerBean();
				pb.setPid(rs.getLong("PID"));
				pb.setUsername(rs.getString("USERNAME"));
				pb.setPassword(rs.getString("PASSWORD"));
				pb.setName(rs.getString("NAME"));
				pb.setEmail(rs.getString("EMAIL"));
				pb.setMobile(rs.getLong("MOBILE"));
			} else
				throw new EmptyResultSetException();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return pb;
	}

}
