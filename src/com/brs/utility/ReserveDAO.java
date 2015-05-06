/**
 * <Copyright information>
 * 
 * ALL WORKS © SHIVAJI VARMA[contact@shivajivarma.com]
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import com.brs.entity.BusBean;
import com.brs.entity.ReserveBean;
import com.brs.entity.RouteBean;
import com.brs.utility.exceptions.DBConnectException;
import com.brs.utility.exceptions.EmptyResultSetException;

/**
 * Following class tries to access and modify AccountDetails table in database.
 * 
 * @version 1.0
 */
public class ReserveDAO {

	// Holds database connection object.
	Connection conn;

	/**
	 * Following constructor gets the connection object from DBConnection class
	 * and holds the connection.
	 */
	public ReserveDAO() {
		conn = DBConnection.getConnection();
	}

	public int create(ReserveBean rb)  throws  DBConnectException{
		try {
			PreparedStatement pst = conn.prepareStatement("INSERT INTO reserve VALUES(TID_AUTO.NEXTVAL,?,?,?,?,?)");
				pst.setLong(1, rb.getPid());
				pst.setLong(2, rb.getBid());
				pst.setString(3, rb.getDate());
				pst.setString(4, new SimpleDateFormat("dd/MMM/yyyy").format(Calendar.getInstance().getTime()));
				pst.setInt(5, rb.getSeat());
				pst.executeQuery();
			
				return 1;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		return 0;
	}
	
	/**
	 * Following function deletes ticket in Reserve table for given passenger id
	 * and ticket id
	 * 
	 * @param customerid
	 * @return '1'- if removal of customer is successful, else returns 0.
	 * @throws DBConnectException
	 * @throws EmptyResultSetException.
	 * 
	 */
	public int remove(ReserveBean rb) throws EmptyResultSetException, DBConnectException {
		try {
			Statement st = conn.createStatement();
			int noOfRowsDeleted = st
					.executeUpdate("DELETE FROM reserve WHERE tid="
							+ rb.getTid() + " and pid=" + rb.getPid());
			if (noOfRowsDeleted == 0)
				throw new EmptyResultSetException();
			else
				return 1;
		} catch (SQLException e) {
			throw new DBConnectException("Unable to connect to database");
		}
	}

	public Collection<ReserveBean> findHistory(long pid) throws  DBConnectException {
		
		Collection<ReserveBean> rbs = new ArrayList<ReserveBean>();
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT r.tid, b.bid, r.dt, ro.origin, ro.destination, b.depttime, b.arrtime, r.seat "+
					"FROM reserve r, bus b, route ro "+
					"WHERE r.bid=b.bid and ro.rid=b.rid and pid=? "+ 
					"ORDER BY tid DESC");
			pst.setLong(1, pid);
			
			ResultSet rs = pst.executeQuery(); 
			ReserveBean rb = null;
			BusBean bb = null;
			RouteBean rob = null;
			while (rs.next()) {
				rb = new ReserveBean();
				rb.setTid(rs.getLong("TID"));
				rb.setBid(rs.getLong("BID"));
				rb.setDate(rs.getString("DT"));
				
				bb = rb.getBusBean();
				rob = new RouteBean();
				rob.setOrigin(rs.getString("ORIGIN"));
				rob.setDestination(rs.getString("DESTINATION"));
				bb.setRouteBean(rob);
				bb.setDeptime(rs.getString("DEPTTIME"));
				bb.setArrtime(rs.getString("ARRTIME"));
				rb.setSeat(rs.getInt("SEAT"));
				
				rbs.add(rb);
			} 
	
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return rbs;
	}
	
	
	public Collection<Integer> findSeatsAvailablity(long bid,String date) throws  DBConnectException {
		
		Collection<Integer> occupiedSeats = new ArrayList<Integer>();
		try {
			PreparedStatement pst = conn.prepareStatement("SELECT seat FROM reserve WHERE bid=? and dt=?");
			pst.setLong(1, bid);
			pst.setString(2, date);
			
			ResultSet rs = pst.executeQuery(); 

			while (rs.next()) {		
				occupiedSeats.add(rs.getInt("SEAT"));
			} 
	
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return occupiedSeats;
	}

}
